package tic_tac_toe;
import java.awt.image.SampleModel;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.ImageIcon;
import tic_tac_toe.Network.sqlDB;


public  class xo_scene_localPlayingBase extends AnchorPane {
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
        //Xo Code
    public static final int EMPTY = 0;
    public static final int X = 1;
    public static final int O = 2;
    
    public static int PLAYING = 0;
    public static  int DRAW = 1;
    public  static int X_WON = 2;
    public  static int O_WON = 3;
  
   public static  int ROWS = 3, COLS = 3; 
   public static int[][] board = new int[ROWS][COLS]; 
   public static int currentState; 
   
   public static int currentPlayer; 
   public static int currentRow, currentCol; 
  public static ArrayList <Integer> Moves=new ArrayList();
 
 
   
 public static void initGame()  //function initilaize game by set all board element zero and first player X and state of game Playing
 {
     for (int row = 0; row < ROWS; ++row) {
         for (int col = 0; col < COLS; ++col) {
            board[row][col] = EMPTY; 
            
         }
      }
      currentState = PLAYING; 
      currentPlayer = X;  
       Moves.clear();
   }
 public static void updateGame(int theMove, int currentRow, int currentCol) //check every game if there is winner or draw case 
 {
      if (IsWon(theMove, currentRow, currentCol)) {  
         currentState = (theMove==X) ? X_WON : O_WON;
      } else if (isDraw()) { 
         currentState = DRAW;
      }
   }
      public static boolean isDraw() //function check if there is draw case
      {
      for (int row = 0; row < ROWS; ++row) {
         for (int col = 0; col < COLS; ++col) {
            if (board[row][col] == EMPTY) {
               return false;  
            }
         }
      }
      return true;  
   }
 public static boolean IsWon(int theMove, int currentRow,int currentCol) //check for winning case 
 {
      return (board[currentRow][0] == theMove          //3 same moves in same row 
                   && board[currentRow][1] == theMove
                   && board[currentRow][2] == theMove
              || board[0][currentCol] == theMove      //3moves is the same column 
                   && board[1][currentCol] == theMove
                   && board[2][currentCol] == theMove
              || currentRow == currentCol            
                   && board[0][0] == theMove      // 3 moves is diagonal and reversed diagonal
                   && board[1][1] == theMove   
                   && board[2][2] == theMove
              || currentRow + currentCol == 2  
                   && board[0][2] ==theMove
                   && board[1][1] == theMove
                   && board[2][0] == theMove);
   }
 public void Game(Button ref ,int x ,int y,int num) //function called in every button listener to update game each step 
 {
            currentRow=x;
            currentCol=y;
        if (currentState == PLAYING){
        if (board[currentRow][currentCol] == EMPTY)
       {
         switch(currentPlayer)
        {
             case X:
                  Image img = new Image(getClass().getResourceAsStream("x.png"));
                  ImageView  imgView = new ImageView(img);
                  imgView.setFitWidth(150);
                  imgView.setPreserveRatio(true);
                  ref.setGraphic(imgView);
                 break;
            case O :
                  Image imgo = new Image(getClass().getResourceAsStream("O.png"));
                  ImageView  imgView1 = new ImageView(imgo);
                  imgView1.setFitWidth(150);
                  imgView1.setPreserveRatio(true);
                   ref.setGraphic(imgView1);
                 break;
        }
           board[currentRow][currentCol] = currentPlayer;
            Moves.add(num);
           updateGame(currentPlayer, currentRow,currentCol); 
           currentPlayer = (currentPlayer == X) ? O : X; 
          }
     } 
 }
public xo_scene_localPlayingBase(Stage stage) throws SQLException, ClassNotFoundException {
        label = new Label();
        label0 = new Label();
        button0 = new Button();
        listView = new ListView();
        menuButton = new MenuButton();
      //  menuItem = new MenuItem();
        label1 = new Label();
        label2 = new Label();
        button = new Button();
        button1 = new Button();
        button2 = new Button();
        button3 = new Button();
        button4 = new Button();
        button5 = new Button();
        button6 = new Button();
        button7 = new Button();
        button8 = new Button();
        button9 = new Button();
        
    Button [] ref=new Button[9];
    ref[0]= button1;
    ref[1]=button2;
    ref[2]=button3;
    ref[3]=button4;
    ref[4]=button5;
    ref[5]=button6;
    ref[6]=button7;
    ref[7]=button8;
    ref[8]=button9;    
        

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
        AnchorPane.setLeftAnchor(label0, 413.0);
        AnchorPane.setRightAnchor(label0, 175.0);
        AnchorPane.setTopAnchor(label0, 55.0);
        label0.setLayoutX(413.0);
        label0.setLayoutY(55.0);
        label0.setPrefHeight(31.0);
        label0.setPrefWidth(112.0);
        label0.setText(playersOfGame.getSecondPlayer());
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
       button0.setOnAction(new EventHandler<ActionEvent>(){
     
     @Override
     public void handle(ActionEvent event) {
       Scene s;
         try {
             s = new Scene(new xo_scene_localPlayingBase(stage), 700, 700);
             stage.setScene(s);
         } catch (SQLException ex) {
             ex.printStackTrace();
         } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
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
        AnchorPane.setBottomAnchor(menuButton, 656.0);
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
                //System.out.println(time.substring(0,19 ));
                try {
                         int gameid=sqlDB.getgameID(time);
                         Scene s = new Scene(new recallBase(stage ,status,fplayerID,gameid,1), 700, 700);
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
        AnchorPane.setLeftAnchor(label2, 540.0);
        AnchorPane.setRightAnchor(label2, 41.0);
        label2.setLayoutX(547.0);
        label2.setLayoutY(53.0);
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
       initGame();
        
 button1.setOnAction(new EventHandler<ActionEvent>(){
     @Override
     public void handle(ActionEvent event) {
         Game(ref[0],0,0,1);
       if(currentState==X_WON )
         {
           
          Scene s = new Scene(new WonBase(stage,playersOfGame.getFirstPlayer(),1), 700, 700);
         stage.setScene(s);
        }
         if(currentState==O_WON)
         {
         Scene s = new Scene(new WonBase(stage,playersOfGame.getSecondPlayer(),1), 700, 700);
         stage.setScene(s); 
         }
         if(currentState==DRAW)
       {
        Scene s = new Scene(new drawBase(stage,1), 700, 700);
        stage.setScene(s); 
        }
         }
        }
      );
  button2.setOnAction(new EventHandler<ActionEvent>(){
     @Override
     public void handle(ActionEvent event) {
      Game(ref[1],0,1,2);
       if(currentState==X_WON )
         {
        Scene s = new Scene(new WonBase(stage,playersOfGame.getFirstPlayer(),1) {}, 700, 700);
        stage.setScene(s); 
        }
         if(currentState==O_WON)
         {
         Scene s = new Scene(new WonBase(stage,playersOfGame.getSecondPlayer(),1) {}, 700, 700);
         stage.setScene(s); 
         }
         if(currentState==DRAW)
       {
        Scene s = new Scene(new drawBase(stage,1), 700, 700);
        stage.setScene(s); 
        }

      }
    }
  );  
  button5.setOnAction(new EventHandler<ActionEvent>(){
     @Override
     public void handle(ActionEvent event) {
         Game(ref[4],0,2,3);
          if(currentState==X_WON )
         {
        Scene s = new Scene(new WonBase(stage,playersOfGame.getFirstPlayer(),1), 700, 700);
        stage.setScene(s); 
        }
         if(currentState==O_WON)
         {
         Scene s = new Scene(new WonBase(stage,playersOfGame.getSecondPlayer(),1), 700, 700);
         stage.setScene(s); 
         }
         if(currentState==DRAW)
       {
        Scene s = new Scene(new drawBase(stage,1), 700, 700);
        stage.setScene(s); 
        }
       }
    }
  );
   
   button3.setOnAction(new EventHandler<ActionEvent>(){
     @Override
     public void handle(ActionEvent event) {
         Game(ref[2],1,0,4);
        if(currentState==X_WON )
         {
        Scene s = new Scene(new WonBase(stage,playersOfGame.getFirstPlayer(),1), 700, 700);
        stage.setScene(s); 
        }
         if(currentState==O_WON)
         {
         Scene s = new Scene(new WonBase(stage,playersOfGame.getSecondPlayer(),1), 700, 700);
         stage.setScene(s); 
         }
         if(currentState==DRAW)
       {
        Scene s = new Scene(new drawBase(stage,1), 700, 700);
        stage.setScene(s); 
        }
         }
        }
     );
   button7.setOnAction(new EventHandler<ActionEvent>(){
     @Override
     public void handle(ActionEvent event) {
         Game(ref[6],1,1,5);
         if(currentState==X_WON )
         {
        Scene s = new Scene(new WonBase(stage,playersOfGame.getFirstPlayer(),1), 700, 700);
        stage.setScene(s); 
        }
         if(currentState==O_WON)
         {
         Scene s = new Scene(new WonBase(stage,playersOfGame.getSecondPlayer(),1), 700, 700);
         stage.setScene(s); 
         }
         if(currentState==DRAW)
       {
        Scene s = new Scene(new drawBase(stage,1), 700, 700);
        stage.setScene(s); 
        }
        }
     }
    );
   button8.setOnAction(new EventHandler<ActionEvent>(){
     @Override
     public void handle(ActionEvent event) {
         Game(ref[7],1,2,6);
         if(currentState==X_WON )
         {
        Scene s = new Scene(new WonBase(stage,playersOfGame.getFirstPlayer(),1), 700, 700);
        stage.setScene(s); 
        }
         if(currentState==O_WON)
         {
         Scene s = new Scene(new WonBase(stage,playersOfGame.getSecondPlayer(),1), 700, 700);
         stage.setScene(s); 
         }
         if(currentState==DRAW)
       {
        Scene s = new Scene(new drawBase(stage,1), 700, 700);
        stage.setScene(s); 
        }
      }
     }
   );
     button4.setOnAction(new EventHandler<ActionEvent>(){
     @Override
     public void handle(ActionEvent event) {
         Game(ref[3],2,0,7);
        if(currentState==X_WON )
         {
        Scene s = new Scene(new WonBase(stage,playersOfGame.getFirstPlayer(),1), 700, 700);
        stage.setScene(s); 
        }
         if(currentState==O_WON)
         {
         Scene s = new Scene(new WonBase(stage,playersOfGame.getSecondPlayer(),1), 700, 700);
         stage.setScene(s); 
         }
         if(currentState==DRAW)
       {
        Scene s = new Scene(new drawBase(stage,1), 700, 700);
        stage.setScene(s); 
        }
         }
      }
   );
      button6.setOnAction(new EventHandler<ActionEvent>(){
     @Override
     public void handle(ActionEvent event) {
         Game(ref[5],2,1,8);
         if(currentState==X_WON )
         {
        Scene s = new Scene(new WonBase(stage,playersOfGame.getFirstPlayer(),1), 700, 700);
        stage.setScene(s); 
        }
         if(currentState==O_WON)
         {
         Scene s = new Scene(new WonBase(stage,playersOfGame.getSecondPlayer(),1), 700, 700);
         stage.setScene(s); 
         }
         if(currentState==DRAW)
       {
        Scene s = new Scene(new drawBase(stage,1), 700, 700);
        stage.setScene(s); 
        }
         }
       }
     );
     button9.setOnAction(new EventHandler<ActionEvent>(){
     @Override
     public void handle(ActionEvent event) {
          Game(ref[8],2,2,9);
     if(currentState==X_WON )
         {
        Scene s = new Scene(new WonBase(stage,playersOfGame.getFirstPlayer(),1), 700, 700);
        stage.setScene(s); 
        }
         if(currentState==O_WON)
         {
         Scene s = new Scene(new WonBase(stage,playersOfGame.getSecondPlayer(),1), 700, 700);
         stage.setScene(s); 
         }
         if(currentState==DRAW)
       {
        Scene s = new Scene(new drawBase(stage,1), 700, 700);
        stage.setScene(s); 
        }
        }
      }
    );
   
        AnchorPane.setBottomAnchor(button2, 418.0);
        AnchorPane.setTopAnchor(button2, 105.0);
        button2.setLayoutX(263.0);
        button2.setLayoutY(105.0);
        button2.setMnemonicParsing(false);
        button2.setPrefHeight(170.0);
        button2.setPrefWidth(170.0);
        button2.setStyle("-fx-background-color: transparent; -fx-border-color: #000000; -fx-border-width: 2px;");

        AnchorPane.setTopAnchor(button3, 282.0);
        button3.setLayoutX(93.0);
        button3.setLayoutY(282.0);
        button3.setMnemonicParsing(false);
        button3.setPrefHeight(170.0);
        button3.setPrefWidth(170.0);
        button3.setStyle("-fx-background-color: transparent; -fx-border-color: #000000; -fx-border-width: 2px;");

        AnchorPane.setBottomAnchor(button4, 78.0);
        AnchorPane.setTopAnchor(button4, 452.0);
        button4.setLayoutX(93.0);
        button4.setLayoutY(452.0);
        button4.setMnemonicParsing(false);
        button4.setPrefHeight(170.0);
        button4.setPrefWidth(170.0);
        button4.setStyle("-fx-background-color: transparent; -fx-border-color: #000000; -fx-border-width: 2px;");

        AnchorPane.setBottomAnchor(button5, 418.0);
        AnchorPane.setTopAnchor(button5, 105.0);
        button5.setLayoutX(433.0);
        button5.setLayoutY(109.0);
        button5.setMnemonicParsing(false);
        button5.setPrefHeight(170.0);
        button5.setPrefWidth(170.0);
        button5.setStyle("-fx-background-color: transparent; -fx-border-width: 2px; -fx-border-color: #000000;");

        AnchorPane.setBottomAnchor(button6, 78.0);
        AnchorPane.setTopAnchor(button6, 452.0);
        button6.setLayoutX(263.0);
        button6.setLayoutY(282.0);
        button6.setMnemonicParsing(false);
        button6.setPrefHeight(170.0);
        button6.setPrefWidth(170.0);
        button6.setStyle("-fx-background-color: transparent; -fx-border-color: #000000; -fx-border-width: 2px;");

        button7.setLayoutX(263.0);
        button7.setLayoutY(282.0);
        button7.setMnemonicParsing(false);
        button7.setPrefHeight(170.0);
        button7.setPrefWidth(170.0);
        button7.setStyle("-fx-background-color: transparent; -fx-border-color: #000000; -fx-border-width: 2px;");

        button8.setLayoutX(433.0);
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
    
}
 }
    