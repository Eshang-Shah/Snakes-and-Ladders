package com.example.demo;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
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


public class DiceRoll extends Application {
    public Stage change;
    private boolean check1=false;   // for opening the pawn
    private boolean check2=false;   // for opening the pawn
    public int[][] cirPos =new int[10][10];
    public int[][] ladderPos = new int[6][3];
    Dice my=new Dice();

    public static final int tileSize=40;
    public static final int width=10;
    public static final int height=10;
    public int random;
    public static Label randDice;
    // for grid pane of tiles on screen
    private Group tileGroup = new Group();
    // visual display of player1
    Circle p1= new Circle(10);
    Circle p2= new Circle(10);

    player player1=new player(25,410,p1,"p1");
    player player2=new player(20,410,p2,"p2");







    // for moving purposes TO BE DEALT WITH LATER
    //public int playerPosition1=1;
    //public int playerPosition2=1;

    // for taking sequential turns



    //public static int posCircle1=1;   // taken into consideration
    //public static int posCircle2=1;
    // setting the start game intitially as false
    public static boolean gameStart=false;

    public static Button gameInitialize;

    public DiceRoll() throws IOException {
    }

    public Parent createContent() throws FileNotFoundException {
        // for making a grid pane
        Pane root = new Pane();
        //made it dynamic by using width*tileSize and height*tileSize instead of directly using numbers.
        //added 80 as we need space to add buttons for dice and other operations
        root.setPrefSize(width*tileSize,(height*tileSize)+200);
        root.getChildren().addAll(tileGroup);
        // setting up a 2d matrix/grid
        for(int i =0; i<height; i++){
            for (int j=0; j<width; j++){
                Tile tile=new Tile(tileSize,tileSize);
                tile.setTranslateX(j*tileSize);
                tile.setTranslateY(i*tileSize);

                tileGroup.getChildren().add(tile);
                //X-coordinate
                //cirPos[i][j]=j*(tileSize-40);

            }
        }
//        //To calculate value of X coordinate
//        for(int j=0; j<height; j++){
//            for (int k=0; k<width; k++){
//                System.out.println(cirPos[j][k]+" ");
//            }
//            System.out.println();
//        }
        //defining 6 dices
        //1
        InputStream dice_1 = new FileInputStream("/Users/abhinav_mac/Documents/demo/src/main/resources/d1.png");

        Image dice1= new Image(dice_1);
        ImageView d1 = new ImageView(dice1);
        d1.setFitHeight(50);
        d1.setPreserveRatio(true);

        //2
        InputStream dice_2 = new FileInputStream("/Users/abhinav_mac/Documents/demo/src/main/resources/d2.png");


        Image dice2= new Image(dice_2);
        ImageView d2 = new ImageView(dice2);
        d2.setFitHeight(50);
        d2.setPreserveRatio(true);

        //3
        InputStream dice_3 = new FileInputStream("/Users/abhinav_mac/Documents/demo/src/main/resources/d3.png");


        Image dice3= new Image(dice_3);
        ImageView d3 = new ImageView(dice3);
        d3.setFitHeight(50);
        d3.setPreserveRatio(true);

        //4
        InputStream dice_4 = new FileInputStream("/Users/abhinav_mac/Documents/demo/src/main/resources/d4.png");


        Image dice4= new Image(dice_4);
        ImageView d4 = new ImageView(dice4);
        d4.setFitHeight(50);
        d4.setPreserveRatio(true);

        //5
        InputStream dice_5 = new FileInputStream("/Users/abhinav_mac/Documents/demo/src/main/resources/d5.png");


        Image dice5= new Image(dice_5);
        ImageView d5 = new ImageView(dice5);
        d5.setFitHeight(50);
        d5.setPreserveRatio(true);

        //6
        InputStream dice_6 = new FileInputStream("/Users/abhinav_mac/Documents/demo/src/main/resources/d6.png");


        Image dice6= new Image(dice_6);
        ImageView d6 = new ImageView(dice6);
        d6.setFitHeight(50);
        d6.setPreserveRatio(true);
        InputStream st = new FileInputStream("/Users/abhinav_mac/Documents/demo/src/main/resources/d.jpg");
        Image imgs = new Image(st);
        ImageView view = new ImageView(imgs);
        Label dice = new Label("");
        dice.setTextFill(Color.GREEN);
        dice.setGraphic(view);
        dice.setTranslateX(180);
        dice.setTranslateY(440);
        view.setFitHeight(50);
        view.setPreserveRatio(true);
        //InputStream player1_img = new FileInputStream("/Users/abhinav_mac/Documents/demo/src/main/resources/pawn1-01.png");

        //Image P1= new Image(player1_img);
        //ImageView player1=new ImageView(P1);

        //player1.setPreserveRatio(true);
        //player1.setFitWidth(50);
        // intialising the position of the two players


        //player1.setId("P1");
        //player1.setFill(Color.AQUA);
        //player1.getStyleClass().add("style.css");
        //player1.setTranslateX(player1posX);
        //player1.setTranslateY(player1posY);


        //InputStream player2_img = new FileInputStream("/Users/abhinav_mac/Documents/demo/src/main/resources/Untitled-2-01.png");

        //Image P2= new Image(player2_img);
        //ImageView player2=new ImageView(P2);
        //player2.setId("P2");
        //player2.setPreserveRatio(true);
       //player2.setFitWidth(50);
        //player2.setFill(Color.WHITE);
        //player2.getStyleClass().add("style.css");
        //player2.setTranslateX(player2posX);
        //player2.setTranslateY(player2posY);
        // creating buttons for players
        Button button2Player = new Button("P2");
        Image imgss = new Image("goti2.png");
        ImageView views = new ImageView(imgss);
        button2Player.setGraphic(views);
        button2Player.setTranslateX(280);
        button2Player.setTranslateY(440);
        views.setFitHeight(40);
        views.setPreserveRatio(true);


        //lamda expression used here
        button2Player.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (gameStart){
                    if (player2.getturn()){

                        random=my.getDiceValue();
                        randDice.setText(String.valueOf(random));
                        if (random==1){
                            check2=true;
                            dice.setGraphic(d1);
                        }
                        if (random==2){
                            dice.setGraphic(d2);
                        }
                        if (random==3){
                            dice.setGraphic(d3);
                        }
                        if (random==4){
                            dice.setGraphic(d4);
                        }
                        if (random==5){
                            dice.setGraphic(d5);
                        }
                        if (random==6){
                            dice.setGraphic(d6);
                        }
                        // for deciding the type of movement and the coordinates of the tile pane

                        move2Player();

                        player2.snake_ladder();




                        //ensure single turn each time
                        player1.setTake_turn(true);
                        player2.setTake_turn(false);
                        //when we will consider the snake and ladder on the grid
                        //playerPosition2+=random;

                    }
                }
            }
        });

        Button button1Player = new Button("P1");
        Image img1 = new Image("goti1.png");
        ImageView view1 = new ImageView(img1);
        button1Player.setGraphic(view1);
        view1.setFitHeight(40);
        view1.setPreserveRatio(true);
        button1Player.setTranslateX(40);
        button1Player.setTranslateY(440);
        button1Player.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (gameStart){
                    if (player1.getturn()){
                        random= my.getDiceValue();
                        randDice.setText(String.valueOf(random));
                        if (random==1){
                            check1=true;
                            dice.setGraphic(d1);
                        }
                        if (random==2){
                            dice.setGraphic(d2);
                        }
                        if (random==3){
                            dice.setGraphic(d3);
                        }
                        if (random==4){
                            dice.setGraphic(d4);
                        }
                        if (random==5){
                            dice.setGraphic(d5);
                        }
                        if (random==6){
                            dice.setGraphic(d6);
                        }

                        move1Player();


                        player1.snake_ladder();


                        //ensure single turn each time
                        player2.setTake_turn(true);
                        player1.setTake_turn(false);
                        //playerPosition1+=random;
//                        if (player1posX==80 && player1posY==760){
//                            translatePlayer();
//
//                        }
                    }
                }

            }
        });


        // fo the play button
        gameInitialize=new Button("Play Now");
        gameInitialize.setTextFill(Color.GREEN);
        gameInitialize.setTranslateX(171);
        gameInitialize.setTranslateY(405);
        gameInitialize.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                gameInitialize.setText("Game in Progress");
                player1.set_cordinates(20,380);
                player2.set_cordinates(20,380);
                player1.getIcon().setTranslateX(player1.getPlayerposX());
                player1.getIcon().setTranslateY(player1.getPlayerposY());
                player2.getIcon().setTranslateX(player2.getPlayerposX());
                player2.getIcon().setTranslateY(player2.getPlayerposY());
                gameStart=true;

            }
        });
        // for the dice button
        randDice=new Label("0");
        randDice.setTranslateX(150);
        randDice.setTranslateY(410);
        InputStream str = new FileInputStream("/Users/abhinav_mac/Documents/demo/src/main/resources/com/example/demo/scene.jpeg");
        Image img = new Image(str);
        ImageView bgImage = new ImageView();
        bgImage.setImage(img);
        bgImage.setFitHeight(400);
        bgImage.setFitWidth(400);
        Button back=new Button("EXIT");
        back.setTextFill(Color.RED);
        back.setTranslateX(40);
        back.setTranslateY(550);
        Image exit=new Image("exit.png");
        ImageView viewExit=new ImageView(exit);
        viewExit.setFitHeight(20);
        viewExit.setFitWidth(20);
        viewExit.setPreserveRatio(true);
        back.setGraphic(viewExit);
        button1Player.setTextFill(Color.DARKBLUE);
        button2Player.setTextFill(Color.DARKBLUE);
        back.setOnAction(new EventHandler<ActionEvent>(){



            public void handle(ActionEvent actionEvent)  {
                Platform.exit();
            }
        });
        player1.configure();
        player2.configure();
        player2.getIcon().setFill(Color.RED);









        tileGroup.getChildren().addAll(bgImage,player1.getIcon(),player2.getIcon(),button2Player,button1Player,gameInitialize,dice,back);
        return root;


    }



    // giti kholne ke liye

    private void move1Player()  {
        if(check1){
           player1.moove(random);
        }

    }
    private void move2Player(){
        if(check2){

            player2.moove(random);
        }

    }


    public Parent setpls() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(DiceRoll.class.getResource("main.fxml"));

        Parent ro= fxmlLoader.load();
        return ro;
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(DiceRoll.class.getResource("main.fxml"));
        Parent root=fxmlLoader.load();
        Scene scene=new Scene(root);



        stage.setTitle("Snake and Ladder");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}