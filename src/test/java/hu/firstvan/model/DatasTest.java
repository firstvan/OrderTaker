package hu.firstvan.model;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

/**
 * Created by firstvan on 2015.04.25..
 */
public class DatasTest {

    @Before
    public void setUp() {
        Date startDate = new Date(new GregorianCalendar(2010, 2, 3).getTime().getTime());
        Date firstOrderDate = new Date(new GregorianCalendar(2011, 2, 3).getTime().getTime());
        Datas.getOrderdItems().clear();
        Datas.setCustomer(new Customer(1, "Test", startDate, "TestStreet", firstOrderDate));
        Products p = new Products(1234, "name", 500, "van", 10, 400, 20, 300, 30, 200);
        p.setOrderdPiece(1);
        Datas.add(p);

    }

    @Test
    public void testGetCustomer() throws Exception {
        Date startDate = new Date(new GregorianCalendar(2010, 2, 3).getTime().getTime());
        Date firstOrderDate = new Date(new GregorianCalendar(2011, 2, 3).getTime().getTime());
        Customer c = new Customer(1, "Test", startDate, "TestStreet", firstOrderDate);
        assertEquals(c, Datas.getCustomer());
    }

    @Test
    public void testSetCustomer() throws Exception {
        Date startDate = new Date(new GregorianCalendar(2010, 2, 3).getTime().getTime());
        Date firstOrderDate = new Date(new GregorianCalendar(2011, 2, 3).getTime().getTime());
        Customer c = new Customer(5, "Test", startDate, "TestStreet", firstOrderDate);
        Datas.setCustomer(c);
        assertEquals(c, Datas.getCustomer());
    }

    @Test
    public void testAdd() throws Exception {
        Datas.add(new Products(123, "name", 123, "van", 123, 123, 123, 123, 123, 123));
        assertEquals(2, Datas.getOrderdItems().size());
    }

    @Test
    public void testRemove() throws Exception {
        Products p = new Products(123, "name", 123, "van", 123, 123, 123, 123, 123, 123);
        Datas.remove(p);
        assertEquals(1, Datas.getOrderdItems().size());
    }

    @Test
    public void testGetOrderdItems() throws Exception {
        ArrayList<Products> arrayList = new ArrayList<>();
        arrayList.add(new Products(1234, "name", 500, "van", 10, 400, 20, 300, 30, 200));
        assertEquals(arrayList, Datas.getOrderdItems());
    }

    @Test
    public void testGetGrandTotal() throws Exception {
        assertEquals(500, Datas.getGrandTotal());
    }

    @Test
    public void testGetGrandTotal1() throws Exception {
        Datas.getOrderdItems().get(0).setOrderdPiece(10);
        assertEquals(4000, Datas.getGrandTotal());
    }

    @Test
    public void testGetGrandTotal2() throws Exception {
        Datas.getOrderdItems().get(0).setOrderdPiece(20);
        assertEquals(6000, Datas.getGrandTotal());
    }

    @Test
    public void testGetGrandTotal3() throws Exception {
        Datas.getOrderdItems().get(0).setOrderdPiece(30);
        assertEquals(6000, Datas.getGrandTotal());
    }

    @Test
    public void testGetGrandTotal4() throws Exception {
        Date d = new Date(new GregorianCalendar(2004, 4, 25).getTime().getTime());
        Datas.getCustomer().setC_startDate(d);
        Datas.getOrderdItems().get(0).setOrderdPiece(30);
        double temp = 6000 * 0.99;
        int osszeg = (int) temp;
        assertEquals(osszeg, Datas.getGrandTotal());
    }

    @Test
    public void testGetGrandTotal5() throws Exception {
        Date d = new Date(new GregorianCalendar(1994, 4, 25).getTime().getTime());
        Datas.getCustomer().setC_startDate(d);
        Datas.getOrderdItems().get(0).setOrderdPiece(30);
        double temp = 6000 * 0.98;
        int osszeg = (int) temp;
        assertEquals(osszeg, Datas.getGrandTotal());
    }

    @Test
    public void testGetGrandTotal6() throws Exception {
        Date d = new Date(new GregorianCalendar(1984, 4, 25).getTime().getTime());
        Datas.getCustomer().setC_startDate(d);
        Datas.getOrderdItems().get(0).setOrderdPiece(30);
        double temp = 6000 * 0.97;
        int osszeg = (int) temp;
        assertEquals(osszeg, Datas.getGrandTotal());
    }

    @Test
    public void testGetGrandTotal7() throws Exception {
        Date d = new Date(new GregorianCalendar(2009, 4, 25).getTime().getTime());
        Datas.getCustomer().setC_firstOrder(d);
        Datas.getOrderdItems().get(0).setOrderdPiece(30);
        double temp = 6000 * 0.95;
        int osszeg = (int) temp;
        assertEquals(osszeg, Datas.getGrandTotal());
    }

    @Test
    public void testGetGrandTotal8() throws Exception {
        Date d = new Date(new GregorianCalendar(1915, 4, 25).getTime().getTime());
        Datas.getCustomer().setC_firstOrder(d);
        Datas.getOrderdItems().get(0).setOrderdPiece(30);
        double temp = 6000 * 0.5;
        int osszeg = (int) temp;
        assertEquals(osszeg, Datas.getGrandTotal());
    }
}