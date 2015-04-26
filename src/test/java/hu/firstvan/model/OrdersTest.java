package hu.firstvan.model;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

/**
 * Created by firstvan on 2015.04.26..
 */
public class OrdersTest {

    Orders orders;

    @Before
    public void setUp() throws Exception {
        Date d = new Date(new GregorianCalendar(2000, 1, 1).getTime().getTime());
        orders = new Orders(1, 1, d, 1000);
    }

    @Test
    public void testGetO_id() throws Exception {
        assertEquals((Integer) 1, orders.getO_id());
    }

    @Test
    public void testSetO_id() throws Exception {
        orders.setO_id(2);
        assertEquals((Integer) 2, orders.getO_id());
    }

    @Test
    public void testGetC_id() throws Exception {
        assertEquals((Integer) 1, orders.getC_id());
    }

    @Test
    public void testSetC_id() throws Exception {
        orders.setC_id(12);
        assertEquals((Integer) 12, orders.getC_id());
    }

    @Test
    public void testGetDate() throws Exception {
        Date d = new Date(new GregorianCalendar(2000, 1, 1).getTime().getTime());
        assertEquals(d, orders.getDate());
    }

    @Test
    public void testSetDate() throws Exception {
        Date d = new Date(new GregorianCalendar(2012, 2, 1).getTime().getTime());
        orders.setDate(d);
        assertEquals(d, orders.getDate());
    }

    @Test
    public void testGetOrder_total() throws Exception {
        assertEquals((Integer) 1000, orders.getOrder_total());
    }

    @Test
    public void testSetOrder_total() throws Exception {
        orders.setOrder_total(10);
        assertEquals((Integer) 10, orders.getOrder_total());
    }
}