package hu.firstvan.view;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by firstvan on 2015.04.26..
 */
public class AddCustomerStageTest {

    @Rule
    public JavaFXThreadingRule jfxRule = new JavaFXThreadingRule();

    @Before
    public void setUp() throws Exception {
        new AddCustomerStage();
    }

    @Test
    public void testNotNull() {
        assertNotNull(AddCustomerStage.stage);
    }


}