package roboTree

class HeadingNode {
    def parent
    def arity = 0
    // gets the heading of your robot
    def String(){
        return "e.getHeadingRadians()"
    }
    def clone(){
        def tempNode = new HeadingNode()
        return tempNode
    }
}
