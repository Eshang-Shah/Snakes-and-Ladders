package com.example.demo;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
public class exit {
    // this is for working out on a exit screen when a player wins
    // WORK TO BE DONE
    private Stage st;
    private Label lt;
    private Button b1;
    private Button b2;
    public exit(String s){
        lt=new Label("CONGRATULATIONS"+"-------->"+s);
        lt.setTextFill(Color.GOLD);
        lt.setTranslateX(350);
        lt.setTranslateY(350);

    }

    public Scene disp()  {
        Group root = new Group();
        b1=new Button("PLAY AGIAN");
        //b1.setTextFill(Color.GREEN);
        b1.setTranslateX(350);
        b1.setTranslateY(400);
        
        b2=new Button("EXIT");
        //b2.setTextFill(Color.RED);
        b2.setTranslateX(20);
        b2.setTranslateY(600);
        
        b2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Platform.exit();
            }
        });
        b2.setTextFill(Color.RED);

        b1.setTextFill(Color.GREEN);
        b1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DiceRoll bc= null;
                try {
                    bc = new DiceRoll();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Scene scene = null;
                try {
                    scene = new Scene(bc.createContent(), Color.RED);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                st= (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
                st.setScene(scene);
                st.show();
            }
        });


//        InputStream image=new FileInputStream("/Users/abhinav_mac/Documents/demo/src/main/resources/com/example/demo/img.png");
//        Image icon=new Image(image);
//        ImageView view=new ImageView(icon);
//        view.setX(300);
//        view.setY(300);
        //view.setPreserveRatio(true);
        //view.setFitWidth(50);
        root.getChildren().addAll(b1,this.lt,this.b2);

        Scene scn = new Scene(root, Color.RED);
        return scn;

    }






}
