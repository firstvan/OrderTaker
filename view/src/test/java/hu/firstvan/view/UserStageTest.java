package hu.firstvan.view;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class UserStageTest {
    @Rule
    public JavaFXThreadingRule jfxRule = new JavaFXThreadingRule();

    @Before
    public void setUp() throws Exception {
        new CustomerStage();
    }

    @Test
    public void testNotNull() {
        TestCase.assertNotNull(CustomerStage.stage);
        TestCase.assertNotNull(CustomerStage.stage);
    }

    @Test
    public void testControllerNotNull() {
        TestCase.assertNotNull(CustomerStage.getController());
        TestCase.assertNotNull(CustomerStage.getController());
    }
}