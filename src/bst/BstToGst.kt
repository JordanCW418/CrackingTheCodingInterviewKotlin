package bst



fun main(args : Array<String>){
    for ((input, expected) in testCases) {
        val root = buildBSTFromList(input)
        bstToGst(root)

        val actual = mutableListOf<Int>()
        fun collectInorder(node: TreeNode?) {
            if (node != null) {
                collectInorder(node.left)
                actual.add(node.value)
                collectInorder(node.right)
            }
        }

        collectInorder(root)

        println("Input: $input")
        println("Expected: $expected")
        println("Actual:   $actual")
        println("Test Pass: ${actual == expected}")
        println()
    }
}


fun bstToGst(root: TreeNode?): TreeNode? {
    rec(root, 0)
    return root
}

fun rec(root: TreeNode?, runningTotal: Int): Int {
    if(root == null){
        return runningTotal
    } else {
        var total = rec(root.right, runningTotal)

        total += root.value
        root.value = total

        return rec(root.left, total)
    }
}

val testCases = arrayListOf(
    Pair(listOf(4, 1, 6), listOf(11, 10, 6)),
    Pair(listOf(5, 2, 13), listOf(20, 18, 13)),
    Pair(listOf(3, 2, 1), listOf(6, 5, 3)),
    Pair(listOf(1, 2, 3), listOf(6, 5, 3)),
    Pair(listOf(0, -1, 1), listOf(1, 1, 0)),
    Pair(listOf(10), listOf(10)),
    Pair(listOf(5, 3, 7, 2, 4, 6, 8), listOf(35, 33, 30, 26, 21, 15, 8)),
    // Test case 1
    Pair(
        listOf<Int?>(5, 3, 6, 2, 4, null, 7),  // BST with missing left of 6
        listOf(33, 29, 26, 21, 15, 7, 7)       // GST inorder
    ),

    // Test case 2
    Pair(
        listOf<Int?>(1, 0, 2, null, null, null, 3),  // BST with right-skewed branch at 2
        listOf(6, 6, 5, 3)                           // GST inorder
    ),

    // Test case 3
    Pair(
        listOf(4, 1, null, 0, 2),
        listOf(6, 3, 2, 10)  // Correct inorder of GST
    ),

    // Test case 4
    Pair(
        listOf<Int?>(2, null, 3, null, 4, null, 5),  // right-skewed tree
        listOf(14, 12, 9, 5)                         // GST inorder
    ),

    // Test case 5
    Pair(
        listOf<Int?>(null),  // Empty tree
        listOf()             // Empty inorder
    ),
    // 1. Complete BST with some missing nodes
    Pair(
        listOf<Int?>(10, 5, 15, 3, 7, null, 18),
        listOf(58, 53, 50, 43, 36, 33, 18)
    ),

    // 2. Left skewed tree
    Pair(
        listOf<Int?>(5, 4, null, 3, null, null, null, 2),
        listOf(14, 10, 6, 3)
    ),

    // 3. Right skewed tree
    Pair(
        listOf<Int?>(1, null, 2, null, 3, null, 4),
        listOf(10, 9, 7, 4)
    ),

    // 4. Tree with only root
    Pair(
        listOf<Int?>(42),
        listOf(42)
    ),

    // 5. Empty tree
    Pair(
        listOf<Int?>(null),
        listOf()
    ))