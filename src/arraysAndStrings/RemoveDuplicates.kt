package arraysAndStrings

/**
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
 *
 * Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
 *
 * Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
 * Return k.
 */

fun main(args : Array<String>){
    println("Solution 1")
    testCases.forEach { testCase ->
        println("Result -> ${removeDuplicates(testCase.first)} Expected -> ${testCase.second}")
    }
}

fun removeDuplicates(nums: IntArray): Int {
    if(nums.isEmpty()) {
        return 0
    }
    var insertionPoint = 1
    var currentNum = nums[0]
    var replacePoint = 1
    var result = 1

    while(replacePoint < nums.size && nums[replacePoint] >= currentNum) {
        if(currentNum == nums[replacePoint]) {
            replacePoint++
        } else {
            nums[insertionPoint++] = nums[replacePoint]
            result++
            currentNum = nums[replacePoint++]
        }
    }

    return result
}

private val testCases = arrayOf(
    // No duplicates
    Pair(intArrayOf(1, 2, 3, 4, 5), 5),

    // All duplicates
    Pair(intArrayOf(2, 2, 2, 2, 2), 1),

    // Mixed duplicates
    Pair(intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4), 5),

    // Single element
    Pair(intArrayOf(10), 1),

    // Empty array
    Pair(intArrayOf(), 0),

    // Duplicates at the beginning
    Pair(intArrayOf(1, 1, 2, 3, 4), 4),

    // Duplicates at the end
    Pair(intArrayOf(1, 2, 3, 4, 4, 4), 4),

    // Two elements, no duplicates
    Pair(intArrayOf(7, 8), 2),

    // Two elements, with duplicates
    Pair(intArrayOf(9, 9), 1),

    // Long run of duplicates in the middle
    Pair(intArrayOf(1, 2, 2, 2, 2, 3), 3)
)