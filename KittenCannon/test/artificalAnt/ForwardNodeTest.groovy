package artificalAnt

import spock.lang.Specification;

class ForwardNodeTest extends Specification{
	def forward = new ForwardNode()
	def ant1 = new Ant()
	def board1 = new TrailBoard()
	
	def "check board"(){
		when:		
		board1.initialize(15)
		
		then:
		board1.size() == 15
		board1.lookAtCoordinate(0,1) == 1
	}
	
	def "go forward"(){
		when:
		board1.initialize(15)
		forward.moveForward(ant1, board1)
		
		then:
		ant1.pellets == 1
		ant1.steps == 1
		ant1.getCoordinate() == [0, 1]
		board1.lookAtCoordinate(0,1) == 0
	}
	
	def "go off board 4"(){
		when:
		board1.initialize(15)
		ant1.setDirection(4)
		forward.moveForward(ant1, board1)
		forward.moveForward(ant1, board1)
		
		
		then:
		ant1.getCoordinate() == [0,13]
	}
		
	def ' go off board 3'(){
		when:
		board1.initialize(15)
		ant1.setDirection(3)
		ant1.setCoordinate(14,0)
		forward.moveForward(ant1, board1)
		
		
		then:
		ant1.getCoordinate() == [0,0]
	}
		
	def ' go off board 2'(){
		when:
		board1.initialize(15)
		ant1.setDirection(2)
		forward.moveForward(ant1, board1)
		forward.moveForward(ant1, board1)
		
		then:
		ant1.getCoordinate() == [0,2]
	}
	
	def ' go off board 1'(){
		when:
		board1.initialize(15)
		ant1.setDirection(1)
		forward.moveForward(ant1, board1)
		forward.moveForward(ant1, board1)
		
		then:
		ant1.getCoordinate() == [13,0]
		ant1.pellets == 0
	}

	

}
