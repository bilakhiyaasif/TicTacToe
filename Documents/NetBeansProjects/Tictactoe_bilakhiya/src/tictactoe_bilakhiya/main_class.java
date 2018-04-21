/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe_bilakhiya;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Bilakhiya
 */
public class main_class {

    protected char[][] board;

    public main_class() {
        this.board = new char[3][3];

    }

    public void setboard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.board[i][j] = '-';
            }
        }
    }

    public void printboard() {
        int x1=1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print((x1++)+"[ "+this.board[i][j]+" ]"+" ");
            }
            System.out.println();
        }
    }

    public boolean check_draw()
    {
        int x=0;
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if((this.board[i][j]=='-'))
                {
                   return false; 
                }
            }
        }
        return true;
    }
    public void setinput_toboard(int p1_in, char p1) {
        String p = find_position(p1_in);

        int i1 = p.charAt(0) - '0';
        int i2 = p.charAt(1) - '0';

        this.board[i1][i2] = p1;

    }

    public boolean check_winner(char p) {
        int i = 0, j = 0;

        for (i = 0; i < 3; i++) {
            if (this.board[i][j] == p && this.board[i][j + 1] == p && this.board[i][j + 2] == p) {
                return true;
            }
           // return false;
        }
        i=0;
        for (j = 0; j < 3; j++) {
        if (this.board[i][j] == p && this.board[i+1][j] == p && this.board[i+2][j] == p)
        {
            return true;
        }
        }
        
        if (this.board[0][0] == p && this.board[1][1] == p && this.board[2][2] == p)
        {
            return true;
        }
        if (this.board[0][2] == p && this.board[1][1] == p && this.board[2][0] == p)
        {
            return true;
        }
      
        
        

        return false;
    }
    public int check_isvalid(int i)
    {
       try
        {
       Scanner sc=new Scanner(System.in);
       String p11=find_position(i);
       int p1=p11.charAt(0)-'0';
       int p2=p11.charAt(1)-'0';
   //    System.out.println(p11);
       if(this.board[p1][p2]=='-')
       {
           return i;
       }
       else
       {
           System.out.println("position is not valid.....enter again:");
           i=sc.nextInt();
           check_isvalid(i);
       }
       }
       catch(Exception e)
       {
           System.out.println("position is not valid.....enter again:");
           Scanner sc=new Scanner(System.in);
           i=sc.nextInt();
           check_isvalid(i);
       }
       //sc.close();
       return i;
    }
    public void game_start()
    {
        Scanner sc = new Scanner(System.in);
        main_class m1 = new main_class();
        m1.setboard();
        m1.printboard();
        char p1 = ' ';
        char p2 = ' ';
        String player_1="";
        String player_2="";
        
        System.out.println("Enter 1st Player Name: ");
        player_1=sc.next();
        System.out.println("Enter your mark/symbol: ");
        p1=sc.next().charAt(0);
        
        
        
        
        System.out.println("Enter 2nd Player Name: ");
        player_2=sc.next();
        System.out.println("Enter your mark/symbol: ");
        p2=sc.next().charAt(0);
        
        int p1_in = 0;
        int p2_in = 0;
        boolean win = false;
        boolean draw=false;
        char ch=' ';
        while (true) {
            System.out.println("enter your input "+player_1+" "+p1+":");
            p1_in = sc.nextInt();
            p1_in=m1.check_isvalid(p1_in);
            m1.setinput_toboard(p1_in, p1);
            win = m1.check_winner(p1);
            draw=m1.check_draw();
            m1.printboard();
            
            if(draw)
            {
            System.out.println("Game is Draw");
            System.out.println("Do you want to play again ?(y/n):");
                ch=sc.next().charAt(0);
                if(ch=='y'||ch=='Y')
                {
                    m1=new main_class();
                    m1.setboard();
                    m1.printboard();
                    
                }
                else
                {
                break;
                }
            }   
            else if (win) {
                System.out.println("winner is "+player_1);
                
                System.out.println("Do you want to play again ?(y/n):");
                ch=sc.next().charAt(0);
                if(ch=='y'||ch=='Y')
                {
                    m1=new main_class();
                    m1.setboard();
                    m1.printboard();
                    
                }
                else
                {
                break;
                }
            }

            System.out.println("enter your input "+player_2+" "+p2+":");
            p2_in = sc.nextInt();
            p2_in=m1.check_isvalid(p2_in);
            m1.setinput_toboard(p2_in, p2);
            
            win = m1.check_winner(p2);
            draw=m1.check_draw();
            m1.printboard();
            if(draw)
            {
                System.out.println("Game is Draw");
                System.out.println("Do you want to play again ?(y/n):");
                ch=sc.next().charAt(0);
                if(ch=='y'||ch=='Y')
                {
                    m1=new main_class();
                    m1.setboard();
                    m1.printboard();
                    
                }
                else
                {
                break;
                }
            }
            else if (win) {
                System.out.println("winner is "+player_2);
            
                System.out.println("Do you want to play again ?(y/n):");
                ch=sc.next().charAt(0);
                if(ch=='y'||ch=='Y')
                {
                    m1=new main_class();
                    m1.setboard();
                    m1.printboard();
                    
                }
                else
                {
                break;
                }
                
            }

        }

    }
    public static void main(String args[]) {
        
    }

    public static String find_position(int p1_in) {
        switch (p1_in) {
            case 1:
                return "00";
            //   break;
            case 2:
                return "01";
            // break;
            case 3:
                return "02";
            //break;
            case 4:
                return "10";
            //break;
            case 5:
                return "11";
            //break;
            case 6:
                return "12";
            //break;

            case 7:
                return "20";
            //break;
            case 8:
                return "21";
            //break;
            case 9:
                return "22";
            //break;SS

        }
        return "";
    }

}
