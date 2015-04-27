package hu.firstvan.view;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * Created by firstvan on 2015.04.26..
 */
public class UserStageTest {
    @Rule
    public JavaFXThreadingRule jfxRule = new JavaFXThreadingRule();

    @Before
    public void setUp() throws Exception {
        new UserStage();
    }

    @Test
    public void testNotNull() {
        TestCase.assertNotNull(UserStage.stage);
    }

    @Test
    public void testControllerNotNull() {
        TestCase.assertNotNull(UserStage.getController());
    }
}