package roboTree
import java.util.Random
class RoboTree {
    
    def head
    def rand = new Random()
    def run(){
        
    }
    def create(){
        
    }
    def clone(){
        
    }
    def size(){
        
    }
    def grow(depth, max ,node){
        def randFunc
        def absNode = new AbsoluteNode()
        def bearing = new BearingsNode()
        def gun = new GunHeadingNode()
        def heading = new HeadingNode()
        def nAbs = new NearAbsoluteNode()
        def relative = new RelativeNode()
        def velocity = new VelocityNode()
        def functions = [absNode,nAbs,relative,bearing,gun,heading,velocity]
        
        if(depth >= max){
            randFunc = functions[rand.nextInt(4)+3] 
            randFunc.parent = node
            return randFunc
        }
        randFunc = functions[rand.nextInt(7)]
        if(head == null){
            head = randFunc
        }
        randFunc.parent = node
        if(randFunc.arity != 0){
            randFunc.setChild(grow(depth +1 ,max , randFunc))
        }
        return randFunc
    }
    def getNode(){
        
    }
    def getHead(){
        return head
    }
    def setHead(node){
        head = node
    }
    
}
