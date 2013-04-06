package artificalAnt
import java.util.Random
class AntCrossover {
	def rand = new Random()
/* not sure if biggestSize() is needed as long as we use the size of the respective tree in finding a node in that tree*/
	def biggestSize(tree1,tree2){
		def biggestsize
		if(tree1.size() > tree2.size()){
			biggestsize = tree2.size()
		}
		else{biggestsize = tree1.size()}
		return biggestsize
	}

	def crossover(fatherTree, motherTree){
		def dadTree = fatherTree.clone()
		def momTree = motherTree.clone()
		def biggestSize = biggestSize(dadTree,momTree)
		def fatherPoint = 0
		def motherPoint = 0
		if(biggestSize != 0){
			fatherPoint = rand.nextInt(biggestSize)
			motherPoint = rand.nextInt(biggestSize)
		}

		def fatherNode = dadTree.returnNode(fatherPoint)
		def motherNode = momTree.returnNode(motherPoint)
		def grandFather
		def grandMother

		if(fatherPoint == 0){
			grandFather = null
		}
		else{
			grandFather = fatherNode.parent

		}
		if(motherPoint == 0){
			grandMother = null
		}
		else{
			grandMother = motherNode.parent
		}
		if(momTree.getMax() < momTree.size()-momTree.size(motherNode)+dadTree.size(fatherNode)||dadTree.getMax() < dadTree.size()-dadTree.size(fatherNode)+momTree.size(motherNode)){
			return [dadTree,momTree]
		}
        /* case where crossover occurs at the head of the tree*/
		if(fatherPoint == 0 && motherPoint == 0){
			def tempNode = dadTree.head
			dadTree.head = momTree.head
			momTree.head = tempNode
		}
        /* case where crossover occurs at the head of the tree and inside the tree*/
		else if(fatherPoint == 0 && motherPoint != 0){
			def tempFather = fatherNode
			dadTree.head = motherNode
			def tempParent1 = motherNode.parent
			if(tempParent1 instanceof DoNode || tempParent1 instanceof IfFoodAheadNode){
				if(motherNode.childId == 1){
					tempParent1.child1 = fatherNode
					fatherNode.setParent(tempParent1)
					fatherNode.childId = 1
				}else{
					tempParent1.child2 = fatherNode
					fatherNode.setParent(tempParent1)
					fatherNode.childId = 2
				}
			}
			dadTree.head.parent = null
		}
        /* case where crossover occurs at the head of the tree and inside the tree*/
		else if(motherPoint == 0 && fatherPoint != 0){
			def tempMother = motherNode
			momTree.head = fatherNode
			def tempParent1 = fatherNode.parent
			if(tempParent1 instanceof DoNode || tempParent1 instanceof IfFoodAheadNode){
				if(fatherNode.childId == 1){
					tempParent1.child1 = motherNode
					motherNode.setParent(tempParent1)
					motherNode.childId = 1
				}
				else{
					tempParent1.child2 = motherNode
					motherNode.setParent(tempParent1)
					motherNode.childId = 2
				}
			}
			momTree.head.parent = null

		}
        /* case where crossover occurs in the tree */
		else if (motherPoint != 0 && fatherPoint != 0) {
			def tempParent = fatherNode.parent
			def tempParent1 = motherNode.parent

			if(tempParent instanceof DoNode || tempParent instanceof IfFoodAheadNode){
				if(fatherNode.childId == 1){
					tempParent.setChild1(motherNode)
					motherNode.setParent(tempParent)
					motherNode.childId = 1
				}else{
					tempParent.setChild2(motherNode)
					motherNode.setParent(tempParent)
					motherNode.childId = 2
				}
			}

			if( tempParent1 instanceof DoNode || tempParent1 instanceof IfFoodAheadNode){
				if(motherNode.childId == 1){
					tempParent1.setChild1(fatherNode)
					fatherNode.setParent(tempParent1)
					fatherNode.childId = 1
				}else{
					tempParent1.setChild2(fatherNode)
					fatherNode.setParent(tempParent1)
					fatherNode.childId = 2
				}
			}
		}
		return [dadTree,momTree]
	}
}
