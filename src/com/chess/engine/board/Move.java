package com.chess.engine.board;

import com.chess.engine.Piece.Piece;

public abstract class Move {
	final Board board;
	final Piece movePiece;
	final int destinationCoordinate;
	
	private Move(final Board board,
			final Piece movePiece,
			final int destinationCoordinate) {
		this.board = board;
		this.movePiece = movePiece;
		this.destinationCoordinate = destinationCoordinate;
	}
	
	public static final class MajorMove extends Move {

		public MajorMove(final Board board, final Piece movePiece, final int destinationCoordinate) {
			super(board, movePiece, destinationCoordinate);
		}

		@Override
		public Board execute() {
			return null;
		}
	}
	
	public static final class AttackMove extends Move {
		final Piece attackedPiece;
		
		public AttackMove(final Board board, final Piece movePiece, final int destinationCoordinate, final Piece attackedPiece) {
			super(board, movePiece, destinationCoordinate);
			this.attackedPiece = attackedPiece;
		}

		@Override
		public Board execute() {
			return null;
		}
	}

	public int getDestinationCoordinate() {
		return this.destinationCoordinate;
	}

	public abstract Board execute();
}
