
package tic_tac_toe;

import aima.core.environment.tictactoe.TicTacToeGame;
import aima.core.environment.tictactoe.TicTacToeState;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import aima.core.search.adversarial.*;
import aima.core.util.datastructure.XYLocation;
import java.util.Random;
import tic_tac_toe.xo_scene_ComputerBase;

/**
 *
 * @author Aya diaa Heba Monica
 */
public class Position {

public static final int DIM=3;
public static final int SIZE=DIM*DIM;
public char[] board; /***have all board from x , o*/ 
public char turn ; 
/***
 * x  ,   o 
 * **/
private Map<Integer , Integer>cache=new HashMap<Integer , Integer>();
 TicTacToeGame g=new TicTacToeGame();
 MinimaxSearch m=new MinimaxSearch(g);
 TicTacToeState s=new TicTacToeState();
   public Position()
   {
       
       turn = 'x';  
       /***
        * X plays first
        */
      MinimaxSearch.createFor(g);
       board=new char [SIZE]; /***
        * create new char with size array
        * ***/
       for(int i=0 ; i<SIZE ; i++)
       { /***
        * clears the array
        */
          board[i]=' '; 
          
          
       }
   
   }
   
   
      public Position(String board , char turn) 
   {
       /***
        * convert string to char array 
        */
      this.board=board.toCharArray(); 
      this.turn=turn;
      
      
   }
   @Override
    public  String toString()
      {
          /***
           *  return board as string
           */
          return new String(board);
          
          
      }
    
    
  /*** 
   * @param  idx is the index of the cell  filled with X or O
   */
    public Position move (int idx) 
                      
    {
        
       board[idx]=turn;
       switch(idx)
       {
           /***
            * setting the moved position by calling method mark in class TicTacToeState in aima.core library
            */
           case 0:s.mark(idx, idx);break;
           case 1:s.mark(0,1);break;
           case 2:s.mark(0,2);break;
            case 3:s.mark(1, 0);break;
           case 4:s.mark(1,1);break;
           case 5:s.mark(1,2);break;
           case 6:s.mark(2, 0);break;
           case 7:s.mark(2,1);break;
           case 8:s.mark(2,2);break;
       }
       if(turn=='x')                                                                    
           
       {
           turn='o';
       }
       else                                                              
       {
              turn='x';
       }

        return this ; 
        
        
       /***in this method just turn will insert in board  and convert turn 
    
       if x will be o and if o will be x                                         
   
    */ 
    }
    
    public Position unmove(int idx)
    {
        
       board[idx]=' ';
                                                                         
           
       if(turn=='x')
       {
           turn='o';
       }
       else                                                              
       {
              turn='x';
       }
    
       return this ;

       /***
       this method unmove 
       */
   }
    
    public List<Integer> possibleMoves()
    {
        /***
         * return list with blank indexes in board .
         */
        List<Integer>list=new ArrayList<>();
        for(int i=0 ; i<board.length ; i++)
        {
            if(board[i]==' ')
            {
              list.add(i);        
              System.out.println(i);
            }
        }

        return list;
        
    }
    
    public boolean isWinFor(char turn)
    {
        
      /***
       * this method take parameter x , o  and return boolean is there are winner x or o
       */  
       boolean iswin=false;
       
        for(int i=0; i<SIZE ; i+=DIM)
        {
            iswin= iswin || lineMatch(turn,i,i+DIM,1);    /***
                                                              * xxx  will take line by line
                                                             oxo
                                                             oxo
            
                                                              */
           
        }
        for(int i=0 ;i<DIM ; i++)
        {
            
          iswin= iswin || lineMatch(turn,i,SIZE,DIM);            /***xox"
                                                                  "xxo"
                                                                  "xox"*/
          
        }
        
        
        
               iswin= iswin || lineMatch(turn,0,SIZE,DIM+1);  /***"xoo"
                                                                "oxo"
                                                                "xox"*/
        
        
         iswin= iswin || lineMatch(turn,DIM-1,SIZE-1,DIM-1);   /***"  o"
                                                             " o "
                                                             "o  "*/
        
        return  iswin ;
        
        
          
    }

    private boolean lineMatch(char turn,int start, int end,int step) {
        
        for(int i =start ; i<end ;i+=step)
        {
            if(board[i]!=turn)
            {
                return false ;
                
            }
            
        }
               return  true ; 
      
               
               /*this method take turn and start and end and  return boolean*/
    }
    public int code()
    {
        int value=0;
        for(int i=0 ; i<SIZE  ; i++)
        {
            value=value*3;
            if(board[i]=='x')
                value +=1;
            else if(board[i]=='o')
                value +=2;
        }
        return value;
    }
    
 public int MinMax()
    {
        Integer key=code();
         Integer value=cache.get(key);
        if(value !=null) return value;
        if(isWinFor('x')) 
        {
            return  blocks();
        }
        if(isWinFor('o'))
        {
             return -blocks();
        }
        if(blocks()==0)
        {
            return 0 ;
        }
        List<Integer>list=new ArrayList<>();  
        for(Integer idx:this.possibleMoves())
        {
            
           list.add(move(idx).MinMax());
            unmove(idx);
         
            
        }   
                                                       
      value=turn=='x'?Collections.max(list):Collections.min(list);
      cache.put(key, value);
      return value;
     
    }

    private int blocks() {
        int count=0;
       for(int i=0 ;i<SIZE;i++)
       {
           if(board[i]==' ')
           {
               count++;
           }
       }
       return count;
    }

    
  public int bestMove ()
  {
     Comparator<Integer>cmp=new Comparator<Integer>(){
         
        public int  compare(Integer first,Integer second)
        {
            int a=move(first).MinMax();
             unmove(first);
             int b=move(second).MinMax();
            unmove(second);
            return a-b;

        }         
     };
     List<Integer> list=possibleMoves();
     if(xo_scene_ComputerBase.getState()==2){
      /***
       * in case of hard level it calls makeDesion() in class minimaxSearch in aima.core library  using reference of the class and passing it reference of the TicTacToeState
       */
     Object loc=m.makeDecision(s);
      System.out.println(loc.toString() +turn);
      switch(loc.toString()){
      case " ( 0 , 0 ) ":
          return 0; 
      case " ( 0 , 1 ) ":
              return 1;
       case " ( 0 , 2 ) ":
              return 2;
      case " ( 1 , 0 ) ":
              return 3;
       case " ( 1 , 1 ) ":
              return 4;
       case " ( 1 , 2 ) ":
              return 5;
       case " ( 2 , 0 ) ":
              return 6;
     case " ( 2 , 1 ) ":
              return 7;
     default:
           
              return 8;
      }
     }
     else if(xo_scene_ComputerBase.getState()==1)
     {
         int num;

         Random r=new Random();
         do{
         num=r.nextInt(8);
         }while(board[num]!=' ');
       
        return num;
     }
     return Collections.max(list,cmp);
  }
  
  
  
  public boolean isGameEnd()
  {
      return isWinFor('x')||isWinFor('o')||blocks()==1; 
      
  }


}
    

    
    

