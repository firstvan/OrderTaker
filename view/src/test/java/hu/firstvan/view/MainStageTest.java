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
public class MainStageTest {

    @Rule
    public JavaFXThreadingRule jfxRule = new JavaFXThreadingRule();

    @Before
    public void setUp() throws Exception{
        new MainStage();
    }

    @Test
    public void testNotNull() {
        TestCase.assertNotNull(MainStage.stage);
    }

    @Test
    public void testAfterChange() throws Exception {
        Date start = new Date(new GregorianCalendar(2014, 7, 20).getTime().getTime());
        Customer customer = new Customer(1, "Test", start, "Test street", start);
        Datas.setCustomer(customer);
        MainStage.setCustName();
        TestCase.assertNotNull(MainStage.stage);
    }

    @Test
    public void testSceneNotNull(){
        TestCase.assertNotNull(MainStage.stage.getScene());
    }
}