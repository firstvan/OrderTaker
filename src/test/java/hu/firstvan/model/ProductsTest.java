package hu.firstvan.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by firstvan on 2015.04.25..
 */
public class ProductsTest {

    Products products;

    @Before
    public void setUp() throws Exception {
        products = new Products(12345, "Termek", 200, "Van", 10, 100, 11, 90, 12, 80);
        products.setOrderdPiece(1);
    }

    @Test
    public void testSetItemNo() throws Exception {
        products.setItemNo(1234512);
        assertEquals((Integer) 1234512, products.getItemNo());
    }

    @Test
    public void testGetItemNo() throws Exception {
        assertEquals((Integer) 12345, products.getItemNo());
    }


    @Test
    public void testGetName() throws Exception {
        assertEquals("Termek", products.getName());
    }

    @Test
    public void testSetName() throws Exception {
        products.setName("Hello");
        assertEquals("Hello", products.getName());
    }

    @Test
    public void testGetPrice() throws Exception {
        assertEquals((Integer) 200, products.getPrice());
    }

    @Test
    public void testSetPrice() throws Exception {
        products.setPrice(100);
        assertEquals((Integer) 100, products.getPrice());
    }

    @Test
    public void testGetRabat() throws Exception {
        assertEquals("Van", products.getRabat());
    }

    @Test
    public void testSetRabat() throws Exception {
        products.setRabat("Nincs");
        assertEquals("Nincs", products.getRabat());
    }

    @Test
    public void testGetRabat1() throws Exception {
        assertEquals((Integer) 10, products.getRabat1());
    }

    @Test
    public void testSetRabat1() throws Exception {
        products.setRabat1(5);
        assertEquals((Integer) 5, products.getRabat1());
    }

    @Test
    public void testGetRabat1Price() throws Exception {
        assertEquals((Integer) 100, products.getRabat1Price());
    }

    @Test
    public void testSetRabat1Price() throws Exception {
        products.setRabat1Price(123);
        assertEquals((Integer) 123, products.getRabat1Price());
    }

    @Test
    public void testGetRabat2() throws Exception {
        assertEquals((Integer) 11, products.getRabat2());
    }

    @Test
    public void testGetSubTotal3() throws Exception {
        products.setOrderdPiece(12);
        assertEquals((Integer) 960, products.getSubTotal());
    }

    @Test
    public void testSetRabat2() throws Exception {
        products.setRabat2(5);
        assertEquals((Integer) 5, products.getRabat2());

    }

    @Test
    public void testGetRabat2Price() throws Exception {
        assertEquals((Integer) 90, products.getRabat2Price());
    }

    @Test
    public void testSetRabat2Price() throws Exception {
        products.setRabat2Price(123);
        assertEquals((Integer) 123, products.getRabat2Price());
    }

    @Test
    public void testGetRabat3() throws Exception {
        assertEquals((Integer) 12, products.getRabat3());
    }

    @Test
    public void testSetRabat3() throws Exception {
        products.setRabat3(5);
        assertEquals((Integer) 5, products.getRabat3());

    }

    @Test
    public void testGetRabat3Price() throws Exception {
        assertEquals((Integer) 80, products.getRabat3Price());
    }

    @Test
    public void testSetRabat3Price() throws Exception {
        products.setRabat3Price(123);
        assertEquals((Integer) 123, products.getRabat3Price());
    }

    @Test
    public void testGetOrderdPiece() throws Exception {
        assertEquals((Integer) 1, products.getOrderdPiece());
    }

    @Test
    public void testSetOrderdPiece() throws Exception {
        products.setOrderdPiece(12);
        assertEquals((Integer) 12, products.getOrderdPiece());
    }

    @Test
    public void testGetSubTotal() throws Exception {
        assertEquals((Integer) 200, products.getSubTotal());
    }

    @Test
    public void testGetSubTotal1() throws Exception {
        products.setOrderdPiece(10);
        assertEquals((Integer) 1000, products.getSubTotal());
    }

    @Test
    public void testGetSubTotal2() throws Exception {
        products.setOrderdPiece(11);
        assertEquals((Integer) 990, products.getSubTotal());
    }

    @Test
    public void testEquals() throws Exception {
        Products p = new Products();
        p.setItemNo(12345);

        assertEquals(true, products.equals(p));
    }
}