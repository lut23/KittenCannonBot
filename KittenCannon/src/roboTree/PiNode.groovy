package roboTree

class PiNode {
    def parent
    def arity = 0
    // normalNearAbsoluteAngle normalizes angle in range 0Pi to 2Pi and return 0,Pi/2, Pi, 3*Pi/2 or 2*Pi when the angle is near those values
    def String(){
        return "Math.PI"
    }
    def setChild(node){
        child = node
    }
    def clone(){
        def tempNode = new PiNode()
        return tempNode
    }
}
