package artificalAnt

class ForwardNode {
	def parent
	def childId
	def setParent(node){
		parent = node
	}

	def moveForward(ant, antBoard){

		ant.steps++
		def childId  // distinguish which child a node is, if its a child1 or child2 node
		def tempCoord = ant.getCoordinate()
		def tempX = tempCoord[1]
		def tempY = tempCoord[0]
		def tempSize = antBoard.size()

		if(ant.getDirection() == 1){
			if(tempY-1 < 0){
				ant.setCoordinate((tempSize-tempY)-1, tempX)
				if(antBoard.lookAtCoordinate((tempSize-tempY)-1, tempX) == 1){
					ant.pellets++
					antBoard.removePellet((tempSize-tempY)-1, tempX)
				}
			}
			else{
				ant.setCoordinate(tempY-1, tempX )
				if(antBoard.lookAtCoordinate(tempY-1, tempX)==1){
					ant.pellets++
					antBoard.removePellet(tempY-1, tempX)
				}
			}

		}

		else if(ant.getDirection() == 2){
			if(tempX+1 >= tempSize){
				ant.setCoordinate(tempY, tempSize-tempX)
				if(antBoard.lookAtCoordinate(tempY, tempSize-tempX)==1){
					ant.pellets++
					antBoard.removePellet(tempY, tempSize-tempX)
				}
			}
			else{
				ant.setCoordinate(tempY, tempX+1)
				if(antBoard.lookAtCoordinate(tempY, tempX+1) == 1){
					ant.pellets++
					antBoard.removePellet(tempY, tempX+1)
				}
			}

		}

		else if(ant.getDirection() == 3){
			if(tempY+1 > tempSize-1){
				def result = (tempSize-tempY)-1

				ant.setCoordinate(result, tempX)
				if(antBoard.lookAtCoordinate(result, tempX) == 1){
					ant.pellets++
					antBoard.removePellet(result, tempX)
				}
			}
			else{
				ant.setCoordinate(tempY+1,tempX)
				if(antBoard.lookAtCoordinate(tempY+1,tempX) == 1){
					ant.pellets++
					antBoard.removePellet(tempY+1,tempX)
				}
			}

		}

		else if(ant.getDirection() == 4){
			if(tempX-1 < 0){
				ant.setCoordinate(tempY,tempSize+tempX-1)
				if(antBoard.lookAtCoordinate(tempY, tempSize+tempX-1) == 1){
					ant.pellets++
					antBoard.removePellet(tempY, tempSize+tempX-1)
				}
			}
			else{
				ant.setCoordinate(tempY, tempX-1)
				if(antBoard.lookAtCoordinate(tempY, tempX-1) == 1){
					ant.pellets++
					antBoard.removePellet(tempY, tempX-1)
				}
			}
		}

	}

	def numbChildren(){
		return 0
	}
	def setChildId(number){
		childId = number
	}
}
