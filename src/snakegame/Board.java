/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snakegame;

/**
 *
 * @author DELL
 */
import java.util.*;

class Index
{
    int i,j;
    
    Index(int i,int j)
    {
        this.i=i;
        this.j=j;
    }
    
}

public class Board {
    
    int points,n;
    char b[][];
    List<Index> snake = new ArrayList<>();
    
    Board(int n)
    {
        this.n=n;
        this.b=new char[n][n];
        b[0][0]='*';
        snake.add(new Index(0,0));
        putFruit();
        displayBoard();
        
    }
    
    void putFruit()
    {
        int i=(int)(Math.random()*(n));
        int j=(int)(Math.random()*(n));
        boolean flag=false;
        for(Index m:snake)
        {
            if(m.i==i && m.j==j)
            {
                flag=true;
                putFruit();
            }
        }
        if(flag==false)
        {
            b[i][j]='X';
        }
    }
    
    void displayBoard()
    {
        System.out.println("--------------------------------------------");
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(b[i][j]=='\u0000')
                {
                    b[i][j]='0';
                }
                System.out.print(b[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("--------------------------------------------");
    }
    
    public int isPossibleToMove(char c)
    {
        int i=snake.get(snake.size()-1).i;
        int j=snake.get(snake.size()-1).j;
        if(c=='L' && i<n && j-1>=0)
        {
            return checkMove(i,j-1);
        }
        else if(c=='R' && i<n && j+1<n)
        {
            return checkMove(i,j+1);
        }
        else if(c=='U' && i-1>=0 && j<n)
        {
            return checkMove(i-1,j);
        }
        else if(c=='D' && i+1<n && j<n)
        {
            return checkMove(i+1,j);
        }
        return 0;
    }
    
    public int checkMove(int i,int j)
    {
        if(b[i][j]=='.')
        {
            return 2;
        }
        snake.add(new Index(i,j));
        if(b[i][j]!='X')
        {
            int i1=snake.get(0).i;
            int j1=snake.get(0).j;
            snake.remove(0);
            b[i1][j1]='\u0000';
        }
        else
        {
            putFruit();
            points+=5;
        }
        for(Index m:snake)
        {
           b[m.i][m.j]='.'; 
        }        
        b[snake.get(snake.size()-1).i][snake.get(snake.size()-1).j]='*';
        displayBoard();
        return 1;
    }
    
}
