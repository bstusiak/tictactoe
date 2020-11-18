/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.util.Scanner;

/**
 *
 * @author stusi
 */
public class TicTacToe {
    int[][] gameboard;
    int turn;
    int numMoves;
    static int X = 0;
    static int O = 1;
    static int EMPTY = -1;
    Scanner input;
    
    // Constructor for the class
    public TicTacToe() {
        input = new Scanner(System.in);
        gameboard = new int[3][3];
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++) {
                gameboard[i][j] = EMPTY; // Empty square
            }
        }
        turn = X;
        numMoves = 0;
        printBoard();
    }
    
    private void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameboard[i][j] == X) {
                    System.out.print(" X ");
                } else if (gameboard[i][j] == O) {
                    System.out.print(" O ");
                } else {
                    System.out.print("   ");
                }
                if (j != 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i != 2) {
                System.out.println("-----------"); 
            }
            
        }
    }
    
    public void move() {
        System.out.println("Enter row and column 'RC'");
        String userMove = input.nextLine();
        int row = Integer.parseInt(userMove.substring(0,1));
        int col = Integer.parseInt(userMove.substring(1,2));
        gameboard[row][col] = turn;
        turn++;
        turn %= 2;
        numMoves++;
        printBoard();
    }
    
    public int winner() {
        // Check each row
        for (int i = 0; i < 3; i++) {
            boolean cond1 = gameboard[i][0] == gameboard[i][1];
            boolean cond2 = gameboard[i][1] == gameboard[i][2];
            // If they are all the same, return the letter 
            if (cond1 && cond2) {
                return gameboard[i][0];
            }
        }
        // FIX: Check each column 
        
        // Check the diagonals
        boolean cond1 = gameboard[0][0] == gameboard[1][1];
        boolean cond2 = gameboard[1][1] == gameboard[2][2];
        if (cond1 && cond2) {
            return gameboard[0][0];
        }
        // FIX: Check other diagonal
        
        return -1;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        while (game.winner() == -1 && game.numMoves != 9) {
            game.move();
        }
        
    }
    
}
