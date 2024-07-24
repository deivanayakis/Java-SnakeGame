/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package snakegame;

import java.util.*;

public class SnakeGame {

    public static void main(String[] args) {
        System.out.println("Welcome to snake game");
        Scanner in = new Scanner(System.in);
        System.out.println("Dimension of Board (nxn) ");
        int n=in.nextInt();
        Board b = new Board(n);
        char ch;
        int result;
        while(true)
        {
            System.out.println("Enter Move direction (L/R/U/D)");
            ch=in.next().toUpperCase().charAt(0);
            result=b.isPossibleToMove(ch);
            if(result==0)
            {
                System.out.println("Invalid Move!! Try Other Direction");
            }
            else if(result==2)
            {
                System.out.println("Game Over!!\nYour Points = "+b.points);
                break;
            }
            
        }
    }
    
}
