package applications.robocode
import roboTree.*
import populationMethods.*
class RoboTreeRunner {
static main(args){
//    def forest = []
//    def robotBuilder
//    def values
//    def battleRunner
//    robotBuilder = new RobotBuilder("templates/Leopard.template")
//    for(int i = 0; i<5;i++){
//        forest.add(new RoboTree())
//        forest[i].create()
//        println forest[i]
//        println forest[i].head
//        println forest[i].treeToString()
//        values = ["id" : i, "new_angle": forest[i].treeToString()]
//            
//           robotBuilder.buildJarFile(values)
//           battleRunner = new BattleRunner("templates/battle.template")
//           battleRunner.buildBattleFile(i)
//          println"robot ${i} ${battleRunner.runBattle(i)}"
    def algorithm = new GeneticAlgorithm()
    def tree = new RoboCodeProblem()
  
    
    
    def coolBest = algorithm.maximize(problem: tree)
    println coolBest[0].quality()
    println algorithm.toString()
    println 'size ${coolBest[0].size()}'
    println coolBest[1]
    }
    
   

}
