package roboTree

class SinNode {
    def parent
    def child
    def arity = 1
    // normalNearAbsoluteAngle normalizes angle in range 0Pi to 2Pi and return 0,Pi/2, Pi, 3*Pi/2 or 2*Pi when the angle is near those values
    def String(){
        return "Math.sin"
    }
    def setChild(node){
        child = node
    }
    def clone(){
        def tempNode = new SinNode()
        return tempNode
    }
}
