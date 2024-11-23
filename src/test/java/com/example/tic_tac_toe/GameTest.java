package com.example.tic_tac_toe;

import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void testValidMove() {
        Board board = new Board();
        assertTrue(board.makeMove(1, "X"));
        assertFalse(board.makeMove(1, "O")); // Position already occupied
    }

    @Test
    public void testBoardFull() {
        Board board = new Board();
        for (int i = 1; i <= 9; i++) {
            board.makeMove(i, i % 2 == 0 ? "O" : "X");
        }
        assertTrue(board.isFull());
    }

    @Test
    public void testWinner() {
        Board board = new Board();
        board.makeMove(1, "X");
        board.makeMove(2, "X");
        board.makeMove(3, "X");
        assertTrue(board.checkWinner());
    }
}
