package recursionanddynamicprogramming


/**
 * A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3 steps at a time.
 * Implement a method to count how many possible ways the shild can run up the stairs.
 */
fun main(args : Array<String>){
    testCases.forEach { case ->
        System.out.println("Steps: ${case.first}\tWays: ${case.second}")
        System.out.println(tripleStep(case.first) == case.second)
        System.out.println("-----------")
    }
}

fun tripleStep(numSteps: Int): Int {
    return when {
        numSteps == 0 -> 1
        numSteps < 0 -> 0
        else -> tripleStep(numSteps - 1) + tripleStep(numSteps - 2) + tripleStep(numSteps - 3)
    }
}

private val testCases = arrayOf(
        Pair(0, 1),
        Pair(1, 1),
        Pair(2, 2),
        Pair(3, 4),
        Pair(4, 7)
)