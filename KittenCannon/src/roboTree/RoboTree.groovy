package roboTree

import java.util.Random
import applications.robocode.*
class RoboTree {
    def max = 1000
    def head
    def rand = new Random()
    def size
    def id
    def quality
    def battleRunner = new BattleRunner("templates/battle.template")
    def values
    def robotBuilder = new RobotBuilder("templates/Leopard.template")
    
    def terminate(best, qualityOfBest){
        return qualityOfBest >=2000
        
    }
    def quality(){
        return quality
    }
    def run(){
        values = ["id" : id, "new_angle": treeToString()]
        robotBuilder.buildJarFile(values)
        battleRunner.buildBattleFile(id)
        quality = battleRunner.runBattle(id)
    }
    def create(){
        grow(1,head)
        run()
    }
    def trees
    def clone(){
        def tree = new RoboTree()
        recurseClone(tree.getHead(),head)
        tree.head = trees
        return tree
    }
    def cloneNode(node){
        def clone
        if(node instanceof AbsoluteNode){
            clone = new AbsoluteNode()
        }
        else if(node instanceof BearingsNode ){
            clone = new BearingsNode()
        }
        else if(node instanceof GunHeadingNode){
            clone = new GunHeadingNode()
        }
        else if(node instanceof HeadingNode){

            clone = new HeadingNode ()
        }
        else if(node instanceof NearAbsoluteNode){

            clone = new  NearAbsoluteNode()
        }
        else if(node instanceof RelativeNode){

            clone = new RelativeNode()
        }
        else if(node instanceof VelocityNode){

            clone = new VelocityNode()
        }else if(node instanceof PlusNode){
            clone = new PlusNode()
        }
        else if(node instanceof MinusNode){
            clone = new MinusNode()
        }
        return clone
    }
    def recurseClone(treeNode,node){
        if(node == head){
            treeNode = cloneNode(head)
            trees = treeNode
        }
        if(node.arity !=0) {

            treeNode.child = (cloneNode(node.child))
            treeNode.child.parent = treeNode
            recurseClone(treeNode.child,node.child)

            if(node.arity == 2){
                treeNode.child2 = (cloneNode(node.getChild2()))
                treeNode.child2.parent = treeNode
                recurseClone(treeNode.child2,node.child)
            }
        }
    }
    def size(node = head){
        size = 0
        calcSize(node)
        return size
    }
    def calcSize(node){

        if(node.arity == 1) {
            size+= 1
            calcSize(node.getChild())
        }
        if(node.arity == 2){
            size+= 1
            calcSize(node.getChild())
            calcSize(node.getChild2())
        }
        if(node.arity == 0){
            size += 1
            return
        }
    }
    def grow(depth,node){
        def randFunc
        def absNode = new AbsoluteNode()
        def bearing = new BearingsNode()
        def gun = new GunHeadingNode()
        def heading = new HeadingNode()
        def nAbs = new NearAbsoluteNode()
        def relative = new RelativeNode()
        def velocity = new VelocityNode()
        def Plus = new PlusNode()
        def Minus = new MinusNode()
        def functions = [absNode,nAbs,relative,bearing,gun,heading,velocity,Plus,Minus]

        if(depth >= max){
            randFunc = functions[rand.nextInt(4)+ 3]
            randFunc.parent = node
            return randFunc
        }
        randFunc = functions[rand.nextInt(7)]
        if(head == null){
            head = randFunc
            if(head.arity == 0) return head

        }
        randFunc.parent = node
        if(randFunc.arity != 0){
            randFunc.setChild(grow(depth +1 , randFunc))
            if(randFunc.arity == 2){
                randFunc.setChild2(grow(depth+1, randFunc))
            }
        }
        return randFunc
    }
    def returnNode
    def nodeCounter
    def getNode(number){
        returnNode = null
        nodeCounter = 0
        findNode(number)
        return returnNode
    }
    def findNode(node = head,number){
        if(nodeCounter.equals(number)){
            returnNode = node
            return
        }else{
            if(node.arity == 1) {

                nodeCounter+= 1

                findNode(node.child, number)
            }
            if(node.arity == 2){
                nodeCounter+= 1

                findNode(node.child, number)
                nodeCounter +=1
                findNode(node.child2,number)
            }
            else{
                return
            }
        }
    }
    def treeString
    def treeToString(){
        treeString = ''
        recurseString(head)
        return treeString
    }
    def recurseString(node){
        if(node.arity <= 1){
            treeString += node.String()
        }
        if(node.arity == 1){

            treeString += '('
            recurseString(node.child)
            treeString += ')'

        }
        if(node.arity == 2){
            treeString += '('
            recurseString(node.child)
            treeString += ')'
            treeString += node.String()
            treeString += '('
            recurseString(node.child2)
            treeString += ')'

        }
    }
    def getHead(){
        return head
    }
    def setHead(node){
        head = node
    }

}
