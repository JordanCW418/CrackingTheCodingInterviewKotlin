package arraysandstrings

fun main(args : Array<String>){
        println("Solution 1")
        testCases.forEach { array ->
            println(reverseArray(array).forEach { int -> print(int.toString() + " ") })
        }
    }
    fun reverseArray(array: Array<Int>): Array<Int> {
        val midPoint = array.size/2
        var upperIndex = array.size - 1

        for(lowerIndex in 0..midPoint){
            if(upperIndex >= midPoint) {
                val temp = array[upperIndex]
                array[upperIndex--] = array[lowerIndex]
                array[lowerIndex] = temp
            }
        }
        return array

    }
private val testCases = arrayOf(
        arrayOf(1, 4, 3, 2)
)
