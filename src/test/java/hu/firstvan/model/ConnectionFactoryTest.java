package hu.firstvan.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This class test the connection factory.
 */
public class ConnectionFactoryTest {

    /**
     * Set up before test.
     */
    @Before
    public void setUp(){
        new ConnectionFactory();
    }

    /**
     * Test the connection is created.
     */
    @Test
    public void testGetConnection() {
        assertNotNull(ConnectionFactory.getConnection());
    }

    /**
     * Test for set username.
     */
    @Test
    public void testSetUser(){
        ConnectionFactory.setUser("Test");
        assertEquals("Test", ConnectionFactory.getUser());
    }

    /**
     * Test for set password.
     */
    @Test
    public void testSetPass(){
        ConnectionFactory.setPass("PASS");
        assertEquals("PASS", ConnectionFactory.getPass());
    }
}