package hu.firstvan.view;

import javafx.application.Application;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by firstvan on 2015.04.26..
 */
public class MainAppTest {

    @BeforeClass
    public static void initJFX() throws Exception {
        Thread t = new Thread("JavaFX init thread") {
            public void run() {
                Application.launch(MainApp.class);
            }
        };
        t.setDaemon(true);
        t.start();
        Thread.sleep(1000);
    }

    @Test
    public void testNotNull() throws Exception {
        assertNotNull(MainStage.stage);
    }


}