package linkedlists


fun main(args : Array<String>){
    for ((input, expected) in testCases) {
        val result = insertGreatestCommonDivisors(input)
        val resultList = toList(result)
        val expectedList = toList(expected)

        if (resultList == expectedList) {
            println("PASS: $resultList")
        } else {
            println("FAIL: Expected $expectedList but got $resultList")
        }
    }
}


fun insertGreatestCommonDivisors(head: Node?): Node? {

    var prev = head
    var next = head?.next

    while (next != null) {
        val insertedNode = Node(gcd(prev!!.value, next.value))
        prev.next = insertedNode
        insertedNode.next = next

        // Move prev and next to the next pair of original nodes
        prev = next
        next = next.next
    }

    return head
}

private fun handleInsert(prev: Node, next: Node, insertedNode: Node) {
    prev.next = insertedNode
    insertedNode.next = next
}

private fun gcd(a: Int, b: Int): Int {
    return if(b == 0) {
        a
    } else {
        gcd(b, a % b)
    }
}

val testCases = arrayListOf(
    // Input: [18, 6, 3, 9]
    // Insert gcd nodes: 6, 3, 3 → output length 7
    Pair(
        buildLinkedList(listOf(18, 6, 3, 9)),
        buildLinkedList(listOf(18, 6, 6, 3, 3, 3, 9))
    ),

    // Input: [15, 10]
    // Insert gcd node: 5 → output length 3
    Pair(
        buildLinkedList(listOf(15, 10)),
        buildLinkedList(listOf(15, 5, 10))
    ),

    // Input: [7, 9, 11]
    // Insert gcd nodes: 1, 1 → output length 5
    Pair(
        buildLinkedList(listOf(7, 9, 11)),
        buildLinkedList(listOf(7, 1, 9, 1, 11))
    ),

    // Input: [8, 8, 8]
    // Insert gcd nodes: 8, 8 → output length 5
    Pair(
        buildLinkedList(listOf(8, 8, 8)),
        buildLinkedList(listOf(8, 8, 8, 8, 8))
    ),

    // Input: [42]
    // Single node → no insertions
    Pair(
        buildLinkedList(listOf(42)),
        buildLinkedList(listOf(42))
    ),

    // Input: []
    // Empty list → no insertions
    Pair(
        buildLinkedList(emptyList()),
        buildLinkedList(emptyList())
    ),

    // Input: [100, 25, 5]
    // Insert gcd nodes: 25, 5 → output length 5
    Pair(
        buildLinkedList(listOf(100, 25, 5)),
        buildLinkedList(listOf(100, 25, 25, 5, 5))
    ),

    // Input: [9, 27, 6]
    // Insert gcd nodes: 9, 3 → output length 5
    Pair(
        buildLinkedList(listOf(9, 27, 6)),
        buildLinkedList(listOf(9, 9, 27, 3, 6))
    ),

    // Input: [1, 1]
    // Insert gcd node: 1 → output length 3
    Pair(
        buildLinkedList(listOf(1, 1)),
        buildLinkedList(listOf(1, 1, 1))
    ),

    // Input: [14, 21, 35]
    // Insert gcd nodes: 7, 7 → output length 5
    Pair(
        buildLinkedList(listOf(14, 21, 35)),
        buildLinkedList(listOf(14, 7, 21, 7, 35))
    )
)