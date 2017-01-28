package com.antviktorov.chess;

import com.antviktorov.chess.figures.Figure;
import com.antviktorov.chess.figures.Knight;
import com.antviktorov.chess.figures.Pawn;
import com.antviktorov.chess.figures.Queen;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BoardTest {
    @Test
    public void whenFigureIsQueenThenPutItOnBoardAndMove() {
        Board board = new Board();
        Queen queen = new Queen(new Cell(0,0));
        board.addFigure(queen);
        Figure movedQueen = board.move(new Cell(0,0), new Cell(3,3));
        assertThat(movedQueen, is(board.getFigure(new Cell(3,3))));
    }

    @Test
    public void whenFigureIsPawnThenPutItOnBoardAndMove() {
        Board board = new Board();
        Pawn pawn = new Pawn(new Cell(0,0), true);
        board.addFigure(pawn);
        Figure movedPawn = board.move(new Cell(0,0), new Cell(0,1));
        assertThat(movedPawn, is(board.getFigure(new Cell(0,1))));
    }

    @Test
    public void whenFigureIsKnigtThenPutItOnBoardAndMove() {
        Board board = new Board();
        Knight knight = new Knight(new Cell(0,0));
        board.addFigure(knight);
        Figure movedKnight = board.move(new Cell(0,0), new Cell(1,2));
        assertThat(movedKnight, is(board.getFigure(new Cell(1,2))));

        movedKnight = board.move(new Cell(1,2), new Cell(2,4));

        assertThat(movedKnight, is(board.getFigure(new Cell(2,4))));
    }
}