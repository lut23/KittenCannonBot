package artificalAnt

import spock.lang.Specification;

class AntCrossoverTest  extends Specification {
    
    def 'test child node knows which child it is'(){
        when:
        def tree = new GPTree()
        tree.head = new DoNode()
        tree.head.setChild1(new IfFoodAheadNode())
        tree.head.child1.setChild1(new LeftNode())
        tree.head.child1.setChild2(new ForwardNode())
        tree.head.setChild2(new RightNode())
        
        then:
        tree.head.child1.childId == 1
        tree.head.child2.childId == 2
        tree.head.child1.child1.childId == 1
        tree.head.child1.child2.childId == 2
    }
    
    def'test get node'(){
        when:
        def tree = new GPTree()
        tree.head = new DoNode()
        tree.head.setChild1(new IfFoodAheadNode())
        tree.head.child1.setChild1(new LeftNode())
        tree.head.child1.setChild2(new ForwardNode())
        tree.head.setChild2(new RightNode())
		def k = tree.returnNode(0)
        def a = tree.returnNode(1)
        def b = tree.returnNode(2)
        def c = tree.returnNode(3)
        def d = tree.returnNode(4)
        
        then:
        tree.head instanceof DoNode
        tree.head.child1 instanceof IfFoodAheadNode
        tree.head.child2 instanceof RightNode
        tree.head.child1.child1 instanceof LeftNode
        tree.head.child1.child2 instanceof ForwardNode
        //tree.getNode(0) instanceof DoNode
        a instanceof IfFoodAheadNode
        b instanceof LeftNode
        c instanceof ForwardNode
        d instanceof RightNode
		k instanceof DoNode
        }
	def "test crossover same size"(){
		when:
		//must set size
		def tree = new GPTree()
		tree.head = new DoNode()
		tree.head.setChild1(new LeftNode())
		tree.head.setChild2(new ForwardNode())
		tree.size = 1
		
		def tree2 = new GPTree()
		tree2.head = new IfFoodAheadNode()
		tree2.head.setChild1(new RightNode())
		tree2.head.setChild2(new LeftNode())
		tree2.size = 1
		
		def cross = new AntCrossover()
		def children = cross.crossover(tree, tree2)
		
		then:
		children[0].head instanceof IfFoodAheadNode
		children[1].head instanceof DoNode
	}
	def "test crossover"(){
		when:
		def tree = new GPTree()
		tree.head = new DoNode()
		tree.head.setChild1(new IfFoodAheadNode())
		tree.head.child1.setChild1(new LeftNode())
		tree.head.child1.setChild2(new ForwardNode())
		tree.head.setChild2(new RightNode())
		tree.size = 5
		def tree2 = new GPTree()
		tree2.head = new LeftNode()
		tree2.size = 1
		def cross = new AntCrossover()
		def children = cross.crossover(tree, tree2)
		
		
		then:
		children[0].head instanceof LeftNode
		children[1].head instanceof DoNode
		children[1].head.child1 instanceof IfFoodAheadNode
		
	}
    

}
