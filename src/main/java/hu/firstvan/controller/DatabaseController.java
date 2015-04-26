package hu.firstvan.controller;

import hu.firstvan.model.ConnectionFactory;
import hu.firstvan.view.MainStage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class DatabaseController implements Initializable {
    private static MainStage mainStage;

    @FXML
    private javafx.scene.control.TextField jdbc_user;

    @FXML
    private javafx.scene.control.TextField jdbc_pass;

    public static MainStage getMainStage() {
        return mainStage;
    }

    @FXML
    public void LogInAction(ActionEvent event) throws Exception {

        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
        ConnectionFactory.setUser(jdbc_user.getText());
        ConnectionFactory.setPass(jdbc_pass.getText());
        mainStage = new MainStage();

    }

    @FXML
    public void ExitAction(ActionEvent event) {
        System.exit(1);
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private Button jdbc_login;

    @FXML
    public void userField(KeyEvent event) {

        if (jdbc_user.getText().length() >= 0 && jdbc_pass.getText().length() > 0) {
            jdbc_login.setDisable(false);
        } else {
            jdbc_login.setDisable(true);
        }
    }

    @FXML
    public void passwordField(KeyEvent event) {
        if (jdbc_user.getText().length() > 0 && jdbc_pass.getText().length() >= 0) {
            jdbc_login.setDisable(false);
        } else {
            jdbc_login.setDisable(true);
        }
    }
}
