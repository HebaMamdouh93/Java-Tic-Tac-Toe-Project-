package network;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import network.FXMLTicTacToe;
import network.playersOfGame;

public  class xo_scene_networkBase extends AnchorPane {

    protected final ImageView imageView;
    protected final Button button;
    protected final Label label;
    protected final Label label0;
    protected final TextField textField;
    protected final TextField textField0;
    protected final Button button0;
    protected final MenuButton menuButton;
    protected final MenuItem menuItem;

    public xo_scene_networkBase(Stage stage) {
 /*
        try {
             new server();
         } catch (IOException ex) {
             ex.printStackTrace();
         }
*/
        imageView = new ImageView();
        button = new Button();
        label = new Label();
        label0 = new Label();
        textField = new TextField();
        textField0 = new TextField();
        button0 = new Button();
        menuButton = new MenuButton();
        menuItem = new MenuItem();

        setId("AnchorPane");
        setPrefHeight(700.0);
        setPrefWidth(700.0);
        setStyle("-fx-background-color: Linear-gradient(#0099CC,white,#0099CC);;");
        setOpaqueInsets(new Insets(0.0));

        AnchorPane.setBottomAnchor(imageView, 237.969390869141);
        AnchorPane.setLeftAnchor(imageView, 14.0);
        AnchorPane.setRightAnchor(imageView, 21.0);
        AnchorPane.setTopAnchor(imageView, 100.0);
        imageView.setFitHeight(322.0);
        imageView.setFitWidth(673.0);
        imageView.setLayoutX(6.0);
        imageView.setLayoutY(153.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("tictactoe.jpg").toExternalForm()));

        AnchorPane.setBottomAnchor(button, 25.0);
        AnchorPane.setLeftAnchor(button, 469.0);
        AnchorPane.setRightAnchor(button, 39.0);
        button.setLayoutX(469.0);
        button.setLayoutY(625.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(50.0);
        button.setPrefWidth(200.0);
        button.setStyle("-fx-background-color: #F33250; -fx-font-size: 18; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 10, 6);");
        button.setText("Start");
        button.setTextFill(javafx.scene.paint.Color.WHITE);
        button.setOnAction(new EventHandler<ActionEvent>(){
     @Override
     public void handle(ActionEvent event) {
         String firstPlayer=textField.getText();
         String secondPlayer=textField0.getText();
         playersOfGame.setFirstPlayer(firstPlayer);
         playersOfGame.setSecondPlayer(secondPlayer);
         /*
         String fname=playersOfGame.getFirstPlayer();
         String sname=playersOfGame.getSecondPlayer();
         System.out.println(fname);
         System.out.println(sname);
*/
         //sqlDB.addUserDB(firstPlayer);
         //sqlDB.addUserDB(secondPlayer);
        
        Scene s;
         try {
             s = new Scene(new xo_scene_networkPlayingBase(stage), 700, 700);
             stage.setScene(s);
         } catch (Exception ex) {
             ex.printStackTrace();
         }
        
         
      
     }
            
        }
        );
        AnchorPane.setBottomAnchor(label, 225.0);
        AnchorPane.setLeftAnchor(label, 74.0);
        label.setLayoutX(74.0);
        label.setLayoutY(444.0);
        label.setText("Player X name:");
        label.setFont(new Font("Calibri Bold Italic", 27.0));

        AnchorPane.setBottomAnchor(label0, 133.0);
        AnchorPane.setLeftAnchor(label0, 74.0);
        label0.setLayoutX(74.0);
        label0.setLayoutY(536.0);
        label0.setText("Player O name:");
        label0.setFont(new Font("Calibri Bold Italic", 27.0));

        AnchorPane.setBottomAnchor(textField, 225.0);
        AnchorPane.setLeftAnchor(textField, 257.0);
        AnchorPane.setRightAnchor(textField, 110.0);
        textField.setLayoutX(257.0);
        textField.setLayoutY(444.0);
        textField.setPrefHeight(31.0);
        textField.setPrefWidth(341.0);
        textField.setPromptText("Player X");
        textField.setStyle("-fx-border-color: #000000; -fx-background-color: #FFFFFF; -fx-border-width: 2px;");

        AnchorPane.setBottomAnchor(textField0, 133.0);
        AnchorPane.setLeftAnchor(textField0, 257.0);
        AnchorPane.setRightAnchor(textField0, 110.0);
        textField0.setLayoutX(257.0);
        textField0.setLayoutY(521.0);
        textField0.setPrefHeight(31.0);
        textField0.setPrefWidth(341.0);
        textField0.setPromptText("Player O");
        textField0.setStyle("-fx-border-color: #000000; -fx-background-color: #FFFFFF; -fx-border-width: 2px;");

        AnchorPane.setBottomAnchor(button0, 25.0);
        button0.setLayoutX(31.0);
        button0.setLayoutY(625.0);
        button0.setMnemonicParsing(false);
        button0.setPrefHeight(50.0);
        button0.setPrefWidth(200.0);
        button0.setStyle("-fx-background-color: #F33250; -fx-font-size: 18; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 10, 6);");
        button0.setText("Back");
        button0.setTextFill(javafx.scene.paint.Color.WHITE);
        button0.setOnAction(new EventHandler<ActionEvent>(){
     @Override
     public void handle(ActionEvent event) {
         
        
        Scene s = new Scene(new FXMLTicTacToe(stage), 700, 700);
        stage.setScene(s);
      
     }
            
        }
        );
        AnchorPane.setRightAnchor(menuButton, 0.0);
        AnchorPane.setTopAnchor(menuButton, 0.0);
        menuButton.setLayoutX(484.0);
        menuButton.setLayoutY(17.0);
        menuButton.setMnemonicParsing(false);
        menuButton.setPrefHeight(44.0);
        menuButton.setPrefWidth(226.0);
        menuButton.setStyle("-fx-background-color: #333333;");
        menuButton.setText("Online ");
        menuButton.setTextFill(javafx.scene.paint.Color.valueOf("#f33250"));

        menuItem.setMnemonicParsing(false);
        menuButton.setFont(new Font("Calibri", 24.0));

        getChildren().add(imageView);
        getChildren().add(button);
        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(textField);
        getChildren().add(textField0);
        getChildren().add(button0);
        menuButton.getItems().add(menuItem);
        getChildren().add(menuButton);

    }
}
