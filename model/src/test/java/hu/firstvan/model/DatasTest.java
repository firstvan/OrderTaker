package hu.firstvan.model;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

/**
 * This class represent test of Datas class.
 */
public class DatasTest {

    /**
     * Set up before test.
     */
    @Before
    public void setUp() {
        Datas datas = new Datas();
        Date startDate = new Date(new GregorianCalendar(2010, 2, 3).getTime().getTime());
        Date firstOrderDate = new Date(new GregorianCalendar(2011, 2, 3).getTime().getTime());
        Datas.getOrderedItems().clear();
        Datas.setCustomer(new Customer(1, "Test", startDate, "TestStreet", firstOrderDate));
        Products p = new Products(1234, "name", 500, "van", 10, 400, 20, 300, 30, 200);
        p.setOrderdPiece(1);
        Datas.add(p);

    }

    /**
     * Test actual customer is available.
     */
    @Test
    public void testGetCustomer() {
        Date startDate = new Date(new GregorianCalendar(2010, 2, 3).getTime().getTime());
        Date firstOrderDate = new Date(new GregorianCalendar(2011, 2, 3).getTime().getTime());
        Customer c = new Customer(1, "Test", startDate, "TestStreet", firstOrderDate);
        assertEquals(c, Datas.getCustomer());
    }

    /**
     * Test actual customer can be set.
     */
    @Test
    public void testSetCustomer() {
        Date startDate = new Date(new GregorianCalendar(2010, 2, 3).getTime().getTime());
        Date firstOrderDate = new Date(new GregorianCalendar(2011, 2, 3).getTime().getTime());
        Customer c = new Customer(5, "Test", startDate, "TestStreet", firstOrderDate);
        Datas.setCustomer(c);
        assertEquals(c, Datas.getCustomer());
    }

    /**
     * Test to add product to ordered item.
     */
    @Test
    public void testAdd() {
        Datas.add(new Products(123, "name", 123, "van", 123, 123, 123, 123, 123, 123));
        assertEquals(2, Datas.getOrderedItems().size());
    }

    /**
     * Test to add product to ordered items.
     */
    @Test
    public void testAdd2() throws Exception {
        Datas.add(new Products(123, "name", 123, "van", 123, 123, 123, 123, 123, 123));
        Datas.add(new Products(123, "name", 123, "van", 123, 123, 123, 123, 123, 123));
        assertEquals(2, Datas.getOrderedItems().size());
    }

    /**
     * Test to remove not existing product from ordered item.
     */
    @Test
    public void testRemove() throws Exception {
        Products p = new Products(123, "name", 123, "van", 123, 123, 123, 123, 123, 123);
        Datas.remove(p);
        assertEquals(1, Datas.getOrderedItems().size());
    }

    /**
     * Test to remove product from ordered item.
     */
    @Test
    public void testRemove2() throws Exception {
        Products p = new Products(1234, "name", 123, "van", 123, 123, 123, 123, 123, 123);
        Datas.remove(p);
        assertEquals(0, Datas.getOrderedItems().size());
    }

    /**
     * Test to get ordered list.
     */
    @Test
    public void testGetOrderdItems() {
        ArrayList<Products> arrayList = new ArrayList<>();
        arrayList.add(new Products(1234, "name", 500, "van", 10, 400, 20, 300, 30, 200));
        assertEquals(arrayList, Datas.getOrderedItems());
    }

    /**
     * Test to get simple get grand total.
     */
    @Test
    public void testGetGrandTotal() {
        assertEquals(500, Datas.getGrandTotal());
    }

    /**
     * Test when ordered item piece set to ten.
     */
    @Test
    public void testGetGrandTotal1() {
        Datas.getOrderedItems().get(0).setOrderdPiece(10);
        assertEquals(4000, Datas.getGrandTotal());
    }

    /**
     * Test when ordered item piece set to twenty.
     */
    @Test
    public void testGetGrandTotal2() {
        Datas.getOrderedItems().get(0).setOrderdPiece(20);
        assertEquals(6000, Datas.getGrandTotal());
    }

    /**
     * Test when ordered item piece set to thirty.
     */
    @Test
    public void testGetGrandTotal3() {
        Datas.getOrderedItems().get(0).setOrderdPiece(30);
        assertEquals(6000, Datas.getGrandTotal());
    }

    /**
     * Test salary when customer is older than 10 years.
     */
    @Test
    public void testGetGrandTotal4() {
        Date d = new Date(new GregorianCalendar(2004, 4, 25).getTime().getTime());
        Datas.getCustomer().setC_startDate(d);
        Datas.getOrderedItems().get(0).setOrderdPiece(30);
        double temp = 6000 * 0.99;
        int osszeg = (int) temp;
        assertEquals(osszeg, Datas.getGrandTotal());
    }

    /**
     * Test salary when customer is older than 20 years.
     */
    @Test
    public void testGetGrandTotal5() {
        Date d = new Date(new GregorianCalendar(1994, 4, 25).getTime().getTime());
        Datas.getCustomer().setC_startDate(d);
        Datas.getOrderedItems().get(0).setOrderdPiece(30);
        double temp = 6000 * 0.98;
        int osszeg = (int) temp;
        assertEquals(osszeg, Datas.getGrandTotal());
    }

    /**
     * Test salary when customer is older than 30 years.
     */
    @Test
    public void testGetGrandTotal6() throws Exception {
        Date d = new Date(new GregorianCalendar(1984, 4, 25).getTime().getTime());
        Datas.getCustomer().setC_startDate(d);
        Datas.getOrderedItems().get(0).setOrderdPiece(30);
        double temp = 6000 * 0.97;
        int osszeg = (int) temp;
        assertEquals(osszeg, Datas.getGrandTotal());
    }

