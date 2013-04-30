package roboTree

class TimesNode {
    def parent
    def child
    def arity = 2
    // normalNearAbsoluteAngle normalizes angle in range 0Pi to 2Pi and return 0,Pi/2, Pi, 3*Pi/2 or 2*Pi when the angle is near those values
    def String(){
        return "*"
    }
    def setChild(node){
        child = node
    }
}
