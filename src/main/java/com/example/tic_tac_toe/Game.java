package com.example.tic_tac_toe;

import java.util.Scanner;

public class Game {
    private Board board;
    private String currentPlayer;

    public Game() {
        this.board = new Board();
        this.currentPlayer = "X"; // Starting player
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        int move;
        
        while (!board.isFull() && !board.checkWinner()) {
            board.printBoard();
            System.out.println("Player " + currentPlayer + ", make your move (1-9): ");
            move = scanner.nextInt();
            if (board.makeMove(move, currentPlayer)) {
                currentPlayer = currentPlayer.equals("X") ? "O" : "X"; // Switch player
            } else {
                System.out.println("Invalid move! Try again.");
            }
        }

        board.printBoard();
        if (board.checkWinner()) {
            System.out.println("Player " + (currentPlayer.equals("X") ? "O" : "X") + " wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }
}
