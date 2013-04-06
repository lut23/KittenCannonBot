package artificalAnt
import java.util.Random

class GPTree {

  
	def max = 1200   
	def ant = new Ant()
	def antBoard = new TrailBoard()
    def returningNode   // variable for storing a node for the returnNode() function
    def nodeCounter     
    def trees           // variable for

	def rand = new Random()
	def head = null

	def getHead(){
		return head
	}

	def setHead(node){
		head = node
	}

	def getMax(){
		return max
	}

	def create(){

		grow(1, max, head)
	}
/* Determines quality of a tree possibly decrease quality for too many steps*/
	def quality(){
		run()
		def pels = ant.pellets
		//def steps = ant.steps
		return pels
	}
/* stops a GA run when an individual as reached the best case or specified limit*/
	def terminate(best, qualityOfBest){
		if(qualityOfBest == 15 || best.ant.steps == 400){
			return true
		}else{
			return false
		}
	}
/*  resets ant and board to run the tree*/
	def run(){
		antBoard.initialize(32)
		antBoard.reset()
		ant.reset()
		runEverything(head)
	}
  /* Recursively goes through tree and runs */
	def runEverything(node){
			if(node instanceof RightNode){
				node.turn(ant)
				if(head == node){
					return
				}
			}
			else if(node instanceof LeftNode){
				node.turn(ant)
				if(head == node){
					return
				}
			}
			else if(node instanceof ForwardNode){
				node.moveForward(ant, antBoard)

			}
			else if(node instanceof IfFoodAheadNode){
				def result = node.lookForFood(ant, antBoard)
				if(result){
					runEverything(node.getChild1())
				}else{
					runEverything(node.getChild2())
				}
			}
			else if(node instanceof DoNode){
				runEverything(node.getChild1())
				runEverything(node.getChild2())
			}
	}

	def counter = 0 // what is this for? do we need it anymore?
/* recursively prints tree*/
	def printTree(node){
		if(node == null){
			println "null node"
			return
		}
		if (counter > max){
			return
		}
		if(node instanceof RightNode){
			println"Right_Turn"
			counter++
		}
		else if(node instanceof LeftNode){
			println"Left_Turn"
			counter++
		}
		else if(node instanceof ForwardNode){
			println "Move_Forward"
			counter++
		}
		else if(node instanceof IfFoodAheadNode){
			println "If_Food_Ahead"
			counter++
			printTree(node.getChild1())
			printTree(node.getChild2())

		}
		else if(node instanceof DoNode){
			println "Do_Node"
			counter++
			printTree(node.getChild1())
			printTree(node.getChild2())

		}
	}
	def size = 0
	def size(node=head){
		size = 0
		calcSize(node)
		return size
	}

	def calcSize(node){
		if((node instanceof DoNode) || (node instanceof IfFoodAheadNode)) {

			size+= 1

			calcSize(node.getChild1())
			calcSize(node.getChild2())
		}
		else{
			size += 1
			return
		}
	}

	def grow(depth, max, node){
		def randFunc
		def Do = new DoNode()
		def left = new LeftNode()
		def right = new RightNode()
		def forward = new ForwardNode()
		def ifFood = new IfFoodAheadNode()
		def functionSet = [ifFood,Do,left,right,forward]

		if(depth >= max){
			def rand1 = functionSet[rand.nextInt(5)]

			if(rand1 instanceof DoNode || rand1 instanceof IfFoodAheadNode){
				rand1 = functionSet[rand.nextInt(3)+2]
			}

			return rand1
		}
		else{
			if (head == null ){

				head = functionSet[rand.nextInt(5)]
				if(head.numbChildren() == 0) return head
				randFunc = head
			}
			else {

				randFunc = functionSet[rand.nextInt(5)]

			}
			randFunc.parent = node
			def arity = 0
			arity = randFunc.numbChildren()
			if(arity != 0){
				randFunc.setChild1(grow(depth+1, max, randFunc))
				randFunc.setChild2(grow(depth+1, max, randFunc))
			}

			return randFunc
		}
	}
    
	
    /* recurses through tree and returns a node by a depth first number*/
	def returnNode(nodeNumber){
		getNode(nodeNumber)
		return returningNode
	}
	def getNode(nodeNumber){  /* need this method otherwise returningNode seems to be null*/
		nodeCounter = 0
		returningNode = null
		nodeThing(head, nodeNumber)
		return returningNode
	}
	def nodeThing(node, number)	{

		if(nodeCounter.equals(number)){
			returningNode = node
			return
		}else{
			if((node instanceof DoNode) || (node instanceof IfFoodAheadNode)) {

				nodeCounter+= 1

				nodeThing(node.getChild1(), number)

				nodeCounter+= 1

				nodeThing(node.getChild2(), number)
			}
			else{
				return
			}
		}

	}
/* clones a tree */
	def clone(){
		def tree = new GPTree()
		recurseClone(tree.getHead(),head)
		tree.head = trees
		return tree
	}
	def cloneNode(node){
		def clone
		if(node instanceof RightNode){
			clone = new RightNode()
		}
		else if(node instanceof LeftNode){
			clone = new LeftNode()
		}
		else if(node instanceof ForwardNode){
			clone = new ForwardNode()
		}
		else if(node instanceof DoNode){

			clone = new DoNode()
		}
		else if(node instanceof IfFoodAheadNode){

			clone = new IfFoodAheadNode()
		}
		return clone
	}
	def recurseClone(treeNode,node){

		if(node == head){
			treeNode = cloneNode(head)
			trees = treeNode
		}
		if((node instanceof DoNode) || (node instanceof IfFoodAheadNode)) {

			treeNode.setChild1(cloneNode(node.getChild1()))
			treeNode.child1.parent = treeNode
			recurseClone(treeNode.getChild1(),node.getChild1())


			treeNode.setChild2(cloneNode(node.getChild2()))
			treeNode.child2.parent = treeNode
			recurseClone(treeNode.getChild2(),node.getChild2())
		}

	}
        /* not sure if we need this anymore*/
//	def printChildren(node){
//		if(node instanceof DoNode || node instanceof IfFoodAheadNode){
//			if(node == node.getChild1() || node == node.getChild2()){
//				println "Problem"
//				return
//			}
//
//			printChildren(node.getChild1())
//			printChildren(node.getChild2())
//		}
//		else println "This is the end of " + node
//	}

}



