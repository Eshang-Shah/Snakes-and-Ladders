package com.example.demo;
// this class is for the player object and does all the function that a player must do
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
// will hardcode as only 2 p[layers can play against each other
public class player extends Thread {
    //will use getters and setters
    private Stage st;
    private Scene go;
    private int posCircle=1;
    private boolean take_turn;
    private Circle icon;
    private int playerposX;
    private int playerposY;
    private String name;
    player(int x, int y,Circle b,String name) throws IOException{
        this.playerposX=x;
        this.playerposY=y;
        // setting the icon graphic
        this.icon=b;
        // intially set to true
        take_turn=true;
        this.name=name;
    }
    // image view to be dealt in the dice roll file
    //public Image getIcon(){
        //return icon;
    //}
    // this is done for taking turns
    public void setTake_turn(boolean b){
        this.take_turn=b;
    }
    // we are considering a circular token
    public void configure(){
        icon.setId(this.name);
        icon.setFill(Color.AQUA);
        icon.getStyleClass().add("style.css");
        icon.setTranslateX(this.playerposX);
        icon.setTranslateY(this.playerposY);
    }
    // setters
    public int getPlayerposX(){
        return this.playerposX;
    }
    public int getPlayerposY(){
        return this.playerposY;
    }
    public boolean getturn(){
        return this.take_turn;
    }
    public Circle getIcon(){
        return this.icon;
    }
    public void set_cordinates(int x,int y){
        this.playerposX=x;
        this.playerposY=y;
    }
    public void set_x(int x){
        this.playerposX=x;
    }
    public void set_y(int y){
        this.playerposY=y;
    }
    // for aanimation of the player pawn
    public void translatePlayer(int x, int y, Circle b){
        // for the image of goti god
        TranslateTransition animate = new TranslateTransition(Duration.millis(1200),b);
        animate.setToX(x);

        animate.setToY(y);
        animate.setAutoReverse(false);

        //try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
        animate.play();
        //animate.stop();
    }
    public void moove(int random) {
        if(posCircle==10 && this.getPlayerposX()-random*40<20){
            return;
        }
        else{
            for (int i=0; i<random; i++){

                if (posCircle%2==1){
                    //this.translatePlayer(this.getPlayerposX()+40,this.getPlayerposY(),this.icon);
                    this.set_x(this.getPlayerposX()+40);



                }
                if (posCircle%2==0){
                    //this.translatePlayer(this.getPlayerposX()-40,this.getPlayerposY(),this.icon);
                    this.set_x(this.getPlayerposX()-40);


                }
                if (this.getPlayerposX()>380){
                    //this.translatePlayer(this.getPlayerposX()-40,this.getPlayerposY()-40,this.icon);
                    this.set_y(this.getPlayerposY()-40);

                    this.set_x(this.getPlayerposX()-40);


                    posCircle++;
                }
                if (this.getPlayerposX()<20 && posCircle!=10){
                    //this.translatePlayer(this.getPlayerposX()+40,this.getPlayerposY()-40,this.icon);
                    this.set_y(this.getPlayerposY()-40);

                    this.set_x(this.getPlayerposX()+40);


                    posCircle++;
                }
                if (this.getPlayerposX()==20 && this.getPlayerposY()==20){
                    this.set_cordinates(20,20);

                    DiceRoll.gameStart=false;
                    DiceRoll.randDice.setText(this.name);
                    exit bye=new exit(this.name);
                    go=bye.disp();
                    st=new Stage();
                    st.setScene(go);
                    st.setHeight(700);
                    st.setWidth(700);
                    st.show();


                    DiceRoll.gameInitialize.setText("Play Again");
                }
                //try{Thread.sleep(1000);}catch(InterruptedException e){System.out.println(e);}



            }


        }

    }
    public int getPosCircle(){
        return this.posCircle;
    }

