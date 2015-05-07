package hu.firstvan.view;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;

/**
 * Created by firstvan on 2015.04.26..
 */
public class AddProductStageTest {
    @Rule
    public JavaFXThreadingRule jfxRule = new JavaFXThreadingRule();

    @Before
    public void setUp(){
        new AddProductStage();
    }

    @Test
    public void testNotNull() {
        assertNotNull(AddProductStage.stage);
    }
}