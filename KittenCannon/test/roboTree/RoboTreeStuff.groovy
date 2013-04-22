package roboTree

import spock.lang.Specification;

class RoboTreeStuff extends Specification {
    
    def 'size stuff'(){
        when:
        def pine = new RoboTree()
        def tree = new RoboTree()
        tree.head = new AbsoluteNode()
        tree.head.child = new HeadingNode()
        pine.head = new PlusNode()
        pine.head.child = new BearingsNode()
        pine.head.child2 = new VelocityNode()
        then:
        tree.size() == 2
        pine.size() == 3
        
    }
    def 'get stuff'(){
        when:
        def tree = new RoboTree()
        tree.head = new AbsoluteNode()
        tree.head.child = new HeadingNode()
        
        then:
        
        tree.getNode(0) instanceof AbsoluteNode
        tree.getNode(1) instanceof HeadingNode
    }
    def'clone stuff'(){
        when:
        def tree = new RoboTree()
        tree.head = new AbsoluteNode()
        tree.head.child = new HeadingNode()
        def clone = tree.clone()
        
        then:
        clone.head != tree.head
        clone.head instanceof AbsoluteNode
        clone.head.child != tree.head.child
        clone.head.child instanceof HeadingNode
    }
    def 'tree to string stuff'(){
        when:
        def tree = new RoboTree()
        def pine = new RoboTree()
        def fur = new RoboTree()
        tree.head = new AbsoluteNode()
        tree.head.child = new NearAbsoluteNode()
        tree.head.child.child = new RelativeNode()
        tree.head.child.child.child = new BearingsNode()
        def string = tree.treeToString()
        
       
        
        then:
        string == "Utils.normalAbsoluteAngle(Utils.normalNearAbsoluteAngle(Utils.normalRelativeAngle(e.getBearingRadians())))"
    }
    def 'tree with plus and minus stuff'(){
        when:
        def tree = new RoboTree()
        tree.head = new PlusNode()
        tree.head.child = new VelocityNode()
        tree.head.child2 = new HeadingNode()
        def string = tree.treeToString()
        
       
        then:
        string == "(e.getVelocity())+(e.getHeadingRadians())"
        tree.getNode(1) instanceof VelocityNode
        tree.getNode(2) instanceof HeadingNode
    }
    
    def 'cross over stuff at head'(){
        when:
        def cross = new RoboCrossOver()
        def tree = new RoboTree()
        def pine = new RoboTree()
        tree.head = new BearingsNode()
        pine.head = new VelocityNode()
        def treeArray = cross.crossover(tree,pine,9)
        then:
        treeArray[0].head instanceof VelocityNode
        treeArray[1].head instanceof BearingsNode
        
    }
    def'test clone with size'(){
        when:
        def tree = new RoboTree()
        tree.head = new PlusNode()
        tree.head.child = new BearingsNode()
        tree.head.child2 = new VelocityNode()
        def clone = tree.clone()
        then:
        clone.size() == tree.size()
    }
    def 'cross over stuff at specified point'(){
        when:
        def cross = new RoboCrossOver()
        def tree = new RoboTree()
        def pine = new RoboTree()
        tree.head = new PlusNode()
        tree.head.child = new BearingsNode()
        tree.head.child2 = new VelocityNode()
        pine.head = new NearAbsoluteNode()
        pine.head.child = new VelocityNode()
      
        def pineArray = cross.crossover(tree,pine,1,1,5)
        def treeArray = cross.crossover(tree,pine,0,1,6)
        then:
        treeArray[0].head instanceof VelocityNode
        treeArray[1].head.child instanceof PlusNode
        pineArray[0].head.child instanceof VelocityNode
        pineArray[1].head.child instanceof BearingsNode
    }
    def 'test tree id stuff'(){
        when:
        def tree = new RoboTree(id:5)
        then:
        tree.id == 5
    }
    def'test ++stuff vs stuff++'(){
        when:
        int g
        int z
        int B = 6
        int A = 6
        g =++B
        z = A++
        then:
        g == 7
        z == 6
        
    }
}
