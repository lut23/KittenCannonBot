package artificalAnt

import spock.lang.Specification;

class ParentTest extends Specification{
	
	def do1 = new DoNode()

	
	def "find parent at root"(){
		when:
		def superTree = new GPTree()
		superTree.head = new DoNode()
		superTree.head.setChild1(new DoNode())
		superTree.head.child1.setChild1(new RightNode())
		superTree.head.child1.setChild2(new LeftNode())
		superTree.head.setChild2(new ForwardNode())
		
		
		then:
		superTree.getNode(0) instanceof DoNode
		superTree.getNode(1) instanceof DoNode
		superTree.getNode(2) instanceof RightNode
		
	}
	
	def "get node at point"(){
		when:
		def tree = new GPTree()
		tree.head = new DoNode()
		tree.head.setChild1(new DoNode())
		tree.head.child1.setChild1(new RightNode())
		tree.head.child1.setChild2(new LeftNode())
		tree.head.setChild2(new ForwardNode())
		
		then:
		tree.getNode(1) instanceof DoNode
	}
	
	def 'right node is head'(){
		when:
		def tree = new GPTree()
		tree.head = new RightNode()
		
		then:
		println"right node is head"
		tree.getNode(0) instanceof RightNode
	}
	
}
