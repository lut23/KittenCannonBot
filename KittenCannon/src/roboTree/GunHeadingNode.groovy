package roboTree

class GunHeadingNode {
    def parent
    def arity = 0 
    
    // gets the heading of your robot's gun
    def String(){
        return "getGunHeadingRadians()"
    }
    def clone(){
        def tempNode = new GunHeadingNode()
        return tempNode
    }
}
