package hu.firstvan.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by firstvan on 2015.04.18..
 */
public class DatabaseDAO {

    public static ArrayList<Customer> getAllCustomer() {

        Connection connection = ConnectionFactory.getConnection();
        ArrayList<Customer> ret = new ArrayList<>();
        Statement st;
        try {
            st = connection.createStatement();
            String sql_query = "select * from p_vasarlok";
            ResultSet rs = st.executeQuery(sql_query);
            while (rs.next()) {
                ret.add(new Customer(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getDate(5)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return ret;
    }

    public static void AddCustomer(Customer customer) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement statement = connection.createStatement();

            String sql = "Insert into p_vasarlok" +
                    "(nev, szul_datum, csatlakozas_datuma, szallitasi_cim)" +
                    "values ('" + customer.getC_name() + "', to_date('" + customer.getC_startDate().toString() + "'" +
                    ",'yyyy-mm-dd'), sysdate, '" + customer.getC_addr() + "')";

            statement.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(customer.getC_startDate().toString());
    }

    public static ArrayList<Orders> GetUserOrders(int userid) {
        Connection connection = ConnectionFactory.getConnection();
        ArrayList<Orders> ret = new ArrayList<>();
        String sql = "select * from p_rendelesek where vasarlo_id=" + userid;

        try {
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            while (resultSet.next()) {
                ret.add(new Orders(resultSet.getInt(1), resultSet.getInt(2), resultSet.getDate(3), resultSet.getInt(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ret;
    }

    public static ArrayList<Products> getSearchedProducts(String name) {
        Connection connection = ConnectionFactory.getConnection();
        ArrayList<Products> ret = new ArrayList<>();
        String sql = "select * from p_termekek where T_NEV like '%" + name + "%'";

        try {
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            while (resultSet.next()) {
                ret.add(new Products(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getString(5),
                        resultSet.getInt(6), resultSet.getInt(7), resultSet.getInt(8), resultSet.getInt(9), resultSet.getInt(10), resultSet.getInt(11)));


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ret;

    }

    public static void closeOrder() {
        if (!Datas.getOrderdItems().isEmpty()) {
            Connection connection = ConnectionFactory.getConnection();

            String sql = "insert into p_rendelesek (DATUM, rendeles_id, vasarlo_id, vegosszeg) values (sysdate, rendeles_seq.nextval, "
                    + Datas.getCustomer().getC_id() + " ," + Datas.getGrandTotal() + ")";

            try {
                Statement stmt = connection.createStatement();
                stmt.executeUpdate(sql);

                for (Products p : Datas.getOrderdItems()) {
                    sql = "insert into P_RENDELT_TERMEKEK(RENDELES_ID, TERMEK_ID, egyseg_ar, rendelt_darab) values " +
                            "(rendeles_seq.currval," + p.getItemNo() + "," + p.getPrice() + ", " + p.getOrderdPiece() + ")";
                    stmt.executeUpdate(sql);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
