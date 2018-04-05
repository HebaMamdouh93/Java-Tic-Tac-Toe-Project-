
package tic_tac_toe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;

public class Tic_Tac_Toe extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
       //Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        FXMLTicTacToe root =new FXMLTicTacToe(stage) ;
        stage.getIcons().add(new Image(getClass().getResourceAsStream("xo_32.png")));
        stage.getIcons().add(new Image(getClass().getResourceAsStream("xo_36.png")));
        stage.getIcons().add(new Image(getClass().getResourceAsStream("xo_64.png")));
        stage.getIcons().add(new Image(getClass().getResourceAsStream("xo_128.png")));
        stage.getIcons().add(new Image(getClass().getResourceAsStream("xo_144.png")));
        stage.getIcons().add(new Image(getClass().getResourceAsStream("xo_250.png")));
        stage.getIcons().add(new Image(getClass().getResourceAsStream("xo_256.png")));
        
        Scene scene = new Scene(root);
         root.setStyle(" -fx-background: #FFFFFF;-fx-border-color:#000000 #FFFFFF #FFFFFF #FFFFFF");
        stage.setTitle("Tic Tac Toe");
         scene.getStylesheets().add(getClass().getResource("style.css").toString());
       //root.getStyleClass().add("root");
         stage.setResizable(false);
         
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        System.out.println("hhhhhhh");
        launch(args);
    }
    
}
