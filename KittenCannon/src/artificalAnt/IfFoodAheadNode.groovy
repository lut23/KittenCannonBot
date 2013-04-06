package artificalAnt

class IfFoodAheadNode {
	
	def ifFoodAheadNode
	def child1
	def child2
	def parent
    def childId  // distinguish which child a node is, if its a child1 or child2 node
	def numbChildren(){
		return 2
	}
	def getChild1(){
		return child1
	}
	def getChild2(){
		return child2
	}
	def setChild1(node){
		child1 = node
        node.setChildId(1)
	}
	def setChild2(node){
		child2 = node
        node.setChildId(2)
	}
    def setChildId(number){
        childId = number
    }
	def setParent(node){
		parent = node
	}

	def lookForFood(ant, antBoard){
		def tempCoord = ant.getCoordinate()
		def tempX = tempCoord[1]
		def tempY = tempCoord[0]
		def tempSize = antBoard.size()

		if(ant.getDirection() == 1){
			if(tempY-1 < 0){
				
				antBoard.lookAtCoordinate((tempSize-tempY)-1, tempX) == 1
					
			}
			else{
				
				antBoard.lookAtCoordinate(tempY-1, tempX)==1
					
			}

		}

		else if(ant.getDirection() == 2){
			if(tempX+1 >= tempSize){
				
				antBoard.lookAtCoordinate(tempY, tempSize-tempX)==1
					
				}
			
			else{
				
				antBoard.lookAtCoordinate(tempY, tempX+1) == 1
					
				
			}

		}

		else if(ant.getDirection() == 3){
			if(tempY+1 > tempSize-1){
				def result = (tempSize-tempY)-1

				
				antBoard.lookAtCoordinate(result, tempX) == 1
					
				}
			
			else{
				
				antBoard.lookAtCoordinate(tempY+1,tempX) == 1
					
			}

		}

		else if(ant.getDirection() == 4){
			if(tempX-1 < 0){
				
				antBoard.lookAtCoordinate(tempY, tempSize+tempX-1) == 1
					
			}
			else{
				
				antBoard.lookAtCoordinate(tempY, tempX-1) == 1
					
			}
		}

	}
	
}
