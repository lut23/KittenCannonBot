package roboTree

class RelativeNode {
    def parent
    def child
    def arity = 1
    // normalRelativeAngle normalizes angle in range -Pi to Pi
    def String(){
        return "Utils.normalRelativeAngle"
    }
    def setChild(node){
        child = node
    }
    def clone(){
        def tempNode = new RelativeNode()
        return tempNode
    }
}
