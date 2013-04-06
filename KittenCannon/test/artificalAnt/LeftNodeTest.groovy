package artificalAnt

import spock.lang.Specification;

class LeftNodeTest extends Specification{
	
	def ant1 = new Ant()
	def left = new LeftNode()
	
	def "Turn left"(){
		when:
		left.turn(ant1)
		
		then:
		ant1.getDirection() == 1
	}
	
	def "Number of Children is 0"(){
		expect:
		left.numbChildren() == 0
	}


}
