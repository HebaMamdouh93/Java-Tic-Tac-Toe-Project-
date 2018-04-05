package network;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import network.sqlDB;
import network.xo_scene_networkPlayingBase;
import static network.WonBase.gameStatus;
import static network.WonBase.gameType;
/**
 * 
 *  @author Aya Diaa Heba Monica
 *  The scene is displayed when a player loses
 */
public  class Lose extends AnchorPane {

    protected final Button button;
    protected final Button button0;
    protected final ImageView imageView;
    protected final Label label;
    protected final Button button1;
     public static String gameType;
         private SimpleDateFormat sdf;
         private Timestamp gameTimeStampobj;
         private String gameTimeStamp;
         private String fname;
         public static String gameStatus;
         private String sname;
         private int fplayerID;
         private int splayerID;
         private int gameID;
         boolean flag_save=false;

    public Lose(Stage stage,String name,int flag) {
        MediaPlayer player = new MediaPlayer( new Media(getClass().getResource("lose.mp4").toExternalForm()));
        MediaView mediaView = new MediaView(player);
        mediaView.setFitHeight(476.0);
        mediaView.setFitWidth(678.0);
        mediaView.setLayoutX(12.0);
        mediaView.setLayoutY(111.0);
        mediaView.setPickOnBounds(true);
        mediaView.setPreserveRatio(true);

        button = new Button();
        button0 = new Button();
        imageView = new ImageView();
        label = new Label();
        button1 = new Button();

        setId("AnchorPane");
        setPrefHeight(700.0);
        setPrefWidth(700.0);
        setStyle("-fx-background-color: Linear-gradient(#0099CC,white,#0099CC);;");
        setOpaqueInsets(new Insets(0.0));

        AnchorPane.setBottomAnchor(button, 24.0);
        AnchorPane.setLeftAnchor(button, 14.0);
        button.setLayoutX(14.0);
        button.setLayoutY(626.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(50.0);
        button.setPrefWidth(200.0);
        button.setStyle("-fx-background-color: #F33250; -fx-font-size: 18; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 10, 6);");
        button.setText("Back");
        button.setTextFill(javafx.scene.paint.Color.WHITE);
 button.setOnAction(new EventHandler<ActionEvent>(){
     @Override
     public void handle(ActionEvent event) {
                switch(flag)
         {
                
        case  2:             
//       Scene s4;
//                try {
//                    s4 = new Scene(new computerfinalBase(stage), 700, 700);
//                    stage.setScene(s4);
//                } catch (SQLException ex) {
//                    ex.printStackTrace();
//                } catch (ClassNotFoundException ex) {
//                    ex.printStackTrace();
//                }
//                                                              
//        player.stop();
        break; 
        
        case 3:
           /* Scene s5;
            try {
                    s5 = new Scene(new xo_scene_networkPlayingBase(stage), 700, 700);
                    stage.setScene(s5);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            break;*/
        
           }
        }
        });
      
        AnchorPane.setBottomAnchor(button0, 24.0);
        AnchorPane.setRightAnchor(button0, 14.0);
        button0.setLayoutX(487.0);
        button0.setLayoutY(626.0);
        button0.setMnemonicParsing(false);
        button0.setPrefHeight(50.0);
        button0.setPrefWidth(200.0);
        button0.setStyle("-fx-background-color: #F33250; -fx-font-size: 18; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 10, 6);");
        button0.setText("Home");
        button0.setTextFill(javafx.scene.paint.Color.WHITE);
        button0.setOnAction(new EventHandler<ActionEvent>(){
     @Override
     public void handle(ActionEvent event) {
       /***
        * on pressing home the game switches to the first scene 
        **/  
        
        Scene s = new Scene(new FXMLTicTacToe(stage), 700, 700);
        stage.setScene(s);
         player.stop();
      
     }
            
        }
        );




        label.setLayoutX(289.0);
        label.setLayoutY(14.0);
        label.setPrefHeight(87.0);
        label.setPrefWidth(218.0);
        label.setText(name + " " +"Lost");
        label.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label.setTextFill(javafx.scene.paint.Color.valueOf("#e80909"));
        label.setFont(new Font("Times New Roman Bold", 30.0));

        AnchorPane.setLeftAnchor(button1, 0.0);
        AnchorPane.setRightAnchor(button1, 550.0);
        AnchorPane.setTopAnchor(button1, 0.0);
        button1.setLayoutX(580.0);
        button1.setLayoutY(28.0);
        button1.setMnemonicParsing(false);
        button1.setPrefHeight(50.0);
        button1.setPrefWidth(150.0);
        button1.setStyle("-fx-background-color: #000000; -fx-font-size: 18; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 6);");
        button1.setText("Save");
        button1.setTextFill(javafx.scene.paint.Color.WHITE);
         button1.setOnAction(new EventHandler<ActionEvent>(){
     @Override
     public void handle(ActionEvent event) {
         /***
          * On saving the game , an event handler is called and data is saved to enter database
          * the flag is 1 for 2 players on same computer
          * the flag is 2 for game against computer
          * the flag is 3 for 2 players on a network
          * 
          */
         if(!flag_save)
         {
         ArrayList<Integer> Moves = null;
         
       
          switch(flag)
          {
            /*  case 1:
                  gameStatus="lose";
                  gameType="local";
                  Moves=xo_scene_localPlayingBase.Moves;
               break;
               
                 case 2: 
                     gameStatus="lose";
                  gameType="computer";
                  Moves=computerfinalBase.stepsplayer;     
                break; */
       
                 case 3:
                     
                  gameStatus="lose";
                  gameType="play over Network";
                  Moves=xo_scene_networkPlayingBase.cells;
               break;
       
       
         }
           try {
             sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
             gameTimeStampobj=new Timestamp(System.currentTimeMillis());
             gameTimeStamp=(sdf.format(gameTimeStampobj)).toString();
             fname=playersOfGame.getFirstPlayer();
             sqlDB.addUserDB(fname);
             sname=playersOfGame.getSecondPlayer();
             sqlDB.addUserDB(sname);
             fplayerID=sqlDB.getplayerID(fname);
             splayerID=sqlDB.getplayerID(sname);
            
             
             sqlDB.addGameDB(fplayerID, splayerID, gameTimeStamp,gameStatus,gameType);
             gameID=sqlDB.getgameID(gameTimeStamp);
            
             for (int jj=0;jj<Moves.size() ;jj++)
             {
                 if(Moves.get(jj)!=0)
                 {
                     sqlDB.addmoveDB(fplayerID, gameID,Moves.get(jj));
                 }
              }
                        System.out.println("game saved successfully");
                        flag_save=true;
                      
                        
                    }
       catch(SQLException ex)
                 {
                    ex.printStackTrace();
                 }
         catch(ClassNotFoundException e)
         {
             e.printStackTrace();
         }
        
        
     }
     }
     });
        
        
        stage.show();
        player.play();
        getChildren().add(mediaView);
        getChildren().add(button);
        getChildren().add(button0);
        getChildren().add(imageView);
        getChildren().add(label);
        getChildren().add(button1);

    }
}
 
