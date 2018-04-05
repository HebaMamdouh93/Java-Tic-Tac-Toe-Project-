/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

/**
 *
 * @author Heba Zaytoun
 */
public class playersOfGame {
     public static String first;
     public static String Second;
    public static void setFirstPlayer(String fPlayer){
       first=fPlayer;
       
    }
     public static void setSecondPlayer(String sPlayer){
       Second=sPlayer;
       
    }
      public static String getFirstPlayer(){
       return first;
       
    }
     public static String getSecondPlayer(){
       return Second;
       
    }
     
   
    
   
}
