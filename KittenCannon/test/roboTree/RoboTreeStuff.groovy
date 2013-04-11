package roboTree

import spock.lang.Specification;

class RoboTreeStuff extends Specification {
    
    def 'size stuff'(){
        when:
        def tree = new RoboTree()
        tree.head = new AbsoluteNode()
        tree.head.child = new HeadingNode()
        
        then:
        tree.size() == 2
        
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
        tree.head = new AbsoluteNode()
        tree.head.child = new HeadingNode()
        def string = tree.treeToString()
        
        then:
        string == "Utils.normalAbsoluteAngle(getHeadingRadians())"
    }

}
