package arraysAndStrings

/**
        Problem:
        Implement an algorithm to determine if a string has all unique characters.
        What if you cannot use additional data structures?
        */

//TODO add more test cases maybe try to do unit tests?
fun main(args : Array<String>){
    println(isUnique("abc"))
    println(isUnique("aabcs"))
}

fun isUnique(str : String): Boolean {
    //If the string has more than 128 characters then not every character can by unique
    if(str.length > 128){
        return false
    }
    //charSet holds boolean values for whether we have already found and instance of this char
    val charSet = BooleanArray(128)
    //loop over the string and for every character if we haven't already seen it we set it's corresponding
    //boolean in charSet to true and if we have already found the character we just return false
    str.forEach {
        val char = it.toInt()
        if(charSet[char]) {
            return false
        }
        charSet[char] = true
    }
    return true
}