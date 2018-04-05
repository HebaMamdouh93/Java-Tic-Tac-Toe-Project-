package tic_tac_toe.Network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
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
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import tic_tac_toe.FXMLTicTacToe;
import tic_tac_toe.Lose;
import tic_tac_toe.WonBase;
import tic_tac_toe.drawBase;
//import tic_tac_toe.WonBase;
//import tic_tac_toe.WonBase;
import tic_tac_toe.playersOfGame;
import tic_tac_toe.recallBase;

public  class xo_scene_networkPlayingBase extends AnchorPane {

    protected final Button button;
    protected final Label label;
    protected final Label label0;
   // protected final Button button0;
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
    Image player ;
    Image opponentplayer;
    Button[] board;
   
    String[] history;
    
    //Save game 
    //private int[] cells;
    public static ArrayList <Integer> cells=new ArrayList();
    public String gameStatus;
    private String gameType="Play Over Network";
    private SimpleDateFormat sdf; 
    private Timestamp gameTimestampobj;
    private String gameTimestamp;
    private String fname;
    private String sname;
    private int fplayerID;
    private int splayerID;
    private int gameID;
    
    //client connected to the server
    private static int PORT = 8901;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
               
              
               
    public xo_scene_networkPlayingBase(Stage stage) throws Exception{
        
        
           //Stage s=stage;
        // Setup networking
       // socket = new Socket(InetAddress.getLocalHost(), PORT);
       socket = new Socket("172.16.6.15", PORT);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
        cells.clear();
        //Names of players
              fname=playersOfGame.getFirstPlayer();
              sname=playersOfGame.getSecondPlayer();

         out.println("Player x");
        
        button = new Button();
        label = new Label();
        label0 = new Label();
        //button0 = new Button();
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
         board= new Button[9];
         //cells=new int[9];
         //Array of Buttons
            board[0]=button1;
            board[1]=button2;
            board[2]=button5;
            board[3]=button3;
            board[4]=button7;
            board[5]=button8;
            board[6]=button4;
            board[7]=button6;
            board[8]=button9;
        
         //Date Format
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        setId("AnchorPane");
        setPrefHeight(700.0);
        setPrefWidth(700.0);
        setStyle("-fx-background-color: Linear-gradient(#0099CC,white,#0099CC);;");
        setOpaqueInsets(new Insets(0.0));

        AnchorPane.setBottomAnchor(button, 20.0);
        AnchorPane.setLeftAnchor(button, 469.0);
        AnchorPane.setRightAnchor(button, 39.0);
        
        //Home Button
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
        //Strat Scene
        Scene s = new Scene(new FXMLTicTacToe(stage), 700, 700);
        stage.setScene(s);
     }     
        }
        );
        
        //Player X 
        AnchorPane.setBottomAnchor(label, 614.0);
        AnchorPane.setLeftAnchor(label, 31.0);
        AnchorPane.setRightAnchor(label, 557.0);
        AnchorPane.setTopAnchor(label, 55.0);
        label.setLayoutX(31.0);
        label.setLayoutY(55.0);
        label.setPrefHeight(31.0);
        label.setPrefWidth(112.0);
        //label.setText("Player X ");
        label.setText(fname);
        label.setFont(new Font("Calibri Bold Italic", 27.0));
        
        //player O
        AnchorPane.setBottomAnchor(label0, 614.0);
        AnchorPane.setLeftAnchor(label0, 413.0);
        AnchorPane.setRightAnchor(label0, 175.0);
        AnchorPane.setTopAnchor(label0, 55.0);
        label0.setLayoutX(413.0);
        label0.setLayoutY(55.0);
        label0.setPrefHeight(31.0);
        label0.setPrefWidth(112.0);
        //label0.setText("Player O ");
        label0.setText(sname);
        label0.setTextAlignment(javafx.scene.text.TextAlignment.RIGHT);
        label0.setWrapText(true);
        label0.setFont(new Font("Calibri Bold Italic", 27.0));
         /* 
        //Reset Button
        AnchorPane.setBottomAnchor(button0, 20.0);
        button0.setLayoutX(31.0);
        button0.setLayoutY(625.0);
        button0.setMnemonicParsing(false);
        button0.setPrefHeight(50.0);
        button0.setPrefWidth(200.0);
        button0.setStyle("-fx-background-color: #F33250; -fx-font-size: 18; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 10, 6);");
        button0.setText("Save");
        button0.setTextFill(javafx.scene.paint.Color.WHITE);
        */
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
        menuButton.setFont(new Font("Calibri", 24.0)); 
        
        //History 
        fplayerID=sqlDB.getplayerID(fname);
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
                         Scene s = new Scene(new recallBase(stage ,status,fplayerID,gameid,3), 700, 700);
                         stage.setScene(s);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
        
            }
        });
        }
         
       
        //Score For Player X
        AnchorPane.setBottomAnchor(label1, 614.0);
        AnchorPane.setLeftAnchor(label1, 143.0);
        AnchorPane.setRightAnchor(label1, 445.0);
        label1.setLayoutX(143.0);
        label1.setLayoutY(53.0);
        label1.setText("0");
        label1.setTextFill(javafx.scene.paint.Color.WHITE);
        label1.setFont(new Font("System Bold Italic", 24.0));
         
       
        
        //Score For Player Y
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
        
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                //Send Move to the server
                 out.println("MOVE " + 0);
            }
        });

        AnchorPane.setBottomAnchor(button2, 418.0);
        AnchorPane.setTopAnchor(button2, 105.0);
        button2.setLayoutX(263.0);
        button2.setLayoutY(105.0);
        button2.setMnemonicParsing(false);
        button2.setPrefHeight(170.0);
        button2.setPrefWidth(170.0);
        button2.setStyle("-fx-background-color: transparent; -fx-border-color: #000000; -fx-border-width: 2px;");
         button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                 //Send Move to the server
                 out.println("MOVE " + 1);
            }
        });

        AnchorPane.setTopAnchor(button3, 282.0);
        button3.setLayoutX(93.0);
        button3.setLayoutY(282.0);
        button3.setMnemonicParsing(false);
        button3.setPrefHeight(170.0);
        button3.setPrefWidth(170.0);
        button3.setStyle("-fx-background-color: transparent; -fx-border-color: #000000; -fx-border-width: 2px;");
        button3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                  //Send Move to the server
                 out.println("MOVE " + 3);
            }
        });
        AnchorPane.setBottomAnchor(button4, 78.0);
        AnchorPane.setTopAnchor(button4, 452.0);
        button4.setLayoutX(93.0);
        button4.setLayoutY(452.0);
        button4.setMnemonicParsing(false);
        button4.setPrefHeight(170.0);
        button4.setPrefWidth(170.0);
        button4.setStyle("-fx-background-color: transparent; -fx-border-color: #000000; -fx-border-width: 2px;");
         button4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                  //Send Move to the server
                 out.println("MOVE " + 6);
            }
        });
         
        AnchorPane.setBottomAnchor(button5, 418.0);
        AnchorPane.setTopAnchor(button5, 105.0);
        button5.setLayoutX(433.0);
        button5.setLayoutY(109.0);
        button5.setMnemonicParsing(false);
        button5.setPrefHeight(170.0);
        button5.setPrefWidth(170.0);
        button5.setStyle("-fx-background-color: transparent; -fx-border-width: 2px; -fx-border-color: #000000;");
        button5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                 //Send Move to the server
                 out.println("MOVE " + 2);
            }
        });
        
        AnchorPane.setBottomAnchor(button6, 78.0);
        AnchorPane.setTopAnchor(button6, 452.0);
        button6.setLayoutX(263.0);
        button6.setLayoutY(282.0);
        button6.setMnemonicParsing(false);
        button6.setPrefHeight(170.0);
        button6.setPrefWidth(170.0);
        
        //then you set to your node
        this.getStylesheets().add(getClass().getResource("style.css").toString());
        button6.setStyle("-fx-background-color: transparent; -fx-border-color: #000000; -fx-border-width: 2px;");
         button6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                 //Send Move to the server
                 out.println("MOVE " + 7);
            }
        });
        
        button7.setLayoutX(263.0);
        button7.setLayoutY(282.0);
        button7.setMnemonicParsing(false);
        button7.setPrefHeight(170.0);
        button7.setPrefWidth(170.0);
        button7.setStyle("-fx-background-color: transparent; -fx-border-color: #000000; -fx-border-width: 2px;");
        button7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                   //Send Move to the server
                 out.println("MOVE " + 4);
            }
        });
 
        button8.setLayoutX(433.0);
        button8.setLayoutY(282.0);
        button8.setMnemonicParsing(false);
        button8.setPrefHeight(170.0);
        button8.setPrefWidth(170.0);
        button8.setStyle("-fx-background-color: transparent; -fx-border-color: #000000; -fx-border-width: 2px;");
         button8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                   //Send Move to the server
                 out.println("MOVE " + 5);
            }
        });
         
        button9.setLayoutX(433.0);
        button9.setLayoutY(452.0);
        button9.setMnemonicParsing(false);
        button9.setPrefHeight(170.0);
        button9.setPrefWidth(170.0);
        button9.setStyle("-fx-background-color: transparent; -fx-border-color: #000000; -fx-border-width: 2px;");
        button9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                  //Send Move to the server
                 out.println("MOVE " + 8);
            }
        });
        
        getChildren().add(button);
        getChildren().add(label);
        getChildren().add(label0);
        //getChildren().add(button0);
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

        //Start Game;
        MyThread th=new MyThread(stage);
        th.start();
       
        
    }
   
     
     //Player Thread to Listen to Messages from Server 
    //tell that one player win or lose or tie with another one 
     
    class MyThread extends Thread  {
       public Stage stage;
        public MyThread(Stage s){
        stage =s;
        }
        public void run(){
        String response;
        int i=0;
        try {
            while (true) {
                //Listen to server
                response = in.readLine();
                
                 if (response.startsWith("WELCOME")) {

                char mark = response.charAt(8);
                //System.out.println(response);
                
                //Set the images of Player and opponentplayer
                player = new Image(mark == 'X' ? getClass().getResourceAsStream("x.png"): getClass().getResourceAsStream("O.png"));
                opponentplayer = new Image(mark == 'X' ? getClass().getResourceAsStream("O.png"): getClass().getResourceAsStream("x.png"));
             
            }
                
                if (response.startsWith("VALID_MOVE")) {
                  
                    int loc=Integer.parseInt(response.substring(10));
                    cells.add(loc+1);
                   
                    System.out.println("Valid move, please wait");
                    
                
                //Set Move on the Button Must In Application Thread
                    
                Platform.runLater(new Runnable()

                {
                    @Override
                    public void run()

                    {
                                  ImageView  imgView = new ImageView(player);
                                  imgView.setFitWidth(150);
                                  imgView.setPreserveRatio(true);
                                 board[loc].setGraphic(imgView);
                                 label.setTextFill(Color.RED);
                                 label0.setTextFill(Color.GREEN);

                    }
                });

                    
                   
                } else if (response.startsWith("OPPONENT_MOVED")) {
                    int loc = Integer.parseInt(response.substring(15));
                  
                    cells.add(loc+1);
                    System.out.println("Opponent moved, your turn in location"+loc);
                    Platform.runLater(new Runnable()

                {
                    @Override
                    public void run()

                    {
                                  ImageView  imgView = new ImageView(opponentplayer);
                                  imgView.setFitWidth(150);
                                  imgView.setPreserveRatio(true);
                                 board[loc].setGraphic(imgView);
                                 label.setTextFill(Color.GREEN);
                                 label0.setTextFill(Color.RED);

                    }
                });
        
                } else if (response.startsWith("VICTORY")) {
                    
                    gameStatus="win";
                    label1.setText("1");
                     Platform.runLater(new Runnable()

                {
                    @Override
                    public void run()

                    {
                                 
                     Scene s = new Scene(new WonBase(stage, fname, 3), 700, 700);
                     stage.setScene(s);
                    }
                });
                    break;
                } else if (response.startsWith("DEFEAT")) {
                    gameStatus="lose";
                    label2.setText("1");
                     Platform.runLater(new Runnable()

                {
                    @Override
                    public void run()

                    {
                                 
                     Scene s = new Scene(new Lose(stage, sname, 3), 700, 700);
                     stage.setScene(s);
                    }
                });
                    
                    System.out.println("You lose");
                    break;
                } else if (response.startsWith("TIE")) {
                    gameStatus="tie";
                    System.out.println("You tied");
                    
                     Platform.runLater(new Runnable()

                {
                    @Override
                    public void run()

                    {
                                 
                     Scene s = new Scene(new drawBase(stage,3), 700, 700);
                     stage.setScene(s);
                    }
                });
                    
                    break;
                } else if (response.startsWith("MESSAGE")) {
                    System.out.println(response.substring(8));
                    //messageLabel.setText(response.substring(8));
                }
            }
          
            System.out.println("cells:"+cells);
            out.println("QUIT");
        }catch(IOException e){
        e.printStackTrace();
        }
        finally {
            try {
                socket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

}
      

    }
} 


