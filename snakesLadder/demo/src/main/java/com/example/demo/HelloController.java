package com.example.demo;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloController {
    //GUI components
    @FXML
    private Label wt;
    @FXML
    private Button bb;
    @FXML
    private Button hb;
    //real world objects
    rotator rtt;
    rotor rtr;
    display dsp;

    @FXML
    void onHelloButtonClick() {//On clicking the rotator
        myth th1=new myth(rtt,rtr,dsp);
        rtr.allow_rotation();// the rotor is allowed to rotate
        th1.start();
    }

    @FXML
    void onButtonClick() {//On clicking the rotor
        rtr.stop_rotation();//the rotor is not allowed to rotate
    }

    public void initialize(){//for assigning the GUI components to real world objects  and initialization
        rtt=new rotator(hb);
        rtr=new rotor(bb);
        dsp=new display(wt,"Rotated "+bb.getRotate()+" degrees so far.");
    }
}

class rotor{
    Button bb;
    int state;
    rotor(Button bb){
        this.bb=bb;
        this.state=0;
    }
    void rotate(){bb.setRotate(bb.getRotate()+30);}
    void stop_rotation(){ state=0;}
    void allow_rotation(){ state=1;}
}

class rotator{
    Button hb;
    rotator(Button hb){
        this.hb=hb;
    }
    public void keep_rotating(rotor rtr, display dsp){
        while(true){
            if (rtr.state==1){//The idea is to allow rotor rotation as long as the rotor state is 1.
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Platform.runLater(new Runnable2(rtr,dsp));
            }else{break;}
        }
    }
}

class display{
    Label wt;
    display(Label wt,String s){
        this.wt=wt;
        wt.setText(s);
    }
    void display_current(String s){wt.setText(s);}
}

class myth extends Thread{
    rotator rtt;
    rotor rtr;
    display dsp;
    myth(rotator rtt, rotor rtr, display dsp){
        this.rtr=rtr;
        this.rtt=rtt;
        this.dsp=dsp;
    }
    @Override
    public void run(){
        rtt.keep_rotating(rtr,dsp);
    }
}

class Runnable2 implements Runnable{
    rotor rtr;
    display dsp;
    Runnable2(rotor rtr, display dsp){
        this.rtr=rtr;
        this.dsp=dsp;
    }
    @Override
    public void run() {
        rtr.rotate();
        dsp.display_current("Rotated "+rtr.bb.getRotate()+" degrees so far.");
    }
}