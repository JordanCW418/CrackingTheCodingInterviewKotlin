package arraysAndStrings
//https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/

fun minOperations(boxes: String): IntArray {
    val result = IntArray(boxes.length)
    //Left Pass
    var prevMoves = 0
    var numberOfBalls = 0
    for(i in (boxes.length - 1) downTo 0) {
        result[i] = numberOfBalls + prevMoves
        prevMoves = numberOfBalls + prevMoves
        numberOfBalls += boxes[i].digitToInt()
    }


    //Right Pass
    prevMoves = 0
    numberOfBalls = 0
    for(i in 0..(boxes.length - 1)) {
        result[i] += numberOfBalls + prevMoves
        prevMoves = numberOfBalls + prevMoves
        numberOfBalls += boxes[i].digitToInt()
    }

    return result
}