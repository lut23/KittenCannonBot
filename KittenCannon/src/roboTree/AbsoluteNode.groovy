package roboTree

class AbsoluteNode {
    def parent
    def child
    def arity = 1
    // NormalAbsoluteAngel returns an absolute angle in range 0 to 2 PI
    def setChild(node){
        child = node
    }
    def String(){
        return "Utils.normalAbsoluteAngle"
    }
}
