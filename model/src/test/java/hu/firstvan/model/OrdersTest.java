package hu.firstvan.model;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

/**
 * This class is represent test of order class.
 */
public class OrdersTest {

    /**
     * It contains all necessary information from an order.
     */
    private Orders orders;

    /**
     * Set up a new order.
     */
    @Before
    public void setUp() {
        Date d = new Date(new GregorianCalendar(2000, 1, 1).getTime().getTime());
        orders = new Orders(1, 1, d, 1000);
    }

    /**
     * Test order id getter.
     */
    @Test
    public void testGetO_id() {
        assertEquals((Integer) 1, orders.getO_id());
    }

    /**
     * Test order id setter.
     */
    @Test
    public void testSetO_id() {
        orders.setO_id(2);
        assertEquals((Integer) 2, orders.getO_id());
    }

    /**
     * Test customer id getter.
     */
    @Test
    public void testGetC_id() {
        assertEquals((Integer) 1, orders.getC_id());
    }

    /**
     * Test customer id setter.
     */
    @Test
    public void testSetC_id() {
        orders.setC_id(12);
        assertEquals((Integer) 12, orders.getC_id());
    }

    /**
     * Test order date getter.
     */
    @Test
    public void testGetDate() {
        Date d = new Date(new GregorianCalendar(2000, 1, 1).getTime().getTime());
        assertEquals(d, orders.getDate());
    }

    /**
     * Test order date setter.
     */
    @Test
    public void testSetDate() {
        Date d = new Date(new GregorianCalendar(2012, 2, 1).getTime().getTime());
        orders.setDate(d);
        assertEquals(d, orders.getDate());
    }

    /**
     * Test order total getter.
     */
    @Test
    public void testGetOrder_total() {
        assertEquals((Integer) 1000, orders.getOrder_total());
    }

    /**
     * Test order total setter.
     */
    @Test
    public void testSetOrder_total() {
        orders.setOrder_total(10);
        assertEquals((Integer) 10, orders.getOrder_total());
    }
}