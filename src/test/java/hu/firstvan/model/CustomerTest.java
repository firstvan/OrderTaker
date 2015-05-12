package hu.firstvan.model;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

/**
 * This class test the customer class.
 */
public class CustomerTest {

    /**
     * Represent a customer.
     */
    Customer customer;

    /**
     * Set up before test.
     */
    @Before
    public void setUp(){
        Date date = new Date(new GregorianCalendar(2000, 1, 1).getTime().getTime());
        customer = new Customer(12, "Balogh", date, "kiszallitas", date);
    }

    /**
     * Test customer id getter.
     */
    @Test
    public void testGetC_id() {
        assertEquals((Integer) 12, customer.getC_id());
    }

    /**
     * Test customer id setter.
     */
    @Test
    public void testSetC_id() {
        customer.setC_id(1);
        assertEquals((Integer) 1, customer.getC_id());
    }

    /**
     * Test customer name getter.
     */
    @Test
    public void testGetC_name() {
        assertEquals("Balogh", customer.getC_name());
    }

    /**
     * Test customer name setter.
     */
    @Test
    public void testSetC_name() {
        customer.setC_name("Test");
        assertEquals("Test", customer.getC_name());
    }

    /**
     * Test customer's start date getter.
     */
    @Test
    public void testGetC_startDate() {
        Date date = new Date(new GregorianCalendar(2000, 1, 1).getTime().getTime());
        assertEquals(date, customer.getC_startDate());
    }

    /**
     * Test customer's start date setter.
     */
    @Test
    public void testSetC_startDate() {
        Date date = new Date(new GregorianCalendar(2005, 1, 1).getTime().getTime());
        customer.setC_startDate(date);
        assertEquals(date, customer.getC_startDate());
    }

    /**
     * Test customer address getter.
     */
    @Test
    public void testGetC_addr() {
        assertEquals("kiszallitas", customer.getC_addr());
    }

    /**
     * Test customer address setter.
     */
    @Test
    public void testSetC_addr() {
        customer.setC_addr("teszt utca");
        assertEquals("teszt utca", customer.getC_addr());
    }

    /**
     * Test first order date getter.
     */
    @Test
    public void testGetC_firstOrder() {
        Date date = new Date(new GregorianCalendar(2000, 1, 1).getTime().getTime());
        assertEquals(date, customer.getC_firstOrder());
    }

    /**
     * Test first order date setter.
     */
    @Test
    public void testSetC_firstOrder() {
        Date date = new Date(new GregorianCalendar(2007, 1, 1).getTime().getTime());
        customer.setC_firstOrder(date);
        assertEquals(date, customer.getC_firstOrder());
    }

    /**
     * Test the customer equals method, when customer is not equal.
     */
    @Test
    public void testEquals() {
        Date date = new Date(new GregorianCalendar(2007, 1, 1).getTime().getTime());
        Customer test2 = new Customer(11, "Balogh", date, "kiszallitas", date);
        assertEquals(false, customer.equals(test2));
    }

    /**
     * Test the customer equals method, when customer is equal.
     */
    @Test
    public void testEquals2() {
        Date date = new Date(new GregorianCalendar(2007, 1, 1).getTime().getTime());
        Customer test2 = new Customer(12, "Balogh", date, "kiszallitas", date);
        assertEquals(true, customer.equals(test2));
    }

    /**
     * Test the customer equals method, when customer is null.
     */
    @Test
    public void testEquals3() {
        assertEquals(false, customer.equals(null));
    }

    /**
     * Test the constructor of customer.
     */
    @Test
    public void testConstructor(){
        Customer c = new Customer("Test", Date.valueOf("2000-04-20"), "Test");
        assertEquals("Test", c.getC_name());
    }
}