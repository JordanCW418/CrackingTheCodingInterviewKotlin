package backtracking



fun main(args : Array<String>){
    testCases.forEach { testCase ->
        val output = generateParenthesis(testCase.first)
        println("Input -> ${testCase.first} Output Matches Expected -> ${output.toSet() == testCase.second.toSet()}")
    }
}

fun generateParenthesis(n: Int): List<String> {
    val result = mutableListOf<String>()
    if(n > 0) {
        val current = CharArray(2 * n)
        current[0] = '('
        rec(n, 1, result, current, 1)
    }
    return result
}

fun rec(n:Int, balance: Int, result: MutableList<String>, current: CharArray, index: Int) {
    if(balance >= 0 && balance <= n) {
        if(index < (2 * n)) {
            current[index] = '('
            rec(n, balance + 1, result, current, index + 1)
            current[index] = ')'
            rec(n, balance - 1, result, current, index + 1)
        } else if(balance == 0) {
            result.add(String(current))
        }
    }
}


val testCases = arrayOf(
    Pair(1, listOf("()")),
    Pair(2, listOf("()()", "(())")),
    Pair(3, listOf("((()))", "(()())", "(())()", "()(())", "()()()")),
    Pair(4, listOf(
        "(((())))", "((()()))", "((())())", "((()))()",
        "(()(()))", "(()()())", "(()())()", "(())(())",
        "(())()()", "()((()))", "()(()())", "()(())()",
        "()()(())", "()()()()"
    )),
    Pair(0, listOf<String>()) // Optional: edge case with 0 pairs
)