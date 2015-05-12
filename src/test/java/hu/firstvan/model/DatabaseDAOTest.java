package hu.firstvan.model;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * This class represent the test of databaseDao class.
 */
public class DatabaseDAOTest {

    DatabaseDAO databaseDAO;

    @Before
    public void setUp(){
        databaseDAO = mock(DatabaseDAO.class);

        Date date = new Date(new GregorianCalendar(1900, 12, 21).getTime().getTime());

        Customer customer1 = new Customer(1, "Test", date, "Testszallitas", date);

        Customer customer2 = new Customer("Test1", date, "Testszallitas");

        ArrayList<Customer> array  = new ArrayList<>();
        ArrayList<Orders> array1 = new ArrayList<>();
        ArrayList<Products> array2 = new ArrayList<>();

        array.add(customer1);
        array.add(customer2);
        array1.add(new Orders(1, 1, new Date(new GregorianCalendar(1900, 12, 21).getTime().getTime()),123456));
        array2.add(new Products(1, "ad", 100, "nincs", 0,0,0,0,0,0));

        when(databaseDAO.getAllCustomer()).thenReturn(array);
        when(databaseDAO.GetUserOrders(1)).thenReturn(array1);
        when(databaseDAO.getSearchedProducts("ad")).thenReturn(array2);
    }

    @Test
    public void TestgetAllCustomer(){
        assertEquals(2, databaseDAO.getAllCustomer().size());
        assertEquals("Test", databaseDAO.getAllCustomer().get(0).getC_name());
        assertEquals("Testszallitas", databaseDAO.getAllCustomer().get(1).getC_addr());
    }

    @Test
    public void TestGetUserOrders(){
        assertEquals((Integer)1, databaseDAO.GetUserOrders(1).get(0).getC_id());
        assertEquals((Integer)1, databaseDAO.GetUserOrders(1).get(0).getO_id());
        assertEquals((Integer)123456, databaseDAO.GetUserOrders(1).get(0).getOrder_total());
    }

    @Test
    public void TestGetSearchedProducts(){
        assertEquals((Integer)1, databaseDAO.getSearchedProducts("ad").get(0).getItemNo());
        assertEquals((Integer)100, databaseDAO.getSearchedProducts("ad").get(0).getPrice());
        assertEquals("ad", databaseDAO.getSearchedProducts("ad").get(0).getName());
        assertEquals("nincs", databaseDAO.getSearchedProducts("ad").get(0).getRabat());
    }
}
