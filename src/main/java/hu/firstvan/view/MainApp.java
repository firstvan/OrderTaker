package hu.firstvan.view;


import javafx.application.Application;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This application serves to take order.
 * The main class of application. Start the right stage.
 */
public class MainApp extends Application {

    private static Logger logger = LoggerFactory.getLogger(MainApp.class);

    /**
     * Start the applications.
     *
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        //new DatabaseStage();
        new MainStage();
        logger.info("Application started.");
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        logger.info("Application starting...");
        launch(args);
    }


}
