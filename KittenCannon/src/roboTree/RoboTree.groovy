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
        return qualityOfBest >=500

    }
    def quality(){
        return quality
    }
    def run(){
        def str = treeToString()
        values = ["id" : id, "new_angle": str]
        println "Tree ${id} string ${str}"
        robotBuilder.buildJarFile(values)
        battleRunner.buildBattleFile(id)
        quality = battleRunner.runBattle(id)/30
        clean(id)
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
        else if(node instanceof TimesNode){
            clone = new TimesNode()
        }
        else if(node instanceof SinNode){
            clone = new SinNode()
        }
        else if(node instanceof CosNode){
            clone = new CosNode()
        }
        else if(node instanceof PiNode ){
            clone = new PiNode()
        }
        else if(node instanceof RandConstantNode){
            clone =  new RandConstantNode()
            clone.setValue(node.value)
        }
        
        return clone
    }
    def recurseClone(treeNode,node){
        
        if(node == head){
            treeNode = cloneNode(head)
            trees = treeNode
            
        }
        
        if(node.arity == 1) {

            treeNode.setChild(cloneNode(node.child))
            
            treeNode.child.parent = treeNode
            recurseClone(treeNode.child, node.child)
        }
        else if(node.arity == 2){
           
            treeNode.setChild(cloneNode(node.child))
            
            treeNode.child.parent = treeNode
            recurseClone(treeNode.child, node.child)

            treeNode.setChild2((cloneNode(node.child2)))
            
            treeNode.child2.parent = treeNode
            recurseClone(treeNode.child2, node.child2)
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
            calcSize(node.child)
        }
        if(node.arity == 2){
            size+= 1
            calcSize(node.child)
            calcSize(node.child2)
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
        def Times = new TimesNode()
        def Sin = new SinNode()
        def Cos = new CosNode()
        def Const = new RandConstantNode()
        def Pi = new PiNode()
        def functions = [absNode,nAbs,relative,bearing,gun,heading,velocity,Pi,Const,Sin,Cos,Plus,Minus,Times]

        if(depth >= max){
            randFunc = functions[rand.nextInt(4)+ 5]
            randFunc.parent = node
            return randFunc
        }
        randFunc = functions[rand.nextInt(functions.size())]
        if(head == null){
            head = randFunc
            if(head.arity == 0) return head

        }
        randFunc.parent = node
        if(randFunc.arity != 0){
            randFunc.child = (grow(depth +1 , randFunc))
            if(randFunc.arity == 2){
                randFunc.child2 = (grow(depth+1, randFunc))
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

    def clean(arrId){
        for(id in arrId){
            removeJavaFile(id)
            removeClassFile(id)
            removePropertiesFile(id)

        }

    }

    def removeJavaFile(id) {
        new File("evolved_robots/evolved/KittenCannon_${id}.java").delete()
    }

    def removeClassFile(id) {
        new File("evolved_robots/evolved/KittenCannon_${id}.class").delete()
        //new File("evolved_robots/evolved/Individual_${id}\$MicroEnemy.class").delete()
    }

    def removePropertiesFile(id) {
        new File("evolved_robots/evolved/KittenCannon_${id}.properties").delete()
    }


}
