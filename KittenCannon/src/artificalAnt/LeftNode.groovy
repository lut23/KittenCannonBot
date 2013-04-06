package artificalAnt

class LeftNode {
	
	def leftNode
	def parent
    def childId  // distinguish which child a node is, if its a child1 or child2 node
	def numbChildren(){
		return 0
	}
	
	def turn(ant){
		ant.setDirection(ant.getDirection()-1)
	}
    def setChildId(number){
        childId = number
    }
	def setParent(node){
		parent = node
	}


}
