package artificalAnt

class DoNode {
	
	def child1
	def child2
	def parent
    def childId
	def numbChildren(){
		return 2
	}
	def setChild1(node){
		child1 = node
        node.setChildId(1)
	}
	def setChild2(node){
		child2 = node
        node.setChildId(2)
	}
	
	def getChild1(){
		return child1
	}
	def getChild2(){
		return child2
	}
	def setChildId(number){
        childId = number
    }
	def setParent(node){
		parent = node
	}

}
