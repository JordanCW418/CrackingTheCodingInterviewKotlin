package linkedlists

/**
 * Write code to remove duplicates from an unsorted linked list
 */
var mapOfFoundIntegers: HashSet<Int> = HashSet()
fun main(args : Array<String>){
    var testCaseNum = 1
    testCases.forEach { case ->
        println("Test Case: ${testCaseNum++}")
        printList(case)
        println()
        mapOfFoundIntegers = HashSet()
        removeDuplicatesFromLinkedList(Node(0, case))
        printList(case)
        println("\n------------------------")
    }
}


private fun removeDuplicatesFromLinkedList(previousNode: Node?){
    var prev = previousNode
    val current = previousNode?.next

    if(prev != null &&  current != null) {
        if (mapOfFoundIntegers.contains(current.value)) {
            removeCurrentNodeFromList(prev)
        } else {
            mapOfFoundIntegers.add(current.value)
            prev = prev.next
        }
        removeDuplicatesFromLinkedList(prev)
    }
}

private fun removeCurrentNodeFromList(prev: Node){
    prev.next = prev.next?.next
}


private fun printList(node: Node?){
    node?.let {
        print("${node.value} -> ")
        printList(node.next)
    }
}


private val testCases = arrayOf(
        Node(2,Node(3,Node(2, Node(5, Node(5))))),
        Node(4,Node(4,Node(4, Node(4, Node(4))))),
        Node(4,Node(4,Node(3, Node(4, Node(4))))),
        Node(4),
        null
)