    public void setPosCircle(int posCircle) {
        this.posCircle = posCircle;
    }
    public void snake_ladder(){
        if(this.getPlayerposX()==180 && this.getPlayerposY()==380){
            this.setPosCircle(this.getPosCircle()+1);
            this.set_x(140);
            this.set_y(340);
            this.translatePlayer(this.getPlayerposX(), this.getPlayerposY(), this.getIcon());

        }
        else if(this.getPlayerposX()==260 && this.getPlayerposY()==380){
            this.setPosCircle(this.getPosCircle()+1);
            this.set_x(220);
            this.set_y(340);
            this.translatePlayer(this.getPlayerposX(), this.getPlayerposY(), this.getIcon());

        }
        else if(this.getPlayerposX()==340 && this.getPlayerposY()==380){
            this.setPosCircle(this.getPosCircle()+1);
            this.set_x(300);
            this.set_y(340);
            this.translatePlayer(this.getPlayerposX(), this.getPlayerposY(), this.getIcon());

        }
        else if(this.getPlayerposX()==140 && this.getPlayerposY()==260){
            this.setPosCircle(this.getPosCircle()+1);
            this.set_x(100);
            this.set_y(220);
            this.translatePlayer(this.getPlayerposX(), this.getPlayerposY(), this.getIcon());

        }
        else if(this.getPlayerposX()==220 && this.getPlayerposY()==260){
            this.setPosCircle(this.getPosCircle()+1);
            this.set_x(180);
            this.set_y(220);
            this.translatePlayer(this.getPlayerposX(), this.getPlayerposY(), this.getIcon());

        }
        else if(this.getPlayerposX()==300 && this.getPlayerposY()==260){
            this.setPosCircle(this.getPosCircle()+1);
            this.set_x(260);
            this.set_y(220);
            this.translatePlayer(this.getPlayerposX(), this.getPlayerposY(), this.getIcon());

        }
        else if(this.getPlayerposX()==140 && this.getPlayerposY()==140){
            this.setPosCircle(this.getPosCircle()+2);
            this.set_x(100);
            this.set_y(60);
            this.translatePlayer(this.getPlayerposX(), this.getPlayerposY(), this.getIcon());

        }
        else if(this.getPlayerposX()==220 && this.getPlayerposY()==140){
            this.setPosCircle(this.getPosCircle()+2);
            this.set_x(180);
            this.set_y(60);
            this.translatePlayer(this.getPlayerposX(), this.getPlayerposY(), this.getIcon());

        }
        else if(this.getPlayerposX()==300 && this.getPlayerposY()==140){
            this.setPosCircle(this.getPosCircle()+2);
            this.set_x(260);
            this.set_y(60);
            this.translatePlayer(this.getPlayerposX(), this.getPlayerposY(), this.getIcon());

        }
        else if(this.getPlayerposX()==20 && this.getPlayerposY()==260){
            this.setPosCircle(this.getPosCircle()+5);
            this.set_x(20);
            this.set_y(60);
            this.translatePlayer(this.getPlayerposX(), this.getPlayerposY(), this.getIcon());

        }
        // hard coded for snakes
        else if(this.getPlayerposX()==60 && this.getPlayerposY()==20){
            this.setPosCircle(this.getPosCircle()-2);
            this.set_x(100);
            this.set_y(100);
            this.translatePlayer(this.getPlayerposX(),this.getPlayerposY(),this.getIcon());
        }
        else if(this.getPlayerposX()==140 && this.getPlayerposY()==20){
            this.setPosCircle(this.getPosCircle()-2);
            this.set_x(180);
            this.set_y(100);
            this.translatePlayer(this.getPlayerposX(),this.getPlayerposY(),this.getIcon());
        }
        else if(this.getPlayerposX()==220 && this.getPlayerposY()==20){
            this.setPosCircle(this.getPosCircle()-2);
            this.set_x(260);
            this.set_y(100);
            this.translatePlayer(this.getPlayerposX(),this.getPlayerposY(),this.getIcon());
        }
        else if(this.getPlayerposX()==380 && this.getPlayerposY()==20){
            this.setPosCircle(this.getPosCircle()-5);
            this.set_x(380);
            this.set_y(220);
            this.translatePlayer(this.getPlayerposX(),this.getPlayerposY(),this.getIcon());
        }
        else if(this.getPlayerposX()==60 && this.getPlayerposY()==180){
            this.setPosCircle(this.getPosCircle()-2);
            this.set_x(100);
            this.set_y(260);
            this.translatePlayer(this.getPlayerposX(),this.getPlayerposY(),this.getIcon());
        }
        else if(this.getPlayerposX()==140 && this.getPlayerposY()==180){
            this.setPosCircle(this.getPosCircle()-2);
            this.set_x(180);
            this.set_y(260);
            this.translatePlayer(this.getPlayerposX(),this.getPlayerposY(),this.getIcon());
        }
        else if(this.getPlayerposX()==220 && this.getPlayerposY()==180){
            this.setPosCircle(this.getPosCircle()-2);
            this.set_x(260);
            this.set_y(260);
            this.translatePlayer(this.getPlayerposX(),this.getPlayerposY(),this.getIcon());
        }
        else if(this.getPlayerposX()==140 && this.getPlayerposY()==300){
            this.setPosCircle(this.getPosCircle()-1);
            this.set_x(100);
            this.set_y(340);
            this.translatePlayer(this.getPlayerposX(),this.getPlayerposY(),this.getIcon());
        }
        else if(this.getPlayerposX()==220 && this.getPlayerposY()==300){
            this.setPosCircle(this.getPosCircle()-1);
            this.set_x(180);
            this.set_y(340);
            this.translatePlayer(this.getPlayerposX(),this.getPlayerposY(),this.getIcon());
        }
        else if (this.getPlayerposX()==300 && this.getPlayerposY()==300){
            this.setPosCircle(this.getPosCircle()-1);
            this.set_x(260);
            this.set_y(340);
            this.translatePlayer(this.getPlayerposX(),this.getPlayerposY(),this.getIcon());
        }
        else{
            this.translatePlayer(this.getPlayerposX(),this.getPlayerposY(),this.getIcon());

        }
    }
}
