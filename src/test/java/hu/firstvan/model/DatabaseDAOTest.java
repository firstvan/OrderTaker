package hu.firstvan.model;

import org.junit.Test;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.Date;

import static org.junit.Assert.*;

/**
 * Created by István on 4/28/2015.
 */
public class DatabaseDAOTest {

    @Test
    public void testGetAllCustomer() throws Exception {
        assertNotEquals((Integer)0, DatabaseDAO.getAllCustomer());
    }

    @Test
    public void testAddCustomer() throws Exception {
        int szam = DatabaseDAO.getAllCustomer().size();
        DatabaseDAO.AddCustomer(new Customer("Test", Date.valueOf("1994-04-20"), "Test"));
        assertEquals(szam + 1, DatabaseDAO.getAllCustomer().size());

        Connection connection = ConnectionFactory.getConnection();
        Statement statement = connection.createStatement();
        String sql = "Delete from p_vasarlok where nev = 'Test'";
        statement.executeUpdate(sql);
        connection.close();
    }

    @Test
    public void testGetUserOrders() throws Exception {
        assertNotNull(DatabaseDAO.GetUserOrders(1));
    }

    @Test
    public void testGetSearchedProducts() throws Exception {
        assertNotEquals(0, DatabaseDAO.getSearchedProducts("a"));
    }

}