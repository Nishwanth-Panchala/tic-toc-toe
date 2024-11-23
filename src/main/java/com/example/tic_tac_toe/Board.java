package com.example.tic_tac_toe;

public class Board {
    private String[] board;
    private static final String EMPTY = " ";

    public Board() {
        this.board = new String[9];
        for (int i = 0; i < 9; i++) {
            board[i] = EMPTY;
        }
    }

    public boolean makeMove(int position, String player) {
        if (position < 1 || position > 9 || !board[position - 1].equals(EMPTY)) {
            return false;
        }
        board[position - 1] = player;
        return true;
    }

    public boolean isFull() {
        for (String cell : board) {
            if (cell.equals(EMPTY)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkWinner() {
        // Check rows, columns, and diagonals
        int[][] winConditions = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Rows
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Columns
            {0, 4, 8}, {2, 4, 6}             // Diagonals
        };

        for (int[] condition : winConditions) {
            if (board[condition[0]].equals(board[condition[1]]) &&
                board[condition[1]].equals(board[condition[2]]) &&
                !board[condition[0]].equals(EMPTY)) {
                return true;
            }
        }
        return false;
    }

    public void printBoard() {
        System.out.println("\n" +
                board[0] + "|" + board[1] + "|" + board[2] + "\n" +
                "-----\n" +
                board[3] + "|" + board[4] + "|" + board[5] + "\n" +
                "-----\n" +
                board[6] + "|" + board[7] + "|" + board[8]);
    }
}
