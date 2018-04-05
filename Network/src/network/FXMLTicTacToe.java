package network;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import network.xo_scene_networkBase;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import network.server;

public  class FXMLTicTacToe extends AnchorPane {

    protected final ImageView imageView;
    protected final Button button;
    protected final Button button0;
    protected final Button button1;

    public FXMLTicTacToe(Stage stage) {

        imageView = new ImageView();
        button = new Button();
        button0 = new Button();
        button1 = new Button();

        setId("AnchorPane");
        setPrefHeight(700.0);
        setPrefWidth(700.0);
        setStyle("-fx-background-color: Linear-gradient(#0099CC,white,#0099CC)");
        setOpaqueInsets(new Insets(0.0));

        AnchorPane.setBottomAnchor(imageView, 237.96939086914062);
        AnchorPane.setLeftAnchor(imageView, 14.0);
        AnchorPane.setRightAnchor(imageView, 21.0);
        AnchorPane.setTopAnchor(imageView, 153.0);
        imageView.setFitHeight(322.0);
        imageView.setFitWidth(673.0);
        imageView.setLayoutX(6.0);
        imageView.setLayoutY(153.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("tictactoe.jpg").toExternalForm()));

        AnchorPane.setBottomAnchor(button, 24.0);
        AnchorPane.setLeftAnchor(button, 14.0);
        button.setLayoutX(14.0);
        button.setLayoutY(626.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(50.0);
        button.setPrefWidth(200.0);
        button.setStyle("-fx-background-color: #F33250; -fx-font-size: 18; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 10, 6)");
        button.setText("Computer");
        button.setTextFill(javafx.scene.paint.Color.WHITE);

        AnchorPane.setBottomAnchor(button0, 24.0);
        AnchorPane.setLeftAnchor(button0, 251.0);
        AnchorPane.setRightAnchor(button0, 257.0);
        button0.setLayoutX(251.0);
        button0.setLayoutY(626.0);
        button0.setMnemonicParsing(false);
        button0.setPrefHeight(50.0);
        button0.setPrefWidth(200.0);
        button0.setStyle("-fx-background-color: #F33250; -fx-font-size: 18; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 10, 6)");
        button0.setText("Player(x) vs Player(o)");
        button0.setTextFill(javafx.scene.paint.Color.WHITE);

        AnchorPane.setBottomAnchor(button1, 24.0);
        AnchorPane.setRightAnchor(button1, 14.0);
        button1.setLayoutX(487.0);
        button1.setLayoutY(626.0);
        button1.setMnemonicParsing(false);
        button1.setPrefHeight(50.0);
        button1.setPrefWidth(200.0);
        button1.setStyle("-fx-background-color: #F33250; -fx-font-size: 18; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 10, 6)");
        button1.setText("Network");
        button1.setTextFill(javafx.scene.paint.Color.WHITE);
        button.setOnAction(event-> {
//              Scene s = new Scene(new xo_scene_ComputerBase(stage), 700, 700);
//        stage.setScene(s);   
            
        });
              button0.setOnAction(new EventHandler<ActionEvent>(){
     @Override
     public void handle(ActionEvent event) {
         
        
//        Scene s = new Scene(new xo_scene_localBase(stage), 700, 700);
//        stage.setScene(s);
      
     }
            
        }
        );
                 button1.setOnAction(new EventHandler<ActionEvent>(){
     @Override
     public void handle(ActionEvent event) {
         
         
        
        Scene s = new Scene(new xo_scene_networkBase(stage), 700, 700);
        stage.setScene(s);
        
       
      
     }
            
        }
        );
                

        getChildren().add(imageView);
        getChildren().add(button);
        getChildren().add(button0);
        getChildren().add(button1);

    }
}
