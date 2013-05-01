package roboTree
import java.util.Random
class RandConstantNode {
    def rand = new Random()
    def value = rand.nextFloat() * 100
    def parent
    def arity = 0
    // makes a random constant
    def String(){
        return "${value}"
    }
    def setValue(val){
        value = val
    }
    
    def clone(){
        def tempNode = new RandConstantNode()
        tempNode.setValue(value)
        return tempNode
    }

}
