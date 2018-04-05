package network;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import network.sqlDB;
import network.xo_scene_networkPlayingBase;

public class recallBase extends AnchorPane {

    protected final Button button;
    protected final Button button0;
    protected final ListView listView;
    protected final Button button1;
    protected final Button button2;
    protected final Button button3;
    protected final Button button4;
    protected final Button button5;
    protected final Button button6;
    protected final Button button7;
    protected final Button button8;
    protected final Button button9;
    protected final Button button10;
    protected final Button button11;
    protected final Label label;
    protected final Button button12;
    private ResultSet result;
    private Button[] board;
    private Image imageX=new Image(getClass().getResourceAsStream("x.png"));
    private Image imageO=new Image(getClass().getResourceAsStream("O.png"));
    private char flagImage;
    private int flagAutoplay;
    
    public recallBase(Stage stage,String Status,int fplayerID,int gameID,int flag) {

        button = new Button();
        button0 = new Button();
        listView = new ListView();
        button1 = new Button();
        button2 = new Button();
        button3 = new Button();
        button4 = new Button();
        button5 = new Button();
        button6 = new Button();
        button7 = new Button();
        button8 = new Button();
        button9 = new Button();
        button10 = new Button();
        button11 = new Button();
        label = new Label();
        button12 = new Button();
          board= new Button[9];
        
board[0]=button1;
board[1]=button2;
board[2]=button3;
board[3]=button4;
board[4]=button5;
board[5]=button6;
board[6]=button7;
board[7]=button8;
board[8]=button9;
       flagImage='x'; 
       flagAutoplay=0;
        try {
            result=sqlDB.getgameMoves(fplayerID, gameID);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

         class MyThread extends Thread{
    @Override
    public void run() {
        while (true) {            
            try {
                
                    if(result.next()){
                    int boardCell=result.getInt(1);
                    System.out.println(boardCell);
                    if(flagImage=='x'){
                          Platform.runLater(new Runnable()

                {
                    @Override
                    public void run()

                    {
                      ImageView  imgView = new ImageView(imageX);
                     imgView.setFitWidth(150);
                     imgView.setPreserveRatio(true);
                     board[boardCell-1].setGraphic(imgView); 
                     System.out.println("next "+boardCell+" "+flagImage);
                     flagImage='O';
                    }
                });
                     
                    
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }else{
                              Platform.runLater(new Runnable()

                {
                    @Override
                    public void run()

                    {
                     ImageView  imgView = new ImageView(imageO);
                     imgView.setFitWidth(150);
                     imgView.setPreserveRatio(true);
                     board[boardCell-1].setGraphic(imgView); 
                     System.out.println("next "+boardCell+" "+flagImage);
                     flagImage='x';
                    }
                });
                          
                     try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                    }else{
                        result.previous();
                        //flagResult=0;
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } 
        }
         
    }
    }
        setId("AnchorPane");
        setPrefHeight(700.0);
        setPrefWidth(700.0);
        setStyle("-fx-background-color: Linear-gradient(#0099CC,white,#0099CC);;");
        setOpaqueInsets(new Insets(0.0));

        AnchorPane.setBottomAnchor(button, 20.0);
        AnchorPane.setLeftAnchor(button, 469.0);
        AnchorPane.setRightAnchor(button, 39.0);
        button.setLayoutX(469.0);
        button.setLayoutY(625.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(50.0);
        button.setPrefWidth(200.0);
        button.setStyle("-fx-background-color: #F33250; -fx-font-size: 18; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 10, 6);");
        button.setText("Home");
        button.setTextFill(javafx.scene.paint.Color.WHITE);
         button.setOnAction(new EventHandler<ActionEvent>(){
     @Override
     public void handle(ActionEvent event) {
         
        
        Scene s = new Scene(new FXMLTicTacToe(stage), 700, 700);
        stage.setScene(s);
      
     }
            
        }
        );
        AnchorPane.setBottomAnchor(button0, 20.0);
        button0.setLayoutX(31.0);
        button0.setLayoutY(625.0);
        button0.setMnemonicParsing(false);
        button0.setPrefHeight(50.0);
        button0.setPrefWidth(200.0);
        button0.setStyle("-fx-background-color: #F33250; -fx-font-size: 18; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 10, 6);");
        button0.setText("back");
        button0.setTextFill(javafx.scene.paint.Color.WHITE);
        button0.setOnAction(new EventHandler<ActionEvent>(){
     @Override
     public void handle(ActionEvent event) {
              /*
                   Scene s;
         try {
             s = new Scene(new xo_scene_networkPlayingBase(stage), 700, 700);
             stage.setScene(s);
         } catch (Exception ex) {
             ex.printStackTrace();
         }
               
              
      */
              
              if(flag==1){
//               Scene s;
//         try {
//             s = new Scene(new xo_scene_localPlayingBase(stage), 700, 700);
//             stage.setScene(s);
//         } catch (Exception ex) {
//             ex.printStackTrace();
//         }
//              }else if(flag==2){
//               Scene s;
//         try {
//             s = new Scene(new computerfinalBase(stage), 700, 700);
//             stage.setScene(s);
//         } catch (Exception ex) {
//             ex.printStackTrace();
//         }
              }else if(flag==3){
               Scene s;
         try {
             s = new Scene(new xo_scene_networkPlayingBase(stage), 700, 700);
             stage.setScene(s);
         } catch (Exception ex) {
             ex.printStackTrace();
         }
              }
              
              
     }
           
        }

        );
        listView.setEditable(true);
        listView.setLayoutX(191.0);
        listView.setLayoutY(160.0);
        listView.setPrefHeight(200.0);
        listView.setPrefWidth(455.0);
        listView.setStyle("-fx-background-color: transparent;");

        AnchorPane.setBottomAnchor(button1, 418.0);
        AnchorPane.setTopAnchor(button1, 105.0);
        button1.setLayoutX(93.0);
        button1.setLayoutY(109.0);
        button1.setMnemonicParsing(false);
        button1.setPrefHeight(170.0);
        button1.setPrefWidth(170.0);
        button1.setStyle("-fx-background-color: transparent; -fx-border-width: 2px; -fx-border-color: #000000;");

        AnchorPane.setBottomAnchor(button2, 418.0);
        AnchorPane.setTopAnchor(button2, 105.0);
        button2.setLayoutX(263.0);
        button2.setLayoutY(105.0);
        button2.setMnemonicParsing(false);
        button2.setPrefHeight(170.0);
        button2.setPrefWidth(170.0);
        button2.setStyle("-fx-background-color: transparent; -fx-border-color: #000000; -fx-border-width: 2px;");

        AnchorPane.setBottomAnchor(button3, 418.0);
        AnchorPane.setTopAnchor(button3, 105.0);
        button3.setLayoutX(433.0);
        button3.setLayoutY(109.0);
        button3.setMnemonicParsing(false);
        button3.setPrefHeight(170.0);
        button3.setPrefWidth(170.0);
        button3.setStyle("-fx-background-color: transparent; -fx-border-width: 2px; -fx-border-color: #000000;");

        AnchorPane.setTopAnchor(button4, 282.0);
        button4.setLayoutX(93.0);
        button4.setLayoutY(282.0);
        button4.setMnemonicParsing(false);
        button4.setPrefHeight(170.0);
        button4.setPrefWidth(170.0);
        button4.setStyle("-fx-background-color: transparent; -fx-border-color: #000000; -fx-border-width: 2px;");

        button5.setLayoutX(263.0);
        button5.setLayoutY(282.0);
        button5.setMnemonicParsing(false);
        button5.setPrefHeight(170.0);
        button5.setPrefWidth(170.0);
        button5.setStyle("-fx-background-color: transparent; -fx-border-color: #000000; -fx-border-width: 2px;");

        button6.setLayoutX(433.0);
        button6.setLayoutY(282.0);
        button6.setMnemonicParsing(false);
        button6.setPrefHeight(170.0);
        button6.setPrefWidth(170.0);
        button6.setStyle("-fx-background-color: transparent; -fx-border-color: #000000; -fx-border-width: 2px;");

        AnchorPane.setBottomAnchor(button7, 78.0);
        AnchorPane.setTopAnchor(button7, 452.0);
        button7.setLayoutX(93.0);
        button7.setLayoutY(452.0);
        button7.setMnemonicParsing(false);
        button7.setPrefHeight(170.0);
        button7.setPrefWidth(170.0);
        button7.setStyle("-fx-background-color: transparent; -fx-border-color: #000000; -fx-border-width: 2px;");

        AnchorPane.setBottomAnchor(button8, 78.0);
        AnchorPane.setTopAnchor(button8, 452.0);
        button8.setLayoutX(263.0);
        button8.setLayoutY(282.0);
        button8.setMnemonicParsing(false);
        button8.setPrefHeight(170.0);
        button8.setPrefWidth(170.0);
        button8.setStyle("-fx-background-color: transparent; -fx-border-color: #000000; -fx-border-width: 2px;");

        button9.setLayoutX(433.0);
        button9.setLayoutY(452.0);
        button9.setMnemonicParsing(false);
        button9.setPrefHeight(170.0);
        button9.setPrefWidth(170.0);
        button9.setStyle("-fx-background-color: transparent; -fx-border-color: #000000; -fx-border-width: 2px;");

        AnchorPane.setLeftAnchor(button10, 0.0);
        AnchorPane.setTopAnchor(button10, 0.0);
        button10.setLayoutX(8.0);
        button10.setLayoutY(8.0);
        button10.setMnemonicParsing(false);
        button10.setPrefHeight(50.0);
        button10.setPrefWidth(150.0);
        button10.setStyle("-fx-background-color: #000000; -fx-font-size: 18; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 6);");
        button10.setText("<< Previous");
        button10.setTextFill(javafx.scene.paint.Color.WHITE);
        button10.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(flagAutoplay==0){
                try {
                    int boardCell=result.getInt(1);
                    System.out.println("previous "+boardCell);
                   if(flagImage=='x'){
                   
                     board[boardCell-1].setGraphic(null); 
                     
                     result.previous();
                     flagImage='O';
                        
                    }else{
                     board[boardCell-1].setGraphic(null);  
                     System.out.println("previous "+boardCell+" "+flagImage);
                     result.previous();
                     flagImage='x';
                    }
                    
                } catch (SQLException ex) {
                    System.out.println("There is no Previous Moves Please Press Next");
                    
                } 
            }
            }
        });

        AnchorPane.setLeftAnchor(button11, 550.0);
        AnchorPane.setRightAnchor(button11, 0.0);
        AnchorPane.setTopAnchor(button11, 0.0);
        button11.setLayoutX(550.0);
        button11.setLayoutY(8.0);
        button11.setMnemonicParsing(false);
        button11.setPrefHeight(50.0);
        button11.setPrefWidth(150.0);
        button11.setStyle("-fx-background-color: #000000; -fx-font-size: 18; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 6);");
        button11.setText("Next >>");
        button11.setTextFill(javafx.scene.paint.Color.WHITE);
        button11.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
             if(flagAutoplay==0){
                try {
                    if(result.next()){
                    int boardCell=result.getInt(1);
                    System.out.println(boardCell);
                    if(flagImage=='x'){
                     ImageView  imgView = new ImageView(imageX);
                     imgView.setFitWidth(150);
                     imgView.setPreserveRatio(true);
                     board[boardCell-1].setGraphic(imgView); 
                        System.out.println("next "+boardCell+" "+flagImage);
                     flagImage='O';
                        
                    }else{
                           ImageView  imgView = new ImageView(imageO);
                     imgView.setFitWidth(150);
                     imgView.setPreserveRatio(true);
                     board[boardCell-1].setGraphic(imgView); 
                     System.out.println("next "+boardCell+" "+flagImage);
                     flagImage='x';
                    }
                    }else{
                        result.previous();
                        
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                
            }
            }
        });
        label.setLayoutX(200.0);
        label.setLayoutY(7.0);
        label.setPrefHeight(87.0);
        label.setPrefWidth(350.0);
        label.setText(Status);
        label.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label.setTextFill(javafx.scene.paint.Color.valueOf("#e80909"));
        label.setFont(new Font("Times New Roman Bold", 20.0));

        AnchorPane.setBottomAnchor(button12, 20.0);
        AnchorPane.setLeftAnchor(button12, 255.0);
        button12.setLayoutX(258.0);
        button12.setLayoutY(636.0);
        button12.setMnemonicParsing(false);
        button12.setPrefHeight(50.0);
        button12.setPrefWidth(200.0);
        button12.setStyle("-fx-background-color: #F33250; -fx-font-size: 18; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 6);");
        button12.setText("Autoplay");
        button12.setTextFill(javafx.scene.paint.Color.WHITE);
        button12.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                flagAutoplay=1;
               MyThread th =new MyThread();
               th.start();
            }
        });

        getChildren().add(button);
        getChildren().add(button0);
        getChildren().add(listView);
        getChildren().add(button1);
        getChildren().add(button2);
        getChildren().add(button3);
        getChildren().add(button4);
        getChildren().add(button5);
        getChildren().add(button6);
        getChildren().add(button7);
        getChildren().add(button8);
        getChildren().add(button9);
        getChildren().add(button10);
        getChildren().add(button11);
        getChildren().add(label);
        getChildren().add(button12);

    }
}
