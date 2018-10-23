package arraysAndStrings

/**
  * Problem: 1.3
  * Write a method to replace all spaces in a string with '%20'. You may assume that the String has sufficient space at
  * the end to hold the additional characters, and that you are given the 'true' length of the String.
  */
fun main(args : Array<String>){
    testCases.forEach { pair ->
        println("Input: " + pair.first + " " + pair.second)
        val answer = String(URLify(pair.first.toCharArray(), pair.second))
        println("Output: $answer")
    }
}

fun URLify(str : CharArray, length : Int) : CharArray{
    var spacesCount = 0
    for(i in 0..(length - 1)){
        if(str[i].isWhitespace()){
            spacesCount++
        }
    }

    var index = length + (2*spacesCount)
    for(i in (length-1) downTo 1){
        if(str[i].compareTo(' ') == 0){
            str[--index] = '0'
            str[--index] = '2'
            str[--index] = '%'
        }
        else{
            str[--index] = str[i]
        }
    }

    return str
}

//TODO Add more Test Cases
/**
  * Test Cases
  */
private val testCases = arrayOf(
    Pair("Mr John Smith    ", 13)
)