    /**
     * Test salary when customer is faithful 5 years yet.
     */
    @Test
    public void testGetGrandTotal7() {
        Date d = new Date(new GregorianCalendar(2009, 5, 25).getTime().getTime());
        Datas.getCustomer().setC_firstOrder(d);
        Datas.getOrderedItems().get(0).setOrderdPiece(30);
        double temp = 6000 * 0.95;
        int osszeg = (int) temp;
        assertEquals(osszeg, Datas.getGrandTotal());
    }

    /**
     * Test salary when customer is faithful 100 years yet.
     */
    @Test
    public void testGetGrandTotal8() {
        Date d = new Date(new GregorianCalendar(1915, 4, 25).getTime().getTime());
        Datas.getCustomer().setC_firstOrder(d);
        Datas.getOrderedItems().get(0).setOrderdPiece(30);
        double temp = 6000 * 0.5;
        int osszeg = (int) temp;
        assertEquals(osszeg, Datas.getGrandTotal());
    }

    /**
     * Test modify an ordered item.
     */
    @Test
    public void testModify() {
        Products p = new Products(1234, "name", 123, "van", 123, 123, 123, 123, 123, 123);
        Datas.modifyPiece(p, 1);
        assertEquals((Integer) 1, Datas.getOrderedItems().get(0).getOrderdPiece());
    }

    /**
     * Test modify an ordered item when item is not ordered.
     */
    @Test
    public void testModify2() {
        Products p = new Products(12, "name", 123, "van", 123, 123, 123, 123, 123, 123);
        Datas.modifyPiece(p, 1);
        assertEquals((Integer) 1, Datas.getOrderedItems().get(0).getOrderdPiece());
    }

    /**
     * Test modify an ordered item when there are more than one item is ordered.
     */
    @Test
    public void testModify3() {
        Products p1 = new Products(12, "name", 123, "van", 123, 123, 123, 123, 123, 123);
        Datas.add(p1);
        Products p = new Products(1234, "name", 123, "van", 123, 123, 123, 123, 123, 123);
        Datas.modifyPiece(p, 1);
        assertEquals((Integer) 1, Datas.getOrderedItems().get(1).getOrderdPiece());
    }

    /**
     * Test salary for deo's.
     */
    @Test
    public void testGetGrandTotal9() {
        Datas.getOrderedItems().clear();
        Products p;
        p = new Products(10101, "Test deo test", 100, "van", 123, 123, 123, 123, 123, 123);
        p.setOrderdPiece(1);
        Datas.add(p);
        p = new Products(2, "Test deo test2", 100, "van", 123, 123, 123, 123, 123, 123);
        p.setOrderdPiece(1);
        Datas.add(p);
        p = new Products(3, "Test123 deo test1", 100, "van", 123, 123, 123, 123, 123, 123);
        p.setOrderdPiece(1);
        Datas.add(p);
        p = new Products(4, "Test3 deo test1", 100, "van", 123, 123, 123, 123, 123, 123);
        p.setOrderdPiece(1);
        Datas.add(p);
        p = new Products(5, "Test 4deo test1", 100, "van", 123, 123, 123, 123, 123, 123);
        p.setOrderdPiece(1);
        Datas.add(p);

        p = new Products(1, "Test golyos test", 100, "van", 123, 123, 123, 123, 123, 123);
        p.setOrderdPiece(1);
        Datas.add(p);

        assertEquals(590, Datas.getGrandTotal());
    }

    /**
     * Test salary for more deo's.
     */
    @Test
    public void testGetGrandTotal10() {
        Datas.getOrderedItems().clear();
        Products p;
        p = new Products(10101, "Test deo test", 100, "van", 123, 123, 123, 123, 123, 123);
        p.setOrderdPiece(1);
        Datas.add(p);
        p = new Products(2, "Test deo test2", 100, "van", 123, 123, 123, 123, 123, 123);
        p.setOrderdPiece(1);
        Datas.add(p);
        p = new Products(3, "Test123 deo test1", 100, "van", 123, 123, 123, 123, 123, 123);
        p.setOrderdPiece(1);
        Datas.add(p);
        p = new Products(4, "Test3 deo test1", 100, "van", 123, 123, 123, 123, 123, 123);
        p.setOrderdPiece(1);
        Datas.add(p);
        p = new Products(5, "Test 4deo test1", 100, "van", 123, 123, 123, 123, 123, 123);
        p.setOrderdPiece(1);
        Datas.add(p);

        p = new Products(10102, "Test deo test", 100, "van", 123, 123, 123, 123, 123, 123);
        p.setOrderdPiece(1);
        Datas.add(p);
        p = new Products(22, "Test deo test2", 100, "van", 123, 123, 123, 123, 123, 123);
        p.setOrderdPiece(1);
        Datas.add(p);
        p = new Products(32, "Test123 deo test1", 100, "van", 123, 123, 123, 123, 123, 123);
        p.setOrderdPiece(1);
        Datas.add(p);
        p = new Products(42, "Test3 deo test1", 100, "van", 123, 123, 123, 123, 123, 123);
        p.setOrderdPiece(1);
        Datas.add(p);
        p = new Products(52, "Test 4deo test1", 100, "van", 123, 123, 123, 123, 123, 123);
        p.setOrderdPiece(1);
        Datas.add(p);

        p = new Products(1, "Test golyos test", 100, "van", 123, 123, 123, 123, 123, 123);
        p.setOrderdPiece(1);
        Datas.add(p);

        p = new Products(2302, "Test golyos test", 100, "van", 123, 123, 123, 123, 123, 123);
        p.setOrderdPiece(1);
        Datas.add(p);

        assertEquals(1180, Datas.getGrandTotal());
    }
}