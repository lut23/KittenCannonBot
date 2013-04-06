package artificalAnt

class TrailBoard {
	
//	public static void main(String [] args) {
//		
//		def trail = new TrailBoard()
//		trail.initialize(15)
//		trail.printAntBoard()
//		println trail.lookAtCoordinate(1, 0)
//		trail.removePellet(1, 0)
//		println trail.lookAtCoordinate(1, 0)
//		
//
//	}
		
	def board
	def size
	

	@Override
	def size(){
		return size
	}
	
	def initialize(size1){
		board = new int[size1][size1]
		size = size1
		for (int i = 0; i < size1; i++){
			for(int j = 0; j < size1; j++){
				board[i][j] = 0
			}
		}
		setPellets(board)
	}
	
	def removePellet(x, y){
		board[x][y] = 0
	}
	
	def lookAtCoordinate(x, y){
		return board[x][y]
	}

	def reset(){
		 return setPellets(board)
	}

	private static void setPellets(int [][] antBoard){
		antBoard[0][1] = 1
		antBoard[0][2] = 1
		antBoard[0][3] = 1
		antBoard[1][3] = 1
		antBoard[1][4] = 1
		antBoard[1][5] = 1
		antBoard[1][6] = 1
		antBoard[2][6] = 1
		antBoard[3][6] = 1
		antBoard[4][6] = 1
		antBoard[5][6] = 1
		antBoard[5][7] = 1
		antBoard[5][8] = 1
		antBoard[5][9] = 1
		antBoard[5][10] = 1
	}

	def printAntBoard() {
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				print (board [i] [j])
			}
			println()
		}
	}

}


