package roboTree
 import applications.robocode.*
import spock.lang.Specification;

class BuildRobot extends Specification {
    def"absolute"(){
    when:
    def values
    def robotBuilder = new RobotBuilder("templates/Leopard.template")
    def battleRunner= new BattleRunner("templates/battle.template")
    def id = 2141
    values = ["id" : id, "new_angle": 'e.getBearingRadians()']
    
   robotBuilder.buildJarFile(values)
   battleRunner.buildBattleFile(id)
   def score = battleRunner.runBattle(id)
   then: 
   score >=0
   
   
    }
    
    
    
    
    
    
   
}
