package hu.firstvan.model;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

/**
 * Created by firstvan on 2015.04.26..
 */
public class CustomerTest {

    Customer customer;

    @Before
    public void setUp() throws Exception {
        Date date = new Date(new GregorianCalendar(2000, 1, 1).getTime().getTime());
        customer = new Customer(12, "Balogh", date, "kiszallitas", date);
    }

    @Test
    public void testGetC_id() throws Exception {
        assertEquals((Integer) 12, customer.getC_id());
    }

    @Test
    public void testSetC_id() throws Exception {
        customer.setC_id(1);
        assertEquals((Integer) 1, customer.getC_id());
    }

    @Test
    public void testGetC_name() throws Exception {
        assertEquals("Balogh", customer.getC_name());
    }

    @Test
    public void testSetC_name() throws Exception {
        customer.setC_name("Test");
        assertEquals("Test", customer.getC_name());
    }

    @Test
    public void testGetC_startDate() throws Exception {
        Date date = new Date(new GregorianCalendar(2000, 1, 1).getTime().getTime());
        assertEquals(date, customer.getC_startDate());
    }

    @Test
    public void testSetC_startDate() throws Exception {
        Date date = new Date(new GregorianCalendar(2005, 1, 1).getTime().getTime());
        customer.setC_startDate(date);
        assertEquals(date, customer.getC_startDate());
    }

    @Test
    public void testGetC_addr() throws Exception {
        assertEquals("kiszallitas", customer.getC_addr());
    }

    @Test
    public void testSetC_addr() throws Exception {
        customer.setC_addr("teszt utca");
        assertEquals("teszt utca", customer.getC_addr());
    }

    @Test
    public void testGetC_firstOrder() throws Exception {
        Date date = new Date(new GregorianCalendar(2000, 1, 1).getTime().getTime());
        assertEquals(date, customer.getC_firstOrder());
    }

    @Test
    public void testSetC_firstOrder() throws Exception {
        Date date = new Date(new GregorianCalendar(2007, 1, 1).getTime().getTime());
        customer.setC_firstOrder(date);
        assertEquals(date, customer.getC_firstOrder());
    }

    @Test
    public void testEquals() throws Exception {
        Date date = new Date(new GregorianCalendar(2007, 1, 1).getTime().getTime());
        Customer test2 = new Customer(11, "Balogh", date, "kiszallitas", date);
        assertEquals(false, customer.equals(test2));
    }

    @Test
    public void testEquals2() throws Exception {
        Date date = new Date(new GregorianCalendar(2007, 1, 1).getTime().getTime());
        Customer test2 = new Customer(12, "Balogh", date, "kiszallitas", date);
        assertEquals(true, customer.equals(test2));
    }

    @Test
    public void testEquals3() throws Exception {
        assertEquals(false, customer.equals(null));
    }

}