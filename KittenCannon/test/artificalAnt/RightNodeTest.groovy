package artificalAnt

import spock.lang.Specification;

class RightNodeTest extends Specification{
	
	def ant1 = new Ant()
	def right = new RightNode()
	
	def "Turn right"(){
		when:
		right.turn(ant1)
		
		then:
		ant1.getDirection() == 3
	}
	
	def "Number of Children is 0"(){
		expect:
		right.numbChildren() == 0
	}

}
