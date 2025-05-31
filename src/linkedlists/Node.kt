package linkedlists

class Node(var value: Int, var next: Node? = null){



    fun printList(){
        print("$value -> ")
        next?.let {
            it.printList()
        }
    }
}

fun buildLinkedList(values: List<Int>): Node? {
    if (values.isEmpty()) return null
    val head = Node(values[0])
    var current = head
    for (i in 1 until values.size) {
        current.next = Node(values[i])
        current = current.next!!
    }
    return head
}

fun toList(head: Node?): List<Int> {
    val result = mutableListOf<Int>()
    var current = head
    while (current != null) {
        result.add(current.value)
        current = current.next
    }
    return result
}