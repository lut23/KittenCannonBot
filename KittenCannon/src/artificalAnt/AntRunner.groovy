package artificalAnt
import populationMethods.GeneticAlgorithm
class AntRunner {
	
	public static void main(String [] args) {
	def cross = new AntCrossover()
//		def newTrees 
//       def forest = []
//		for(int i = 0 ; i<1000 ; i++){
//            forest.add(new GPTree())
//       }
//        for(tree in forest){
//            tree.create()
//        }
//		for(int j =0 ; j < 999 ; j++){
//			//forest[j].printTree(forest[j].head)
//			//println ""
//			cross.crossover(forest[j], forest[j+1])
//		}
		def algorithm = new GeneticAlgorithm()
		
		def tree = new Problem()
		
		
		def coolBest = algorithm.maximize(problem: tree, crossover: cross)
		println coolBest[0].quality()
		println algorithm.toString()
        println 'size ${coolBest[0].size()}'
        println coolBest[1]
		//coolBest.printTree(coolBest.getHead())

	}
}
