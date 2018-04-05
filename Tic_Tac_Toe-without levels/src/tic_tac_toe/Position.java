/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Computer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author diaabrody
 */
public class Position {

public static final int DIM=3;
public static final int SIZE=DIM*DIM;
public char[] board; //have all borad from x , o 
public char turn ;  // x  ,   o 
private Map<Integer , Integer>cache=new HashMap<Integer , Integer>();
   
   public Position()
   {
       turn = 'x';  //start game  for the player x
       board=new char [SIZE]; // create new char with size array
       for(int i=0 ; i<SIZE ; i++)
       { 
          board[i]=' '; // make all bord blank 
          
       }
   }
   
   
      public Position(String board , char turn) 
   {
      this.board=board.toCharArray(); // convert string to char array 
      this.turn=turn;
      
      
   }
   @Override
    public  String toString()
      {
          return new String(board); //return board as string
          
          
      }
    
    
  /*   move method */
    public Position move (int idx) 
                      
    {
        
       board[idx]=turn;
       if(turn=='x')                                                                    
           
       {
           turn='o';
       }
       else                                                              
       {
              turn='x';
       }
        return this ; 
        
        
       /* in this method just turn will insert in board  and convert turn 
    
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

       /*
       this method unmove 
       */
   }
    
    public List<Integer> possibleMoves()
    {
        List<Integer>list=new ArrayList<>();
        for(int i=0 ; i<board.length ; i++)
        {
            if(board[i]==' ')
            {
              list.add(i);        // return list with blank indexes in board .
            }
        }
        
        return list;
        
    }
    
    public boolean isWinFor(char turn)
    {
        
      /*this method take parameter x , o  and return boolean is there are winner x or o*/  
       boolean iswin=false;
       
        for(int i=0; i<SIZE ; i+=DIM)
        {
            iswin= iswin || lineMatch(turn,i,i+DIM,1);    /* xxx  will take line by line
                                                             oxo
                                                             oxo
            
                                                              */
           
        }
        for(int i=0 ;i<DIM ; i++)
        {
            
          iswin= iswin || lineMatch(turn,i,SIZE,DIM);            /*xox"
                                                                  "xxo"
                                                                  "xox"*/
          
        }
        
        
        
               iswin= iswin || lineMatch(turn,0,SIZE,DIM+1);  /*"xoo"
                                                                "oxo"
                                                                "xox"*/
        
        
         iswin= iswin || lineMatch(turn,DIM-1,SIZE-1,DIM-1);   /*"  o"
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
         
            
        }   //here i will do recursion  "xx       "  if i make "xxx      "  خطوه وهميه 
                                                       
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
      return turn=='x'? Collections.max(list,cmp):Collections.min(list,cmp);
  }
  
  
  
  public boolean isGameEnd()
  {
      return isWinFor('x')||isWinFor('o')||blocks()==0; 
      
  }


}
    

    
    

