package com.example.demo;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends Rectangle {
    // this is the that we are using for overlay of tiles
    public Tile (int x,int y){
        setWidth(DiceRoll.tileSize);
        setHeight(DiceRoll.tileSize);
        setFill(Color.PINK);
        setStroke(Color.BLACK);
    }
}
