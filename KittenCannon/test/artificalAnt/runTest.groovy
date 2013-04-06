package artificalAnt

import spock.lang.Specification;

class runTest extends Specification {

   def ' test with forward node as head'(){
       when:
       def tree = new GPTree()
       tree.head = new ForwardNode()
       tree.run()
       
       then:
       tree.quality() == 1
   }
   def ' add to array list'(){
	   when:
	   def list = []
	   def problem = new Problem()
	   list.add(problem.create())
	   
	   then:
	   list.size() == 1
	   println list
   }
}
