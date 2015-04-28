package hu.firstvan.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by István on 4/28/2015.
 */
public class ConnectionFactoryTest {

    @Before
    public void setUp(){
        new ConnectionFactory();
    }

    @Test
    public void testGetConnection() throws Exception {
        assertNotNull(ConnectionFactory.getConnection());
    }

    @Test
    public void testSetUser() throws Exception {
        ConnectionFactory.setUser("Test");
        assertEquals("Test", ConnectionFactory.getUser());
    }

    @Test
    public void testSetPass() throws Exception {
        ConnectionFactory.setPass("PASS");
        assertEquals("PASS", ConnectionFactory.getPass());
    }
}