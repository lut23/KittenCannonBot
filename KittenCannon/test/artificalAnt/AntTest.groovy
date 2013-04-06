package artificalAnt


import spock.lang.Specification;

class AntTest extends Specification {
	
	def ant1 = new Ant()
	
	def "starting postion is 0,0"(){
		expect:
		ant1.getCoordinate() == [0,0]
	}
	
	def "starting direction is 2"(){
		expect:
		ant1.getDirection() == 2
	}
	
	def "change direction"(){
		expect:
		ant1.setDirection(3)
		ant1.getDirection() == 3
		ant1.getDirection() != 2
	}
	
	def "change coordinates"(){
		when:
		ant1.setCoordinate(0,1)
		
		then:
		
		ant1.getCoordinate() == [0,1]
	}
	def "change coordinates 2"(){
		when:
		ant1.setCoordinate(5,3)
		
		then:
		
		ant1.getCoordinate() == [5,3]
	}

}
