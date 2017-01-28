package com.antviktorov.chess.figures.moves;

import com.antviktorov.chess.Cell;
import com.antviktorov.chess.exceptions.ImpossibleMoveException;

/**
 * Move interface.
 */
public interface Move {
     /**
      * Move figure.
      * @param destination - new destination
      * @return way
      * @throws ImpossibleMoveException
      */
     Cell[] move(Cell destination) throws ImpossibleMoveException;
}
