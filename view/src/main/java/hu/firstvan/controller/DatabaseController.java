package hu.firstvan.controller;

import hu.firstvan.model.ConnectionFactory;
import hu.firstvan.view.DatabaseStage;
import hu.firstvan.view.MainStage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ResourceBundle;


/**
 * Controll the Database sign in stage.
 */
public class DatabaseController implements Initializable {

    /**
     * Database user name.
     */
    @FXML
    private javafx.scene.control.TextField jdbc_user;

    /**
     * Database user password.
     */
    @FXML
    private javafx.scene.control.TextField jdbc_pass;

    /**
     * Set's static database user information, and open Main window.
     *
     * @param event default param in javafx controller.
     * @throws Exception when the {@code mainstage.fxml} could not found.
     */
    @FXML
    public void LogInAction(ActionEvent event) throws Exception {


        ConnectionFactory.setUser(jdbc_user.getText());
        ConnectionFactory.setPass(jdbc_pass.getText());

        if (ConnectionFactory.test()) {
            new MainStage();
            DatabaseStage.stage.close();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Hiba");
            alert.setHeaderText("Hibás felhasználónév vagy jelszó / Adatbázis nem elérhető");
            alert.show();
        }

    }

    /**
     * Exit when x button is clicked.
     *
     * @param event x button is clicked
     */
    @FXML
    public void ExitAction(ActionEvent event) {
        System.exit(1);
    }

    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param url The location used to resolve relative paths for the root object, or
     *            <tt>null</tt> if the location is not known.
     * @param rb  The resources used to localize the root object, or <tt>null</tt> if
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    /**
     * A button to log in database, and load the main view.
     */
    @FXML
    private Button jdbc_login;

    /**
     * Check user and password field is not empty.
     *
     * @param event get a keyevent
     */
    @FXML
    public void userField(KeyEvent event) {

        if (event.getCode().equals(KeyCode.ENTER)) {
            try {
                logInEnter();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (jdbc_user.getText().length() >= 0 && jdbc_pass.getText().length() > 0) {
            jdbc_login.setDisable(false);
        } else {
            jdbc_login.setDisable(true);
        }
    }

    /**
     * Check user and password field is not empty.
     *
     * @param event get a keyevent
     */
    @FXML
    public void passwordField(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            try {
                logInEnter();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (jdbc_user.getText().length() > 0 && jdbc_pass.getText().length() >= 0) {
            jdbc_login.setDisable(false);
        } else {
            jdbc_login.setDisable(true);
        }
    }

    /**
     * Log in to database, when user use enter.
     *
     * @param event key event with necessary information from event.
     */
    public void logInEnter() {
        ConnectionFactory.setUser(jdbc_user.getText());
        ConnectionFactory.setPass(jdbc_pass.getText());

        if (ConnectionFactory.test()) {
            try {
                new MainStage();
            } catch (Exception e) {
                e.printStackTrace();
            }
            DatabaseStage.stage.close();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Hiba");
            alert.setHeaderText("Hibás felhasználónév vagy jelszó / Adatbázis nem elérhető");
            alert.show();
        }
    }

}
