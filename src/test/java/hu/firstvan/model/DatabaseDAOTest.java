package hu.firstvan.model;

import org.junit.Test;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.Date;

import static org.junit.Assert.*;

/**
 * This class represent the test of databaseDao class.
 */
public class DatabaseDAOTest {

    /**
     * Test connection to get all customer.
     */
    @Test
    public void testGetAllCustomer() {
        assertNotEquals((Integer)0, DatabaseDAO.getAllCustomer());
    }

    /**
     * Test to add customer to database.
     */
    @Test
    public void testAddCustomer() {
        int szam = DatabaseDAO.getAllCustomer().size();
        DatabaseDAO.AddCustomer(new Customer("Test", Date.valueOf("1994-04-20"), "Test"));
        assertEquals(szam + 1, DatabaseDAO.getAllCustomer().size());
        try{
        Connection connection = ConnectionFactory.getConnection();
        Statement statement = connection.createStatement();
        String sql = "Delete from p_vasarlok where nev = 'Test'";
        statement.executeUpdate(sql);
        connection.close();}
        catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Test to get all orders of actual customer.
     */
    @Test
    public void testGetUserOrders() {
        assertNotNull(DatabaseDAO.GetUserOrders(1));
    }

    /**
     * Test to get searched product.
     */
    @Test
    public void testGetSearchedProducts() {
        assertNotEquals(0, DatabaseDAO.getSearchedProducts("a"));
    }

}