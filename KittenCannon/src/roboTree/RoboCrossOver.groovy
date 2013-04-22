package roboTree
import java.util.Random
class RoboCrossOver {
    def rand = new Random()
    /* not sure if biggestSize() is needed as long as we use the size of the respective tree in finding a node in that tree*/
    def biggestSize(tree1,tree2){
        def biggestsize
        if(tree1.size() > tree2.size()){
            biggestsize = tree2.size()
        }
        else{biggestsize = tree1.size()}
        return biggestsize
    }

    def crossover(fatherTree, motherTree, FPoint = null, MPoint = null,Id){
        def dadTree = fatherTree.clone()
        def momTree = motherTree.clone()
        def biggestSize = biggestSize(dadTree,momTree)
        def fatherPoint = 0
        def motherPoint = 0
        if(FPoint == null || MPoint == null){
        if(biggestSize != 1){
            fatherPoint = rand.nextInt(biggestSize)
            motherPoint = rand.nextInt(biggestSize)
        }
        }else{
            fatherPoint = FPoint
            motherPoint = MPoint
        }

        def fatherNode = dadTree.getNode(fatherPoint)
        def motherNode = momTree.getNode(motherPoint)
        def grandFather
        def grandMother

        if(fatherPoint == 0){
            grandFather = null
        }
        else{
            grandFather = fatherNode.parent

        }
        if(motherPoint == 0){
            grandMother = null
        }
        else{
            grandMother = motherNode.parent
        }
        if(momTree.getMax() < momTree.size()-momTree.size(motherNode)+dadTree.size(fatherNode)||dadTree.getMax() < dadTree.size()-dadTree.size(fatherNode)+momTree.size(motherNode)){
            return [dadTree,momTree]
        }
        /* case where crossover occurs at the head of the tree*/
        if(fatherPoint == 0 && motherPoint == 0){
            def tempNode = dadTree.head
            dadTree.head = momTree.head
            momTree.head = tempNode
        }
        /* case where crossover occurs at the head of the tree and inside the tree*/
        else if(fatherPoint == 0 && motherPoint != 0){
            def tempFather = fatherNode
            dadTree.head = motherNode
            def tempParent1 = motherNode.parent
            if(tempParent1.arity ==1){

                tempParent1.child = fatherNode
                fatherNode.parent= tempParent1

            }
            if(tempParent1.arity== 2){
                if(tempParent1.child2 == motherNode){
                    tempParent1.child2 = fatherNode
                    fatherNode.parent = tempParent1
                } else{
                    tempParent1.child = fatherNode
                    fatherNode.parent= tempParent1

                }


            }
            dadTree.head.parent = null
        }
        /* case where crossover occurs at the head of the tree and inside the tree*/
        else if(motherPoint == 0 && fatherPoint != 0){
            def tempMother = motherNode
            momTree.head = fatherNode
            def tempParent1 = fatherNode.parent
            if(tempParent1.arity ==1){

                tempParent1.child = motherNode
                motherNode.parent=tempParent1

            }
            if(tempParent1.arity== 2){
                if(tempParent1.child2 == fatherNode){
                    tempParent1.child2 = motherNode
                    motherNode.setParent(tempParent1)
                }else{
                    tempParent1.child = motherNode
                    motherNode.parent=tempParent1

                }
            }
            momTree.head.parent = null

        }
        /* case where crossover occurs in the tree */
        else if (motherPoint != 0 && fatherPoint != 0) {
            def tempParent = fatherNode.parent
            def tempParent1 = motherNode.parent

            if(tempParent.arity == 1){
                tempParent.child = motherNode
                motherNode.parent= tempParent
            }
                if( tempParent.arity == 2){
                    if(tempParent.child == fatherNode){
                        tempParent.child = motherNode
                        motherNode.parent= tempParent
                    }
                    else{
                        tempParent.child2 = motherNode
                        motherNode.parent = tempParent

                    }
                }

            

            if(tempParent1.arity == 1){
                
                    tempParent1.child=fatherNode
                    fatherNode.parent=tempParent1
                    
                }
            if(tempParent1.arity == 2){
                if(tempParent.child == motherNode){
                    tempParent1.child=fatherNode
                    fatherNode.parent=tempParent1
                    }
                    else{
                    tempParent1.child2 = fatherNode
                    fatherNode.parent= tempParent1
                }
            }
        }
        dadTree.id = ++Id
        dadTree.run()
        momTree.id = ++Id
        momTree.run()
        return [dadTree,momTree]
    }
}
