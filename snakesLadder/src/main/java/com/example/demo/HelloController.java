package com.example.demo;
// to do debug and winning screen for the winner and if time is left then choose goti

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
    // controller class for the first screen
public class HelloController {
    private Stage st;
    @FXML
    private Button button;
    @FXML
    private Button play;

    @FXML
    void hit(ActionEvent event) throws IOException {
        DiceRoll bc=new DiceRoll();
        Scene scene = new Scene(bc.createContent(),Color.RED);
        st= (Stage)((Node)event.getSource()).getScene().getWindow();
        st.setScene(scene);
        st.show();



    }

    @FXML
    public void onButtonPressed(ActionEvent event) {
        Platform.exit();
    }















}