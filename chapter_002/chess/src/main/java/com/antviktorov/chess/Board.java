package com.antviktorov.chess;

import com.antviktorov.chess.exceptions.AllFiguresAreSetException;
import com.antviktorov.chess.exceptions.FigureNotFoundException;
import com.antviktorov.chess.exceptions.ImpossibleMoveException;
import com.antviktorov.chess.exceptions.OccupiedWayException;
import com.antviktorov.chess.figures.Figure;

/**
 * Board class.
 * @author antonviktorov
 * @since 1.0
 */
public class Board {
    /**
     * Figures on board.
     * 32 really
     */
    protected Figure[] figures = new Figure[4];
    /**
     * Current figure position to add.
     */
    protected int position = 0;

    /**
     * Add figure to board.
     * @param figure - figure instance
     * @throws AllFiguresAreSetException
     */
    public void addFigure(Figure figure) throws AllFiguresAreSetException {
        if (this.position == figures.length) {
            throw new AllFiguresAreSetException("Can't add move figures on board");
        }
        figures[this.position++] = figure;
    }

    /**
     * Get figure on position.
     * @param position - position to check
     * @return figure instance
     * @throws FigureNotFoundException
     */
    public Figure getFigure(Cell position) throws FigureNotFoundException {
        for (Figure figure : this.figures) {
            if (figure == null) {
                break;
            }
            if (figure.isHere(position)) {
                return figure;
            }
        }

        throw new FigureNotFoundException("Can't find figure on current cell");
    }

    /**
     * Move figure from current to destination.
     * @param current - current figure position
     * @param destination - new figure position
     * @return figure instance (if moved)
     * @throws ImpossibleMoveException
     * @throws OccupiedWayException
     * @throws FigureNotFoundException
     */
    public Figure move(Cell current, Cell destination) throws ImpossibleMoveException,
            OccupiedWayException, FigureNotFoundException {
        if (current.equals(destination)) {
            throw new ImpossibleMoveException("Can't move to the same cell.");
        }
        Figure needle = null;
        int i = 0;
        for (Figure figure : this.figures) {
            if (figure == null) {
                break;
            }
            if (figure.isHere(current)) {
                needle = figure;
                break;
            }
            i++;
        }

        if (needle == null) {
            throw new FigureNotFoundException("Can't find figure on current cell");
        }

        Cell[] way = needle.way(destination);

        for (Figure figure : this.figures) {
            if (figure == null) {
                break;
            }
            for (Cell cell : way) {
                if (figure.isHere(cell)) {
                    throw new OccupiedWayException("Cell on the way is occupied");
                }
            }
        }

        Cell last = way[way.length - 1];

        if (last.equals(destination)) {
            this.figures[i] = needle.clone(destination);
        } else {
            throw new ImpossibleMoveException("Weird situation... Bug!");
        }

        return this.figures[i];
    }
}
