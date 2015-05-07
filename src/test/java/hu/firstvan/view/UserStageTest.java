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
<<<<<<< HEAD
        new CustomerStage();
=======
        new UserStage();
>>>>>>> 9642e09e97c72de16cc3df97f83d98647eb471ce
    }

    @Test
    public void testNotNull() {
<<<<<<< HEAD
        TestCase.assertNotNull(CustomerStage.stage);
=======
        TestCase.assertNotNull(UserStage.stage);
>>>>>>> 9642e09e97c72de16cc3df97f83d98647eb471ce
    }

    @Test
    public void testControllerNotNull() {
<<<<<<< HEAD
        TestCase.assertNotNull(CustomerStage.getController());
=======
        TestCase.assertNotNull(UserStage.getController());
>>>>>>> 9642e09e97c72de16cc3df97f83d98647eb471ce
    }
}