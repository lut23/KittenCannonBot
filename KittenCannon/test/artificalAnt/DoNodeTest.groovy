package artificalAnt

import spock.lang.Specification;

class DoNodeTest extends Specification{
	def do1 = new DoNode()
	
	def "number of children is 2"(){
		expect:
		do1.numbChildren() == 2
	}

}
