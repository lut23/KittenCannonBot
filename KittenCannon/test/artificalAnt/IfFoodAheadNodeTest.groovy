package artificalAnt

import spock.lang.Specification;

class IfFoodAheadNodeTest extends Specification{
	def ant1 = new Ant()
	def board1 = new TrailBoard()
	def ahead = new IfFoodAheadNode()
	
	def "Food is ahead"(){
		when:
		board1.initialize(32)
				
		then:
		ahead.lookForFood(ant1, board1) == true
		
	}
	
	def "Food is not ahead"(){
		when:
		board1.initialize(32)
		ant1.setDirection(1)
		
		then:
		ahead.lookForFood(ant1, board1) == false
		
	}

}
