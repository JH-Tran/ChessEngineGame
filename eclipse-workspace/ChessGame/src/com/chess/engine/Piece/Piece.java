package com.chess.engine.Piece;

import com.chess.engine.Alliance;
import com.chess.engine.board.Move;

import java.util.List;

public class Piece {
	
	protected final int piecePosition;
	protected final Alliance pieceAlliance;
	
	Piece(final int piecePosition, final Alliance pieceAlliance) {
		this.pieceAlliance = pieceAlliance;
		this.piecePosition = piecePosition;
	}
	
	public abstract List<Move> calculateLegalMoves(final Board board);
}
