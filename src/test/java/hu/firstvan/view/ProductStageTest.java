package hu.firstvan.view;

import hu.firstvan.model.Customer;
import hu.firstvan.model.Datas;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.sql.Date;
import java.util.GregorianCalendar;

/**
 * Created by firstvan on 2015.04.26..
 */
public class ProductStageTest {

    @Rule
    public JavaFXThreadingRule jfxRule = new JavaFXThreadingRule();

    @Before
    public void setUp() throws Exception{
        Date start = new Date(new GregorianCalendar(2014, 7, 20).getTime().getTime());
        Customer customer = new Customer(1, "Test", start, "Test street", start);
        Datas.setCustomer(customer);
        new ProductStage();
    }

    @Test
    public void testNotNull() {
        TestCase.assertNotNull(ProductStage.stage);
    }

}