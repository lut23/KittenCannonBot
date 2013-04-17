package roboTree
 import applications.robocode.*
import spock.lang.Specification;

class BuildRobot extends Specification {
    def"absolute"(){
    when:
    def values
    def robotBuilder = new RobotBuilder("templates/Leopard.template")
    def battleRunner= new BattleRunner("templates/battle.template")
    def tree = new RoboTree()
    tree.create()
    def id = 12321
    values = ["id" : id, "new_angle": tree.treeToString()]
    
   robotBuilder.buildJarFile(values)
   battleRunner.buildBattleFile(id)
   def score = battleRunner.runBattle(id)
   then: 
   score >=0
   
   
    }
    
    
    
    
    
    
   
}
