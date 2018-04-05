package tic_tac_toe;

import tic_tac_toe.Position;
import java.lang.*;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import sun.plugin2.os.windows.Windows;
import java.lang.Object.*;
import java.sql.SQLException;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import tic_tac_toe.Network.sqlDB;


public  class computerfinalBase extends AnchorPane  {

    protected final Button button;
    protected final Label label;
    protected final Label label0;
    protected final Button button0;
    protected final ListView listView;
    protected final MenuButton menuButton;
    //protected final MenuItem menuItem;
    protected final Label label1;
    protected final Label label2;
    protected final Button button1;
    protected final Button button2;
    protected final Button button3;
    protected final Button button4;
    protected final Button button5;
    protected final Button button6;
    protected final Button button7;
    protected final Button button8;
    protected final Button button9;
    String[] history;
    int fplayerID;
    final int indx_b1=0; //position for the button
    final int indx_b2=1;//position for the button
    final int indx_b3=2;//position for the button
    final int indx_b4=3;//position for the button
    final int indx_b5=4;//position for the button
    final int indx_b6=5;//position for the button
    final int indx_b7=6;//position for the buttons
    final int indx_b8=7;//position for the button
    final int indx_b9=8;//position for the button
 public  static String  status; // status the game
   public Button[] arrayButtons=new Button[10]  ;
   /***
    * list have all steps move for the game
    */
   public static ArrayList <Integer> stepsplayer=new ArrayList<>(); 
   public static int  won;
   public static String  GameType="one player";
       
  
     Position position=new Position(); // this object have all methods that i will use it 
    public computerfinalBase(Stage stage) throws SQLException, ClassNotFoundException {
stepsplayer.clear();
        button = new Button();
        label = new Label();
        label0 = new Label();
        button0 = new Button();
        listView = new ListView();
        menuButton = new MenuButton();
     
        label1 = new Label();
        label2 = new Label();
        button1 = new Button();
        button2 = new Button();
        button3 = new Button();
        button4 = new Button();
        button5 = new Button();
        button6 = new Button();
        button7 = new Button();
        button8 = new Button();
        button9 = new Button();
        arrayButtons[0]=button1;
arrayButtons[1]=button2;
arrayButtons[2]=button3;
arrayButtons[3]=button4;
arrayButtons[4]=button5;
arrayButtons[5]=button6;
arrayButtons[6]=button7;
arrayButtons[7]=button8;
arrayButtons[8]=button9;

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

        AnchorPane.setBottomAnchor(label, 614.0);
        AnchorPane.setLeftAnchor(label, 31.0);
        AnchorPane.setRightAnchor(label, 557.0);
        AnchorPane.setTopAnchor(label, 55.0);
        label.setLayoutX(31.0);
        label.setLayoutY(55.0);
        label.setPrefHeight(31.0);
        label.setPrefWidth(112.0);
        label.setText(playersOfGame.getFirstPlayer());
        label.setFont(new Font("Calibri Bold Italic", 27.0));

        AnchorPane.setBottomAnchor(label0, 614.0);
        AnchorPane.setLeftAnchor(label0, 393.0);
        AnchorPane.setRightAnchor(label0, 147.0);
        AnchorPane.setTopAnchor(label0, 55.0);
        label0.setLayoutX(393.0);
        label0.setLayoutY(55.0);
        label0.setPrefHeight(31.0);
        label0.setPrefWidth(160.0);
        label0.setText("Computer (O )");
        label0.setTextAlignment(javafx.scene.text.TextAlignment.RIGHT);
        label0.setWrapText(true);
        label0.setFont(new Font("Calibri Bold Italic", 27.0));

        AnchorPane.setBottomAnchor(button0, 20.0);
        button0.setLayoutX(31.0);
        button0.setLayoutY(625.0);
        button0.setMnemonicParsing(false);
        button0.setPrefHeight(50.0);
        button0.setPrefWidth(200.0);
        button0.setStyle("-fx-background-color: #F33250; -fx-font-size: 18; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 10, 6);");
        button0.setText("Reset");
        button0.setTextFill(javafx.scene.paint.Color.WHITE);

        listView.setEditable(true);
        listView.setLayoutX(191.0);
        listView.setLayoutY(160.0);
        listView.setPrefHeight(200.0);
        listView.setPrefWidth(455.0);
        listView.setStyle("-fx-background-color: transparent;");

        AnchorPane.setLeftAnchor(menuButton, 474.0);
        AnchorPane.setRightAnchor(menuButton, 0.0);
        AnchorPane.setTopAnchor(menuButton, 0.0);
        menuButton.setLayoutX(474.0);
        menuButton.setLayoutY(7.0);
        menuButton.setMnemonicParsing(false);
        menuButton.setPrefHeight(44.0);
        menuButton.setPrefWidth(226.0);
        menuButton.setStyle("-fx-background-color: #333333;");
        menuButton.setText("Saved History");
        menuButton.setTextFill(javafx.scene.paint.Color.valueOf("#f33250"));

        //menuItem.setMnemonicParsing(false);
        menuButton.setFont(new Font("Calibri", 24.0));
         
        
        //History 
        fplayerID=sqlDB.getplayerID(playersOfGame.getFirstPlayer());
        history = sqlDB.getHistory(fplayerID);
        MenuItem[] menu=new MenuItem[history.length];
        for(int i=0;i<history.length;i++){
    
        menu[i] = new MenuItem(history[i]);
        menuButton.getItems().add(menu[i]);
        menu[i].setOnAction(new EventHandler<ActionEvent>() {
              
            @Override
            public void handle(ActionEvent event) {
                MenuItem m=(MenuItem) event.getSource();
                String status=m.getText();
                System.out.println(status);
                String[] splitedStatus=status.split("  ");
                String time=splitedStatus[1];
               
                try {
                         int gameid=sqlDB.getgameID(time);
                         Scene s = new Scene(new recallBase(stage ,status,fplayerID,gameid,2), 700, 700);
                         stage.setScene(s);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
        
            }
        });
        }
        
        
        AnchorPane.setBottomAnchor(label1, 614.0);
        AnchorPane.setLeftAnchor(label1, 143.0);
        AnchorPane.setRightAnchor(label1, 445.0);
        label1.setLayoutX(143.0);
        label1.setLayoutY(53.0);
        label1.setText("0");
        label1.setTextFill(javafx.scene.paint.Color.WHITE);
        label1.setFont(new Font("System Bold Italic", 24.0));

        AnchorPane.setBottomAnchor(label2, 614.0);
        AnchorPane.setLeftAnchor(label2, 564.0);
        AnchorPane.setRightAnchor(label2, 41.0);
        label2.setLayoutX(564.0);
        label2.setLayoutY(53.0);
        label2.setPrefHeight(35.0);
        label2.setPrefWidth(95.0);
        label2.setText("0");
        label2.setTextFill(javafx.scene.paint.Color.WHITE);
        label2.setFont(new Font("System Bold Italic", 24.0));

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

        getChildren().add(button);
        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(button0);
        getChildren().add(listView);
        //menuButton.getItems().add(menuItem);
        getChildren().add(menuButton);
        getChildren().add(label1);
        getChildren().add(label2);
        getChildren().add(button1);
        getChildren().add(button2);
        getChildren().add(button3);
        getChildren().add(button4);
        getChildren().add(button5);
        getChildren().add(button6);
        getChildren().add(button7);
        getChildren().add(button8);
        getChildren().add(button9);
        
        button.setOnAction(new EventHandler<ActionEvent>(){
             public void handle(ActionEvent event) {
         
     Scene s = new Scene(new FXMLTicTacToe(stage), 700, 700); //home button
  
    stage.setScene(s);


      
    
       
             }   
        });
                

  button0.setOnAction(new EventHandler<ActionEvent>(){
             public void handle(ActionEvent event) {
         
     Scene s;
                 try {
                     s = new Scene(new computerfinalBase(stage), 700, 700); // reset button
                     stage.setScene(s);
                 } catch (SQLException ex) {
                     ex.printStackTrace();
                 } catch (ClassNotFoundException ex) {
                     ex.printStackTrace();
                 }
    
       
             }   
        });
             
        
      
        button1.setOnAction(new EventHandler<ActionEvent>(){
     @Override
     public void handle(ActionEvent event) {
         /***
          * check if the position of this board empty so i can play on it this position
          */
         if(position.board[indx_b1]==' ') //
         {
     
         if(!position.isGameEnd()) 
         {
             
             /***
              * check if the position of this board empty so i can play on it this position
              * **/
         if(position.turn=='x') 
         {
                      
  Image img = new Image(getClass().getResourceAsStream("x.png"));
                   ImageView  imgView = new ImageView(img);
                   imgView.setFitWidth(150);
                  imgView.setPreserveRatio(true);
                 button1.setGraphic(imgView);
         }
         else
         {
               Image img = new Image(getClass().getResourceAsStream("O.png"));
                   ImageView  imgView = new ImageView(img);
                   imgView.setFitWidth(150);
                  imgView.setPreserveRatio(true);
                 button1.setGraphic(imgView);
         }
         
                 position.move(indx_b1);  /***play in this position*/ 
                stepsplayer.add(indx_b1+1); /*save this step to can insert it into data base*/
                 
             
             
             
             
              }
         
             if(!position.isGameEnd()) 
             {
             /***
              * // check again if the game not end to can computer play his move 
              */
             int best=position.bestMove(); // method return the position of move 
             
                    if(position.turn=='x')
         {
                      
  Image img = new Image(getClass().getResourceAsStream("x.png"));
                   ImageView  imgView = new ImageView(img);
                   imgView.setFitWidth(150);
                  imgView.setPreserveRatio(true);
                arrayButtons[best].setGraphic(imgView);
         }
         else
         {
               Image img = new Image(getClass().getResourceAsStream("O.png"));
                   ImageView  imgView = new ImageView(img);
                   imgView.setFitWidth(150);
                  imgView.setPreserveRatio(true);
                 arrayButtons[best].setGraphic(imgView);
         }
                    
                  position.move(best);  //play the bestmove for computer
                     stepsplayer.add(best+1); //save this step to can insert it into data base
           
             
             }

        
         

     if(position.isGameEnd()) // if the game end 
         {
              status=playersOfGame.getFirstPlayer();
             if(position.isWinFor('x'))
             {
              won=1;
               status=playersOfGame.getFirstPlayer();
                label2.setText("1");
                //label2.setText("1");
     Scene s = new Scene(new WonBase(stage,status,2), 700, 700);  
     Timeline timeline = new Timeline(new KeyFrame(
        Duration.millis(1000),
        ae -> stage.setScene(s)));
              timeline.play();  
             }
             else if(position.isWinFor('o'))
             {
                 
                    
      Scene s = new Scene(new Lose(stage,status,2), 700, 700);
   
     Timeline timeline = new Timeline(new KeyFrame(
        Duration.millis(1000),
        ae -> stage.setScene(s)));
     timeline.play();
   
     
             }
             else
             {
                
                      status="draw";
                     
       Scene s = new Scene(new drawBase(stage,2), 700, 700);
   
     Timeline timeline = new Timeline(new KeyFrame(
        Duration.millis(1000),
        ae -> stage.setScene(s)));
     timeline.play();
   
      
      
     
             }
    
         }

     }
     }
          }
        );
        
 
        button2.setOnAction(new EventHandler<ActionEvent>(){
     @Override
     public void handle(ActionEvent event) {
         if(position.board[indx_b2]==' ')
         {
     
         if(!position.isGameEnd())
         {
             
             
         if(position.turn=='x')
         {
                      
  Image img = new Image(getClass().getResourceAsStream("x.png"));
                   ImageView  imgView = new ImageView(img);
                   imgView.setFitWidth(150);
                  imgView.setPreserveRatio(true);
                 button2.setGraphic(imgView);
         }
         else
         {
               Image img = new Image(getClass().getResourceAsStream("O.png"));
                   ImageView  imgView = new ImageView(img);
                   imgView.setFitWidth(150);
                  imgView.setPreserveRatio(true);
                 button2.setGraphic(imgView);
         }
         
                 position.move(indx_b2);        
             stepsplayer.add(indx_b2+1);
             
              }
             
             
               if(!position.isGameEnd())
               {
             
             int best=position.bestMove();
             
                    if(position.turn=='x')
         {
                      
  Image img = new Image(getClass().getResourceAsStream("x.png"));
                   ImageView  imgView = new ImageView(img);
                   imgView.setFitWidth(150);
                  imgView.setPreserveRatio(true);
                arrayButtons[best].setGraphic(imgView);
         }
         else
         {
               Image img = new Image(getClass().getResourceAsStream("O.png"));
                   ImageView  imgView = new ImageView(img);
                   imgView.setFitWidth(150);
                  imgView.setPreserveRatio(true);
                 arrayButtons[best].setGraphic(imgView);
         }
                    
                  position.move(best);
           
                stepsplayer.add(best+1);
             
               }
        
         

             if(position.isGameEnd())
         {
               status=playersOfGame.getFirstPlayer();
             if(position.isWinFor('x'))
             {
               won=1;
            status=playersOfGame.getFirstPlayer();
                     Scene s = new Scene(new WonBase(stage,status,2), 700, 700);
           Timeline timeline = new Timeline(new KeyFrame(
        Duration.millis(1000),
        ae -> stage.setScene(s)));
           timeline.play();
   


    
                 
             }
             else if(position.isWinFor('o'))
             {
                 
                    
      Scene s = new Scene(new Lose(stage,status,2), 700, 700);
        Timeline timeline = new Timeline(new KeyFrame(
        Duration.millis(1000),
        ae -> stage.setScene(s)));
        timeline.play();
   
     
             }
             else
             {
                
                      status="draw";
             
       Scene s = new Scene(new drawBase(stage,2), 700, 700);
        Timeline timeline = new Timeline(new KeyFrame(
        Duration.millis(1000),
        ae -> stage.setScene(s)));
   timeline.play();
     
             }
             
         }

     }
     }
          }
        );
        
        
        
        
        
                button3.setOnAction(new EventHandler<ActionEvent>(){
     @Override
     public void handle(ActionEvent event) {
          if(position.board[indx_b3]==' ')
          {
      
         
         if(!position.isGameEnd())
         {
             
                if(position.turn=='x')
         {
                      
  Image img = new Image(getClass().getResourceAsStream("x.png"));
                   ImageView  imgView = new ImageView(img);
                   imgView.setFitWidth(150);
                  imgView.setPreserveRatio(true);
                 button3.setGraphic(imgView);
         }
         else
         {
               Image img = new Image(getClass().getResourceAsStream("O.png"));
                   ImageView  imgView = new ImageView(img);
                   imgView.setFitWidth(150);
                  imgView.setPreserveRatio(true);
                 button3.setGraphic(imgView);
         }
         
         
                 position.move(indx_b3);
                 stepsplayer.add(indx_b3+1);
         }
           if(!position.isGameEnd())
         {
         
             int best=position.bestMove();
             
                    if(position.turn=='x')
         {
                      
  Image img = new Image(getClass().getResourceAsStream("x.png"));
                   ImageView  imgView = new ImageView(img);
                   imgView.setFitWidth(150);
                  imgView.setPreserveRatio(true);
                arrayButtons[best].setGraphic(imgView);
         }
         else
         {
               Image img = new Image(getClass().getResourceAsStream("O.png"));
                   ImageView  imgView = new ImageView(img);
                   imgView.setFitWidth(150);
                  imgView.setPreserveRatio(true);
                 arrayButtons[best].setGraphic(imgView);
         }
             
         position.move(best);
           stepsplayer.add(best+1);
             
         }
         
         

         
               if(position.isGameEnd())
         {
               status=playersOfGame.getFirstPlayer();
             if(position.isWinFor('x'))
             {
             won=1;
                status=playersOfGame.getFirstPlayer();
                     Scene s = new Scene(new WonBase(stage,status,2), 700, 700);
        Timeline timeline = new Timeline(new KeyFrame(
        Duration.millis(1000),
        ae -> stage.setScene(s)));
   timeline.play();


    
                 
             }
             else if(position.isWinFor('o'))
             {
               
                    
      Scene s = new Scene(new Lose(stage,status,2), 700, 700);
      Timeline timeline = new Timeline(new KeyFrame(
        Duration.millis(1000),
        ae -> stage.setScene(s)));
   timeline.play();
     
             }
             else
             {
                
                      status="draw";
                     
       Scene s = new Scene(new drawBase(stage,2), 700, 700);
          Timeline timeline = new Timeline(new KeyFrame(
        Duration.millis(1000),
        ae -> stage.setScene(s)));
   timeline.play();
     
             }
       
         }

     }
     }
          }
        );
        
                button4.setOnAction(new EventHandler<ActionEvent>(){
     @Override
     public void handle(ActionEvent event) {
          if(position.board[indx_b4]==' ')
          {

         
         
         if(!position.isGameEnd())
         {
                     if(position.turn=='x')
         {
          
                      
  Image img = new Image(getClass().getResourceAsStream("x.png"));
                   ImageView  imgView = new ImageView(img);
                   imgView.setFitWidth(150);
                  imgView.setPreserveRatio(true);
                 button4.setGraphic(imgView);
         }
         else
         {
               Image img = new Image(getClass().getResourceAsStream("O.png"));
                   ImageView  imgView = new ImageView(img);
                   imgView.setFitWidth(150);
                  imgView.setPreserveRatio(true);
                 button4.setGraphic(imgView);
         }
         
                 position.move(indx_b4); 
                  stepsplayer.add(indx_b4+1);
         }
          if(!position.isGameEnd())
         {
             
             
             int best=position.bestMove();
             
                    if(position.turn=='x')
         {
                      
  Image img = new Image(getClass().getResourceAsStream("x.png"));
                   ImageView  imgView = new ImageView(img);
                   imgView.setFitWidth(150);
                  imgView.setPreserveRatio(true);
                arrayButtons[best].setGraphic(imgView);
                
         }
         else
         {
               Image img = new Image(getClass().getResourceAsStream("O.png"));
                   ImageView  imgView = new ImageView(img);
                   imgView.setFitWidth(150);
                  imgView.setPreserveRatio(true);
                 arrayButtons[best].setGraphic(imgView);
                   
         }
             
         position.move(best);
         stepsplayer.add(best+1);

             
         }
    if(position.isGameEnd())
         {
               status=playersOfGame.getFirstPlayer();
             
             if(position.isWinFor('x'))
             {
               won=1;
               status=playersOfGame.getFirstPlayer();
                
                     Scene s = new Scene(new WonBase(stage,status,2), 700, 700);
         Timeline timeline = new Timeline(new KeyFrame(
        Duration.millis(1000),
        ae -> stage.setScene(s)));
   

timeline.play();
    
                 
             }
             else if(position.isWinFor('o'))
             {
                
                    
      Scene s = new Scene(new Lose(stage,status,2), 700, 700);
           Timeline timeline = new Timeline(new KeyFrame(
        Duration.millis(1000),
        ae -> stage.setScene(s)));
   
     timeline.play();
             }
             else
             {
                
                      status="draw";
                     
       Scene s = new Scene(new drawBase(stage,2), 700, 700);
          Timeline timeline = new Timeline(new KeyFrame(
        Duration.millis(1000),
        ae -> stage.setScene(s)));
   
     timeline.play();
             }
   
         }
         

     }
     }
          }
        );
        
        
        
                button5.setOnAction(new EventHandler<ActionEvent>(){
     @Override
     public void handle(ActionEvent event) {
          if(position.board[indx_b5]==' ')
    
          {
         
         if(!position.isGameEnd())
         {
                   
         if(position.turn=='x')
         {
                      
  Image img = new Image(getClass().getResourceAsStream("x.png"));
                   ImageView  imgView = new ImageView(img);
                   imgView.setFitWidth(150);
                  imgView.setPreserveRatio(true);
                 button5.setGraphic(imgView);
         }
         else
         {
               Image img = new Image(getClass().getResourceAsStream("O.png"));
                   ImageView  imgView = new ImageView(img);
                   imgView.setFitWidth(150);
                  imgView.setPreserveRatio(true);
                 button5.setGraphic(imgView);
         }
         
                 position.move(indx_b5);
                  stepsplayer.add(indx_b5+1);
                   }
          if(!position.isGameEnd())
         {
             int best=position.bestMove();
             
                    if(position.turn=='x')
         {
                      
  Image img = new Image(getClass().getResourceAsStream("x.png"));
                   ImageView  imgView = new ImageView(img);
                   imgView.setFitWidth(150);
                  imgView.setPreserveRatio(true);
                arrayButtons[best].setGraphic(imgView);
         }
         else
         {
               Image img = new Image(getClass().getResourceAsStream("O.png"));
                   ImageView  imgView = new ImageView(img);
                   imgView.setFitWidth(150);
                  imgView.setPreserveRatio(true);
                 arrayButtons[best].setGraphic(imgView);
         }
             
             
         position.move(best);
          stepsplayer.add(best+1);

         }
         
         
  
     if(position.isGameEnd())
         {
               status=playersOfGame.getFirstPlayer();
             if(position.isWinFor('x'))
             {
               won=1;
               status=playersOfGame.getFirstPlayer();
                     Scene s = new Scene(new WonBase(stage,status,2), 700, 700);
      Timeline timeline = new Timeline(new KeyFrame(
        Duration.millis(1000),
        ae -> stage.setScene(s)));
   
timeline.play();

    
                 
             }
             else if(position.isWinFor('o'))
             {
                
                    
      Scene s = new Scene(new Lose(stage,status,2), 700, 700);
        Timeline timeline = new Timeline(new KeyFrame(
        Duration.millis(1000),
        ae -> stage.setScene(s)));
   timeline.play();
     
             }
             else
             {
                
                      status="draw";
                     
       Scene s = new Scene(new drawBase(stage,2), 700, 700);
           Timeline timeline = new Timeline(new KeyFrame(
        Duration.millis(1000),
        ae -> stage.setScene(s)));
   
     timeline.play();
             }
           
              
             
                     

             
         }
          }
     
     }
          }
        );
        
                      button6.setOnAction(new EventHandler<ActionEvent>(){
     @Override
     public void handle(ActionEvent event) {

          if(position.board[indx_b6]==' ')
          {
   
         
         if(!position.isGameEnd())
         {
             
                   if(position.turn=='x')
         {
                      
  Image img = new Image(getClass().getResourceAsStream("x.png"));
                   ImageView  imgView = new ImageView(img);
                   imgView.setFitWidth(150);
                  imgView.setPreserveRatio(true);
                 button6.setGraphic(imgView);
         }
         else
         {
               Image img = new Image(getClass().getResourceAsStream("O.png"));
                   ImageView  imgView = new ImageView(img);
                   imgView.setFitWidth(150);
                  imgView.setPreserveRatio(true);
                 button6.setGraphic(imgView);
         }
                 position.move(indx_b6);
                   stepsplayer.add(indx_b6+1);
                 
         }
          if(!position.isGameEnd())
         {
             int best=position.bestMove();
             
                    if(position.turn=='x')
         {
                      
  Image img = new Image(getClass().getResourceAsStream("x.png"));
                   ImageView  imgView = new ImageView(img);
                   imgView.setFitWidth(150);
                  imgView.setPreserveRatio(true);
                arrayButtons[best].setGraphic(imgView);
         }
         else
         {
               Image img = new Image(getClass().getResourceAsStream("O.png"));
                   ImageView  imgView = new ImageView(img);
                   imgView.setFitWidth(150);
                  imgView.setPreserveRatio(true);
                 arrayButtons[best].setGraphic(imgView);
         }
         position.move(best);
        stepsplayer.add(best+1);
             
             

         }

         
         
    if(position.isGameEnd())
         {
               status=playersOfGame.getFirstPlayer();
             if(position.isWinFor('x'))
             {
               won=1;
               status=playersOfGame.getFirstPlayer();
                     Scene s = new Scene(new WonBase(stage,status,2), 700, 700);
          Timeline timeline = new Timeline(new KeyFrame(
        Duration.millis(1000),
        ae -> stage.setScene(s)));
         timeline.play();


    
                 
             }
             else if(position.isWinFor('o'))
             {
                 
                    
      Scene s = new Scene(new Lose(stage,status,2), 700, 700);
       Timeline timeline = new Timeline(new KeyFrame(
        Duration.millis(1000),
        ae -> stage.setScene(s)));
     timeline.play();
             }
             else
             {
                
                      status="draw";
                     
       Scene s = new Scene(new drawBase(stage,2), 700, 700);
          Timeline timeline = new Timeline(new KeyFrame(
        Duration.millis(1000),
        ae -> stage.setScene(s)));
     timeline.play();
             }
         

             
         }
     }
     }
          }
        );
        
        
        
        
                     button6.setOnAction(new EventHandler<ActionEvent>(){
     @Override
     public void handle(ActionEvent event) {
          if(position.board[indx_b6]==' '){
         
         
         if(!position.isGameEnd())
         {
            
             if(position.turn=='x')
         {
                      
  Image img = new Image(getClass().getResourceAsStream("x.png"));
                   ImageView  imgView = new ImageView(img);
                   imgView.setFitWidth(150);
                  imgView.setPreserveRatio(true);
                 button6.setGraphic(imgView);
         }
         else
         {
               Image img = new Image(getClass().getResourceAsStream("O.png"));
                   ImageView  imgView = new ImageView(img);
                   imgView.setFitWidth(150);
                  imgView.setPreserveRatio(true);
                 button6.setGraphic(imgView);
         }
                 position.move(indx_b6);
                  stepsplayer.add(indx_b6+1);
         }
          if(!position.isGameEnd())
         {
         
             int best=position.bestMove();
             
                    if(position.turn=='x')
         {
                      
  Image img = new Image(getClass().getResourceAsStream("x.png"));
                   ImageView  imgView = new ImageView(img);
                   imgView.setFitWidth(150);
                  imgView.setPreserveRatio(true);
                arrayButtons[best].setGraphic(imgView);
         }
         else
         {
               Image img = new Image(getClass().getResourceAsStream("O.png"));
                   ImageView  imgView = new ImageView(img);
                   imgView.setFitWidth(150);
                  imgView.setPreserveRatio(true);
                 arrayButtons[best].setGraphic(imgView);
         }
             
         position.move(best);
          stepsplayer.add(best+1);
             

         }
         
   
         
    if(position.isGameEnd())
         {
               status=playersOfGame.getFirstPlayer();
             
             if(position.isWinFor('x'))
             {
               won=1;
               status=playersOfGame.getFirstPlayer();
                     Scene s = new Scene(new WonBase(stage,status,2), 700, 700);
           Timeline timeline = new Timeline(new KeyFrame(
        Duration.millis(1000),
        ae -> stage.setScene(s)));
timeline.play();

    
                 
             }
             else if(position.isWinFor('o'))
             {
             
                    
      Scene s = new Scene(new Lose(stage,status,2), 700, 700);
          Timeline timeline = new Timeline(new KeyFrame(
        Duration.millis(1000),
        ae -> stage.setScene(s)));
     timeline.play();
             }
             else
             {
                
                      status="draw";
                     
       Scene s = new Scene(new drawBase(stage,2), 700, 700);
           Timeline timeline = new Timeline(new KeyFrame(
        Duration.millis(1000),
        ae -> stage.setScene(s)));
     timeline.play();
             }
           
              
             
                     

             
         }
     }
          
     }
          }
        );
        
        
        
        
                     button7.setOnAction(new EventHandler<ActionEvent>(){
     @Override
     public void handle(ActionEvent event) {
          if(position.board[indx_b7]==' '){
         
         
         if(!position.isGameEnd())
         {
            
             if(position.turn=='x')
         {
                      
  Image img = new Image(getClass().getResourceAsStream("x.png"));
                   ImageView  imgView = new ImageView(img);
                   imgView.setFitWidth(150);
                  imgView.setPreserveRatio(true);
                 button7.setGraphic(imgView);
         }
         else
         {
               Image img = new Image(getClass().getResourceAsStream("O.png"));
                   ImageView  imgView = new ImageView(img);
                   imgView.setFitWidth(150);
                  imgView.setPreserveRatio(true);
                 button7.setGraphic(imgView);
         }
                 position.move(indx_b7);
                 stepsplayer.add(indx_b7+1);
         }
          if(!position.isGameEnd())
         {
         
             int best=position.bestMove();
             
                    if(position.turn=='x')
         {
                      
  Image img = new Image(getClass().getResourceAsStream("x.png"));
                   ImageView  imgView = new ImageView(img);
                   imgView.setFitWidth(150);
                  imgView.setPreserveRatio(true);
                arrayButtons[best].setGraphic(imgView);
         }
         else
         {
               Image img = new Image(getClass().getResourceAsStream("O.png"));
                   ImageView  imgView = new ImageView(img);
                   imgView.setFitWidth(150);
                  imgView.setPreserveRatio(true);
                 arrayButtons[best].setGraphic(imgView);
         }
             
         position.move(best);
            stepsplayer.add(best+1);
             

         }
         
   
         
    if(position.isGameEnd())
         {
              status=playersOfGame.getFirstPlayer();
             if(position.isWinFor('x'))
             {
               won=1;
                status=playersOfGame.getFirstPlayer();
                     Scene s = new Scene(new WonBase(stage,status,2), 700, 700);
       Timeline timeline = new Timeline(new KeyFrame(
        Duration.millis(1000),
        ae -> stage.setScene(s)));
timeline.play();

    
                 
             }
             else if(position.isWinFor('o'))
             {
               
                    
      Scene s = new Scene(new Lose(stage,status,2), 700, 700);
         Timeline timeline = new Timeline(new KeyFrame(
        Duration.millis(1000),
        ae -> stage.setScene(s)));
     timeline.play();
             }
             else
             {
                
                       Scene s = new Scene(new drawBase(stage,2), 700, 700);
                        Timeline timeline = new Timeline(new KeyFrame(
        Duration.millis(1000),
        ae -> stage.setScene(s)));
                     
  
    timeline.play();
     
             }
  
             
         }
     }
          
     }
          }
        );
        
             
                button8.setOnAction(new EventHandler<ActionEvent>(){
     @Override
     public void handle(ActionEvent event) {
          if(position.board[indx_b8]==' '){
         
         
         
         if(!position.isGameEnd())
         {
             if(position.turn=='x')
         {
                      
  Image img = new Image(getClass().getResourceAsStream("x.png"));
                   ImageView  imgView = new ImageView(img);
                   imgView.setFitWidth(150);
                  imgView.setPreserveRatio(true);
                 button8.setGraphic(imgView);
         }
         else
         {
               Image img = new Image(getClass().getResourceAsStream("O.png"));
                   ImageView  imgView = new ImageView(img);
                   imgView.setFitWidth(150);
                  imgView.setPreserveRatio(true);
                 button8.setGraphic(imgView);
         }
         
                 position.move(indx_b8);
                  stepsplayer.add(indx_b8+1);
         }
         
          if(!position.isGameEnd())
         {
             int best=position.bestMove();
             
                    if(position.turn=='x')
         {
                      
  Image img = new Image(getClass().getResourceAsStream("x.png"));
                   ImageView  imgView = new ImageView(img);
                   imgView.setFitWidth(150);
                  imgView.setPreserveRatio(true);
                arrayButtons[best].setGraphic(imgView);
         }
         else
         {
               Image img = new Image(getClass().getResourceAsStream("O.png"));
                   ImageView  imgView = new ImageView(img);
                   imgView.setFitWidth(150);
                  imgView.setPreserveRatio(true);
                 arrayButtons[best].setGraphic(imgView);
         }
             
         position.move(best);
               stepsplayer.add(best+1);
             

         }
         
          

         
         
    if(position.isGameEnd())
         {
              status=playersOfGame.getFirstPlayer();
             if(position.isWinFor('x'))
             {
               won=1;
              status=playersOfGame.getFirstPlayer();
                     Scene s = new Scene(new WonBase(stage,status,2), 700, 700);
         Timeline timeline = new Timeline(new KeyFrame(
        Duration.millis(1000),
        ae -> stage.setScene(s)));

timeline.play();
    
                 
             }
             else if(position.isWinFor('o'))
             {
               
               
                    
      Scene s = new Scene(new Lose(stage,status,2), 700, 700);
       Timeline timeline = new Timeline(new KeyFrame(
        Duration.millis(1000),
        ae -> stage.setScene(s)));
     timeline.play();
             }
             else
             {
                
                      status="draw";
                     
       Scene s = new Scene(new drawBase(stage,2), 700, 700);
         Timeline timeline = new Timeline(new KeyFrame(
        Duration.millis(1000),
        ae -> stage.setScene(s)));
     timeline.play();
             }
           
              
             
                     

             
         }
     }
     }
          }
        );
        
       
                
                
                      button9.setOnAction(new EventHandler<ActionEvent>(){
     @Override
     public void handle(ActionEvent event) {
          if(position.board[indx_b9]==' ')
          {
         
         
         if(!position.isGameEnd())
         {
             if(position.turn=='x')
         {
                      
  Image img = new Image(getClass().getResourceAsStream("x.png"));
                   ImageView  imgView = new ImageView(img);
                   imgView.setFitWidth(150);
                  imgView.setPreserveRatio(true);
                 button9.setGraphic(imgView);
         }
         else
         {
               Image img = new Image(getClass().getResourceAsStream("O.png"));
                   ImageView  imgView = new ImageView(img);
                   imgView.setFitWidth(150);
                  imgView.setPreserveRatio(true);
                 button9.setGraphic(imgView);
         }
         
                 position.move(indx_b9);
                   stepsplayer.add(indx_b9+1);
         }
          if(!position.isGameEnd())
         {
         
             int best=position.bestMove();
             
                    if(position.turn=='x')
         {
                      
  Image img = new Image(getClass().getResourceAsStream("x.png"));
                   ImageView  imgView = new ImageView(img);
                   imgView.setFitWidth(150);
                  imgView.setPreserveRatio(true);
                arrayButtons[best].setGraphic(imgView);
         }
         else
         {
               Image img = new Image(getClass().getResourceAsStream("O.png"));
                   ImageView  imgView = new ImageView(img);
                   imgView.setFitWidth(150);
                  imgView.setPreserveRatio(true);
                 arrayButtons[best].setGraphic(imgView);
         }
             
         position.move(best);
          stepsplayer.add(best+1);
             
         }
         
         

      if(position.isGameEnd())
         {
               status=playersOfGame.getFirstPlayer();
            
             if(position.isWinFor('x'))
             {
                 won=1;
              label1.setText("1");
               status=playersOfGame.getFirstPlayer();
                
                     Scene s = new Scene(new WonBase(stage,status,2), 700, 700);
       Timeline timeline = new Timeline(new KeyFrame(
        Duration.millis(1000),
        ae -> stage.setScene(s)));
timeline.play();

    
                 
             }
             else if(position.isWinFor('o'))
             {
              
                    
      Scene s = new Scene(new Lose(stage,status,2), 700, 700);
         Timeline timeline = new Timeline(new KeyFrame(
        Duration.millis(1000),
        ae -> stage.setScene(s)));
     timeline.play();
             }
             else
             {
                
                      status="draw";
                     
       Scene s = new Scene(new drawBase(stage,2), 700, 700);
          Timeline timeline = new Timeline(new KeyFrame(
        Duration.millis(1000),
        ae -> stage.setScene(s)));
     timeline.play();
             }
 

             
         }
     }
     }
          }
        );
              
    }

  
}
