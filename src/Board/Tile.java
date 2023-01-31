package Board;

public abstract class Tile {
	//Created
	int tileCoordinate;
	
	Tile(int tileCoordinate) {
		this.tileCoordinate = tileCoordinate;
	}
	
	public abstract boolean isTileOccupied();
	
	public abstract Piece getPiece();
	
	public static final class EmptyTile extends Tile {
		EmptyTile(int coordinate) {
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
			Piece pieceOnTile;
			
			OccupiedTile(int titleCoordinate, Piece pieceOnTile){
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
