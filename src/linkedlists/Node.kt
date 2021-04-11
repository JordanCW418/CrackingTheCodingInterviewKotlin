package linkedlists

class Node(var value: Int, var next: Node? = null){



    fun printList(){
        print("$value -> ")
        next?.let {
            it.printList()
        }
    }
}