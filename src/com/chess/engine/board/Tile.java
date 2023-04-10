package com.chess.engine.board;

import java.util.HashMap;
import java.util.Map;

import com.chess.engine.Piece.Piece;
import com.google.common.collect.ImmutableMap;

public abstract class Tile {
	
	protected final int tileCoordinate;
	private static final Map<Integer,EmptyTile> EMPTY_TILES_CACHE = createAllPossibleEmptyTiles();
	
	Tile(final int tileCoordinate) {
		this.tileCoordinate = tileCoordinate;
	}
	
	public abstract boolean isTileOccupied();
	public abstract Piece getPiece();
	
	private static Map<Integer, EmptyTile> createAllPossibleEmptyTiles() {
		final Map<Integer, EmptyTile> emptyTileMap = new HashMap<>();
		
		for(int i = 0; i < BoardUtils.NUM_TILES; i++) {
			emptyTileMap.put(i, new EmptyTile(i));
		}
		
		return ImmutableMap.copyOf(emptyTileMap);
	}

	public static final class EmptyTile extends Tile {
		EmptyTile(final int coordinate) {
			super(coordinate);
		}
		
		@Override
		public boolean isTileOccupied() {
			return false;
		}
		
		@Override
		public Piece getPiece() {
			return null;
		}
		
		public static final class OccupiedTile extends Tile {
			private final Piece pieceOnTile;
			
			OccupiedTile(int titleCoordinate, final Piece pieceOnTile){
				super(titleCoordinate);
				this.pieceOnTile = pieceOnTile;
			}
				@Override
				public boolean isTileOccupied() {
					return true;
				}
				
				@Override
				public Piece getPiece() {
					return this.pieceOnTile;
				}
		}
	}
}
