package bst

class TreeNode(var value: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun buildBSTFromList(values: List<Int?>): TreeNode? {
    var root: TreeNode? = null
    for (value in values) {
        value?.let {
            root = insertIntoBST(root, it)
        }

    }
    return root
}

fun insertIntoBST(root: TreeNode?, value: Int): TreeNode {
    if (root == null) return TreeNode(value)
    if (value < root.value) {
        root.left = insertIntoBST(root.left, value)
    } else {
        root.right = insertIntoBST(root.right, value)
    }
    return root
}