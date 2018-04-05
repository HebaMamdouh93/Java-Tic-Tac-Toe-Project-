package tic_tac_toe;

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
import javafx.scene.control.Alert;
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
import static tic_tac_toe.Lose.gameStatus;
import static tic_tac_toe.Lose.gameType;
import tic_tac_toe.Network.sqlDB;
import tic_tac_toe.Network.xo_scene_networkBase;
import tic_tac_toe.Network.xo_scene_networkPlayingBase;

public  class drawBase extends AnchorPane {
    
    

    protected final Button button;
    protected final Button button0;
    protected final Label label;
    protected final ImageView imageView;
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

public drawBase(Stage stage,int flag) {
    
      MediaPlayer player = new MediaPlayer( new Media(getClass().getResource("draw.mp4").toExternalForm()));
        MediaView mediaView = new MediaView(player);
        mediaView.setFitHeight(476.0);
        mediaView.setFitWidth(678.0);
        mediaView.setLayoutX(12.0);
        mediaView.setLayoutY(111.0);
        mediaView.setPickOnBounds(true);
        mediaView.setPreserveRatio(true);

        button = new Button();
        button0 = new Button();
        label = new Label();
        imageView = new ImageView();
        button1 = new Button();

        setId("AnchorPane");
        setPrefHeight(700.0);
        setPrefWidth(700.0);
        setStyle("-fx-background-color: Linear-gradient(#0099CC,white,#0099CC);");
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
             case 1:
         Scene s1;
            try {
                s1 = new Scene(new xo_scene_localPlayingBase(stage), 700, 700);
                stage.setScene(s1);
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        
        player.stop();
         break;
        
        case 2:
        Scene s2;                
            try {
                s2 = new Scene(new computerfinalBase(stage), 700, 700);
                stage.setScene(s2);
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        
        player.stop();
       
        break;
        
        case 3:
        
            try {
               
                Scene s3= new Scene(new xo_scene_networkBase(stage), 700, 700);
                   stage.setScene(s3);
               player.stop();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
     
        break;
        }  
     }   
        }
        );
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
         
        
        Scene s = new Scene(new FXMLTicTacToe(stage), 700, 700);
        stage.setScene(s);
      
     }
            
        }
        );

        label.setLayoutX(246.0);
        label.setLayoutY(24.0);
        label.setPrefHeight(87.0);
        label.setPrefWidth(153.0);
        label.setText("Draw");
        label.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label.setTextFill(javafx.scene.paint.Color.valueOf("#e80909"));
        label.setFont(new Font("Times New Roman Bold", 48.0));

   

        AnchorPane.setLeftAnchor(button1, 0.0);
        AnchorPane.setRightAnchor(button1, 570.0);
        AnchorPane.setTopAnchor(button1, 0.0);
        button1.setLayoutX(570.0);
        button1.setLayoutY(18.0);
        button1.setMnemonicParsing(false);
        button1.setPrefHeight(50.0);
        button1.setPrefWidth(150.0);
        button1.setStyle("-fx-background-color: #000000; -fx-font-size: 18; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 6);");
        button1.setText("Save");
        button1.setTextFill(javafx.scene.paint.Color.WHITE);
         button1.setOnAction(new EventHandler<ActionEvent>(){
     @Override
     public void handle(ActionEvent event) {
         if(!flag_save)
         {
         ArrayList<Integer> Moves = null;
         
       
          switch(flag)
          {
             case 1:
                  gameStatus=("Draw");
                  gameType="local";
                 Moves = xo_scene_localPlayingBase.Moves;
                  break;
                  
                  
             case 2:    
             if(computerfinalBase.won==1)
               {
                 gameStatus="won"; 
                 
                 }
             else if(computerfinalBase.won==0)
                {
                  gameStatus="lose";  
                }                                                                
             else
             {
            gameStatus="draw";

             
             }
       Moves= computerfinalBase.stepsplayer;

  gameType=computerfinalBase.GameType;
       break;
       case 3:    
        gameStatus=("Draw");
        gameType="play over Network";
        Moves = xo_scene_networkPlayingBase.cells;
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
             System.out.println(gameID);
             for (int jj=0;jj<Moves.size() ;jj++)
             {
                 if(Moves.get(jj)!=0)
                 {
                     sqlDB.addmoveDB(fplayerID, gameID,Moves.get(jj));
                 }
              }
                        Alert alert=new Alert(Alert.AlertType.INFORMATION);
              alert.setTitle("Information Dialog");
              alert.setHeaderText(null);
              alert.setContentText("Play Saved Successfully");
              alert.showAndWait();
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
        getChildren().add(label);
        getChildren().add(imageView);
        getChildren().add(button1);

    }
}
