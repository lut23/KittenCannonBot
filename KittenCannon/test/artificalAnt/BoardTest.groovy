package artificalAnt

import spock.lang.Specification;

class BoardTest extends Specification {
	
	def ant1 = new Ant()
	def board1 = new TrailBoard()
	def board2 = new AntBoard()
	
	def "check board"(){
		when:
		board1.initialize(32)
		board2.initialize(26)
		
		then:
		board1.size() == 32
		board2.size() == 26
		board1.lookAtCoordinate(0,1) == 1
	}
	
	def "look at coordinates"(){
		when:
		board1.initialize(32)
		
		then:
		board1.lookAtCoordinate(0, 1) == 1
	}
	def "change 1 to zero"(){
		when:
		board1.initialize(32)
		board1.removePellet(1, 0)
		
		then:
		board1.lookAtCoordinate(1, 0) == 0
		
	}

}
