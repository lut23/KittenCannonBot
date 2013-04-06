package artificalAnt

import spock.lang.Specification;

class CloneTest  extends Specification  {

		def "clone with tree size 1"(){
			when:
			def cloneTree
			def tree = new GPTree()
			tree.head = new LeftNode()
			cloneTree = tree.clone()
			then:
			cloneTree.head instanceof LeftNode
			cloneTree.head != tree.head
		}
		
		def "clone with bigger size"(){
			when:
			def tree = new GPTree()
			tree.head = new DoNode()
			tree.head.setChild1(new IfFoodAheadNode())
			tree.head.child1.setChild1(new LeftNode())
			tree.head.child1.setChild2(new ForwardNode())
			tree.head.setChild2(new RightNode())
			def cloneTree = tree.clone()
			
			then:
			cloneTree.head instanceof DoNode
			cloneTree.head.child1 instanceof IfFoodAheadNode
			cloneTree.head != tree.head
			cloneTree.head.child1 != tree.head.child1
		}
}
