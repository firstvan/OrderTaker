package hu.firstvan.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Bridge between model and database.
 */
public class DatabaseDAO implements IDatabaseDAO {

    /**
     * This is a static variable to logging.
     */
    private static Logger logger = LoggerFactory.getLogger(DatabaseDAO.class);

    /**
     * Get all customer from database.
     *
     * @return ArrayList of all customer.
     */
    public ArrayList<Customer> getAllCustomer() {

        ArrayList<Customer> ret = new ArrayList<>();


        try (Connection connection = ConnectionFactory.getConnection()) {

            Statement st;
            st = connection.createStatement();
            String sql_query = "select * from p_vasarlok";
            ResultSet rs = st.executeQuery(sql_query);
            while (rs.next()) {
                ret.add(new Customer(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getDate(5)));
            }

            st.close();
            rs.close();
            logger.info("Get all user from database is done.");
        } catch (SQLException e) {
            logger.error("Cannot get users from database.");
            e.printStackTrace();
        }

        return ret;
    }

    /**
     * Add a customer to the database. The first order date is the sysdate.
     *
     * @param customer customer to add database
     */
    public void AddCustomer(Customer customer) {

        try (Connection connection = ConnectionFactory.getConnection()) {
            Statement statement = connection.createStatement();

            String sql = "Insert into p_vasarlok" +
                    "(nev, szul_datum, csatlakozas_datuma, szallitasi_cim)" +
                    "values ('" + customer.getC_name() + "', to_date('" + customer.getC_startDate().toString() + "'" +
                    ",'yyyy-mm-dd'), sysdate, '" + customer.getC_addr() + "')";

            statement.executeUpdate(sql);
            statement.close();
            logger.info("Added a new user to database");
        } catch (SQLException e) {
            logger.error("Cannot add new user to database.");
            e.printStackTrace();
        }

    }

    /**
     * Return all orders of customer by id.
     *
     * @param userid customers id
     * @return list of customer orders.
     */
    public ArrayList<Orders> GetUserOrders(int userid) {

        ArrayList<Orders> ret = new ArrayList<>();
        String sql = "select * from p_rendelesek where vasarlo_id=" + userid;

        try (Connection connection = ConnectionFactory.getConnection()) {
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            while (resultSet.next()) {
                ret.add(new Orders(resultSet.getInt(1), resultSet.getInt(2), resultSet.getDate(3), resultSet.getInt(4)));
            }

            stmt.close();
            resultSet.close();
            logger.info("Get all orders of customer is done.");
        } catch (SQLException e) {
            logger.error("Cannot get orders from database.");
            e.printStackTrace();
        }

        return ret;
    }

    /**
     * Search item by item name. If we call's this function by "", we get back all of the products.
     *
     * @param name item name
     * @return list of the searched item (or all items)
     */
    public ArrayList<Products> getSearchedProducts(String name) {

        ArrayList<Products> ret = new ArrayList<>();
        String sql = "select * from p_termekek where T_NEV like '%" + name + "%'";

        try (Connection connection = ConnectionFactory.getConnection()) {
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            while (resultSet.next()) {
                ret.add(new Products(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getString(5),
                        resultSet.getInt(6), resultSet.getInt(7), resultSet.getInt(8), resultSet.getInt(9), resultSet.getInt(10), resultSet.getInt(11)));


            }

            stmt.close();
            resultSet.close();
            logger.info("Get searched products from database.");
        } catch (SQLException e) {
            logger.error("Cannot get searched product from database.");
            e.printStackTrace();
        }

        return ret;

    }

    /**
     * Close the order. It takes to the database the order.
     */
    public void closeOrder() {
        if (!Datas.getOrderedItems().isEmpty()) {


            String sql = "insert into p_rendelesek (DATUM, rendeles_id, vasarlo_id, vegosszeg) values (sysdate, rendeles_seq.nextval, "
                    + Datas.getCustomer().getC_id() + " ," + Datas.getGrandTotal() + ")";

            try (Connection connection = ConnectionFactory.getConnection()) {
                Statement stmt = connection.createStatement();
                stmt.executeUpdate(sql);

                for (Products p : Datas.getOrderedItems()) {
                    sql = "insert into P_RENDELT_TERMEKEK(RENDELES_ID, TERMEK_ID, egyseg_ar, rendelt_darab) values " +
                            "(rendeles_seq.currval," + p.getItemNo() + "," + p.getPrice() + ", " + p.getOrderdPiece() + ")";
                    stmt.executeUpdate(sql);
                }

                stmt.close();
                logger.info("Order is closed.");
            } catch (SQLException e) {
                logger.error("Close the order.");
                e.printStackTrace();
            }
        }
    }


    public void loadOrderedItems(Orders orders) {
        String sql_string = "select * from P_RENDELT_TERMEKEK where rendeles_id = "+ orders.getO_id();
        try(Connection connection = ConnectionFactory.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql_string)){

            while(rs.next()){
                Products p = getProductByItemNo(rs.getInt(3));
                p.setOrderdPiece(rs.getInt(5));
                Datas.add(p);
            }

        } catch (SQLException e){
            logger.error("Cannot open the database.");
            e.printStackTrace();
        }
    }

    private Products getProductByItemNo(int itemno) {
        String sql_string = "select * from P_TERMEKEK where t_termekazon = "+ itemno;
        Products result = null;
        try(Connection connection = ConnectionFactory.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql_string)){

            while(resultSet.next()){
                result = new Products(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getString(5),
                        resultSet.getInt(6), resultSet.getInt(7), resultSet.getInt(8), resultSet.getInt(9), resultSet.getInt(10), resultSet.getInt(11));
            }

        } catch (SQLException e){
            logger.error("Cannot open the database.");
            e.printStackTrace();
        }

        return result;
    }

}
