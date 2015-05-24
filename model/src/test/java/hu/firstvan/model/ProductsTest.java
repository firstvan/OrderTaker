package hu.firstvan.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * This class represent test of product class.
 */
public class ProductsTest {

    /**
     * It's contains all necessary information of product.
     */
    private Products products;

    /**
     * Create a new product before test.
     */
    @Before
    public void setUp() {
        products = new Products(12345, "Termek", 200, "Van", 10, 100, 11, 90, 12, 80);
        products.setOrderdPiece(1);
    }

    /**
     * Test setter of product's item number.
     */
    @Test
    public void testSetItemNo() {
        products.setItemNo(1234512);
        assertEquals((Integer) 1234512, products.getItemNo());
    }

    /**
     * Test getter of product's item number.
     */
    @Test
    public void testGetItemNo() {
        assertEquals((Integer) 12345, products.getItemNo());
    }

    /**
     * Test getter of product's name.
     */
    @Test
    public void testGetName() {
        assertEquals("Termek", products.getName());
    }

    /**
     * Test setter of product's name.
     */
    @Test
    public void testSetName() {
        products.setName("Hello");
        assertEquals("Hello", products.getName());
    }

    /**
     * Test getter of product's price.
     */
    @Test
    public void testGetPrice() {
        assertEquals((Integer) 200, products.getPrice());
    }

    /**
     * Test setter of product's price.
     */
    @Test
    public void testSetPrice() {
        products.setPrice(100);
        assertEquals((Integer) 100, products.getPrice());
    }


    /**
     * Test getter whether product has salary.
     */
    @Test
    public void testGetRabat() {
        assertEquals("Van", products.getRabat());
    }

    /**
     * Test setter of whether product has salary.
     */
    @Test
    public void testSetRabat() {
        products.setRabat("Nincs");
        assertEquals("Nincs", products.getRabat());
    }

    /**
     * Test getter of product's first salary.
     */
    @Test
    public void testGetRabat1() {
        assertEquals((Integer) 10, products.getRabat1());
    }

    /**
     * Test setter of product's salary piece.
     */
    @Test
    public void testSetRabat1() {
        products.setRabat1(5);
        assertEquals((Integer) 5, products.getRabat1());
    }

    /**
     * Test getter of product's first salary price.
     */
    @Test
    public void testGetRabat1Price() {
        assertEquals((Integer) 100, products.getRabat1Price());
    }

    /**
     * Test setter of product's salary.
     */
    @Test
    public void testSetRabat1Price() {
        products.setRabat1Price(123);
        assertEquals((Integer) 123, products.getRabat1Price());
    }

    /**
     * Test getter of product's second salary piece.
     */
    @Test
    public void testGetRabat2() {
        assertEquals((Integer) 11, products.getRabat2());
    }


    /**
     * Test setter of product's salary 2 piece.
     */
    @Test
    public void testSetRabat2() {
        products.setRabat2(5);
        assertEquals((Integer) 5, products.getRabat2());

    }

    /**
     * Test getter of product's second salary price.
     */
    @Test
    public void testGetRabat2Price() {
        assertEquals((Integer) 90, products.getRabat2Price());
    }

    /**
     * Test setter of product's salary 2.
     */
    @Test
    public void testSetRabat2Price() {
        products.setRabat2Price(123);
        assertEquals((Integer) 123, products.getRabat2Price());
    }

    /**
     * Test getter of product's third salary piece.
     */
    @Test
    public void testGetRabat3() {
        assertEquals((Integer) 12, products.getRabat3());
    }

    /**
     * Test setter of product's salary 3 piece .
     */
    @Test
    public void testSetRabat3() {
        products.setRabat3(5);
        assertEquals((Integer) 5, products.getRabat3());

    }

    /**
     * Test getter of product's third salary price.
     */
    @Test
    public void testGetRabat3Price() {
        assertEquals((Integer) 80, products.getRabat3Price());
    }

    /**
     * Test setter of product's salary 3.
     */
    @Test
    public void testSetRabat3Price() {
        products.setRabat3Price(123);
        assertEquals((Integer) 123, products.getRabat3Price());
    }

    /**
     * Test getter of ordered price.
     */
    @Test
    public void testGetOrderdPiece() {
        assertEquals((Integer) 1, products.getOrderdPiece());
    }

    /**
     * Test setter of product's ordered piece.
     */
    @Test
    public void testSetOrderdPiece() {
        products.setOrderdPiece(12);
        assertEquals((Integer) 12, products.getOrderdPiece());
    }

    /**
     * Test sub total when no salary.
     */
    @Test
    public void testGetSubTotal() {
        assertEquals((Integer) 200, products.getSubTotal());
    }

    /**
     * Test sub total when first salary is active.
     */
    @Test
    public void testGetSubTotal1() {
        products.setOrderdPiece(10);
        assertEquals((Integer) 1000, products.getSubTotal());
    }

    /**
     * Test sub total when second salary is active.
     */
    @Test
    public void testGetSubTotal2() {
        products.setOrderdPiece(11);
        assertEquals((Integer) 990, products.getSubTotal());
    }

    /**
     * Test sub total when third salary is active.
     */
    @Test
    public void testGetSubTotal3() {
        products.setOrderdPiece(12);
        assertEquals((Integer) 960, products.getSubTotal());
    }

    /**
     * Test two products equals.
     */
    @Test
    public void testEquals() {
        Products p = new Products();
        p.setItemNo(12345);

        assertEquals(true, products.equals(p));
    }
}