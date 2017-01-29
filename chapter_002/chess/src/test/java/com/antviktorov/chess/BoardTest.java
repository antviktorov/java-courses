package com.antviktorov.chess;

import com.antviktorov.chess.exceptions.*;
import com.antviktorov.chess.figures.*;
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

    @Test
    public void whenFigureIsBishopPutItOnBoardAndMove() {
        Board board = new Board();
        Bishop bishop = new Bishop(new Cell(0,0));
        board.addFigure(bishop);
        //Move right topz   qA
        Figure movedBishop = board.move(new Cell(0,0), new Cell(5,5));
        assertThat(movedBishop, is(board.getFigure(new Cell(5,5))));
        //Back
        movedBishop = board.move(new Cell(5,5), new Cell(0,0));
        assertThat(movedBishop, is(board.getFigure(new Cell(0,0))));
        //Move left bottom
        movedBishop = board.move(new Cell(0,0), new Cell(-5,-5));
        assertThat(movedBishop, is(board.getFigure(new Cell(-5,-5))));
        //Back
        movedBishop = board.move(new Cell(-5,-5), new Cell(0,0));
        assertThat(movedBishop, is(board.getFigure(new Cell(0,0))));
        //Move left top
        movedBishop = board.move(new Cell(0,0), new Cell(-5,5));
        assertThat(movedBishop, is(board.getFigure(new Cell(-5,5))));
        //Back
        movedBishop = board.move(new Cell(-5,5), new Cell(0,0));
        assertThat(movedBishop, is(board.getFigure(new Cell(0,0))));
        //Move right bottom
        movedBishop = board.move(new Cell(0,0), new Cell(5,-5));
        assertThat(movedBishop, is(board.getFigure(new Cell(5,-5))));

        //Try move bishop straightly
        try {
            board.move(new Cell(5,-5), new Cell(0,-5));
        } catch (ImpossibleMoveException e) {
            System.out.println("Test Bishop ImpossibleMoveException straight move to 0 -5");
        }
    }

    @Test
    public void whenFigureIsKingPutItOnBoardAndMove() {
        Board board = new Board();
        King king = new King(new Cell(0,0));
        board.addFigure(king);
        //Move right top
        Figure movedKing = board.move(new Cell(0,0), new Cell(1,1));
        assertThat(movedKing, is(board.getFigure(new Cell(1,1))));
        //Back
        movedKing = board.move(new Cell(1,1), new Cell(0,0));
        assertThat(movedKing, is(board.getFigure(new Cell(0,0))));
        //Move left bottom
        movedKing = board.move(new Cell(0,0), new Cell(-1,-1));
        assertThat(movedKing, is(board.getFigure(new Cell(-1,-1))));
        //Back
        movedKing = board.move(new Cell(-1,-1), new Cell(0,0));
        assertThat(movedKing, is(board.getFigure(new Cell(0,0))));
        //Move left top
        movedKing = board.move(new Cell(0,0), new Cell(-1,1));
        assertThat(movedKing, is(board.getFigure(new Cell(-1,1))));
        //Back
        movedKing = board.move(new Cell(-1,1), new Cell(0,0));
        assertThat(movedKing, is(board.getFigure(new Cell(0,0))));
        //Move right bottom
        movedKing = board.move(new Cell(0,0), new Cell(1,-1));
        assertThat(movedKing, is(board.getFigure(new Cell(1,-1))));
        //Back
        movedKing = board.move(new Cell(1,-1), new Cell(0,0));
        assertThat(movedKing, is(board.getFigure(new Cell(0,0))));
        //Move left
        movedKing = board.move(new Cell(0,0), new Cell(-1,0));
        assertThat(movedKing, is(board.getFigure(new Cell(-1,0))));
        //Move right
        movedKing = board.move(new Cell(-1,0), new Cell(0,0));
        assertThat(movedKing, is(board.getFigure(new Cell(0,0))));
        //Move top
        movedKing = board.move(new Cell(0,0), new Cell(0,1));
        assertThat(movedKing, is(board.getFigure(new Cell(0,1))));
        //Move bottom
        movedKing = board.move(new Cell(0,1), new Cell(0,0));
        assertThat(movedKing, is(board.getFigure(new Cell(0,0))));

        //Try move king more then one cell
        try {
            board.move(new Cell(0,0), new Cell(0,2));
        } catch (ImpossibleMoveException e) {
            System.out.println("Test King ImpossibleMoveException long move to 0 2");
        }
    }

    @Test
    public void whenFigureIsRookPutItOnBoardAndMove() {
        Board board = new Board();
        Rook rook = new Rook(new Cell(0,0));
        board.addFigure(rook);

        //Move left
        Figure movedRook = board.move(new Cell(0,0), new Cell(-3,0));
        assertThat(movedRook, is(board.getFigure(new Cell(-3,0))));
        //Move right
        movedRook = board.move(new Cell(-3,0), new Cell(0,0));
        assertThat(movedRook, is(board.getFigure(new Cell(0,0))));
        //Move top
        movedRook = board.move(new Cell(0,0), new Cell(0,4));
        assertThat(movedRook, is(board.getFigure(new Cell(0,4))));
        //Move bottom
        movedRook = board.move(new Cell(0,4), new Cell(0,0));
        assertThat(movedRook, is(board.getFigure(new Cell(0,0))));

        //Try move Rook diagonally
        try {
            board.move(new Cell(0,0), new Cell(-5,-5));
        } catch (ImpossibleMoveException e) {
            assertThat(e.getMessage(), is("Can't move in diagonally."));
        }
    }

    @Test
    public void whenTestBoardExceptions() {
        Board board = new Board();
        Queen queen = new Queen(new Cell(0,0));
        board.addFigure(queen);

        try {
            board.move(new Cell(0,0), new Cell(0,0));
        } catch (ImpossibleMoveException e) {
            assertThat(e.getMessage(), is("Can't move to the same cell."));
        }

        try {
            board.move(new Cell(1,1), new Cell(3,3));
        } catch (FigureNotFoundException e) {
            assertThat(e.getMessage(), is("Can't find figure on current cell"));
        }

        Rook rook = new Rook(new Cell(0,2));
        board.addFigure(rook);

        try {
            board.move(new Cell(0,2), new Cell(0,-2));
        } catch (OccupiedWayException e) {
            assertThat(e.getMessage(), is("Cell on the way is occupied"));
        }

        Pawn pawn = new Pawn(new Cell(3,1));
        board.addFigure(pawn);

        pawn = new Pawn(new Cell(4,1));
        board.addFigure(pawn);

        try {
            pawn = new Pawn(new Cell(5,1));
            board.addFigure(pawn);
        } catch (AllFiguresAreSetException e) {
            assertThat(e.getMessage(), is("Can't add move figures on board"));
        }
    }
}