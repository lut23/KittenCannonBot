package artificalAnt

import spock.lang.Specification;


class sizeTest extends Specification {
  def 'magic unicorns test size I do not know'(){
	  	when: 
		  def tree = new GPTree()
		  def tree2 = new GPTree()
		  tree.head = new RightNode()
		  tree2.head = new DoNode()
		  tree2.head.setChild1(new DoNode())
		  tree2.head.child1.setChild1(new RightNode())
		  tree2.head.child1.setChild2(new LeftNode())
		  tree2.head.setChild2(new LeftNode())
		  
		  then:
		  tree.size() == 1
		  tree2.size() == 5
  }
  
  def 'size test a specific point'(){
	  when:
	  def tree = new GPTree()
	  def tree2 = new GPTree()
	  tree.head = new RightNode()
	  tree2.head = new DoNode()
	  tree2.head.setChild1(new DoNode())
	  tree2.head.child1.setChild1(new RightNode())
	  tree2.head.child1.setChild2(new LeftNode())
	  tree2.head.setChild2(new LeftNode())
	  
	  then:
	  tree.size() == 1
	  tree2.size() == 5
	  tree2.size(tree2.getHead().getChild1()) == 3
  }
}
