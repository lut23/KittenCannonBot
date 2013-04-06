package artificalAnt

class Problem {

	def create(){
		def tree = new GPTree()
		tree.create()
	}
	def quality(individual){
		individual.quality()
	}
	def terminate(best, qualityOfBest){
		if(qualityBest == 15 || best.ant.steps == 400){
			return true
		}else{
		return false
		}
	}
}
