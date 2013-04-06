package artificalAnt

class AntBoard {
//	public static void main(String [] args) {
//		def antBoard = new AntBoard()
//		antBoard.initialize(32)
//
//		antBoard.printAntBoard()
//		println antBoard.size()
//
//}
	
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



	def setPellets(int [][] antBoard){
		def tempSize = antBoard.size()
		Random rand = new Random()
		int k = 0
		for(k = 0; k < 100; k++){
			int place1 = rand.nextInt(tempSize)
			int place2 = rand.nextInt(tempSize)
			if(antBoard[place1][place2] == 1){
				k--
			}
			else{
				antBoard[place1][place2] = 1
			}
		}
	}
	
	def removePellet(x, y){
		board[x][y] = 0		
	}
	
	def lookAtCoordinate(x, y){
		return board[x][y]
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
