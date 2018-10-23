package arraysAndStrings

/**
 * Problem:
 * Given two Strings, write a method to decide if one is a permutation of the other
 */
fun main(args : Array<String>){
    println("Solution 1")
    testCases.forEach { strings ->
        val stringsArray = strings.split(" ")
        println(isPermutation1(stringsArray[0], stringsArray[1]))
    }

    println("\nSolution 2")
    testCases.forEach { strings ->
        val stringsArray = strings.split(" ")
        println(isPermutation2(stringsArray[0], stringsArray[1]))
    }
}

/**
 * Solution 1
 */
fun isPermutation1(str1 : String, str2 : String) : Boolean{
    val charArray1 = sort(str1)
    val charArray2 = sort(str2)
    return charArray1.contentEquals(charArray2)
}

fun sort(str : String) : CharArray{
    return str.toCharArray().sortedArray();
}

/**
 * Solution 2
 */
fun isPermutation2(str1 : String, str2: String) : Boolean{
    val charFreq = IntArray(128)
    str1.forEach { char : Char ->
        charFreq[char.toInt()]++
    }
    str2.forEach { char : Char ->
        charFreq[char.toInt()]--
    }
    return charFreq.contentEquals(IntArray(128))
}

//TODO Add More Test Cases
/**
  * Test Cases
  */
val testCases = arrayOf(
        "abc cba",
        "abc cbaa",
        "aabc cbaa"
)