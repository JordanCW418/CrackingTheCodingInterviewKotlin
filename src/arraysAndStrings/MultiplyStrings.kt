package arraysAndStrings



    fun multiply(num1: String, num2: String): String {
        if (num1 == "0" || num2 == "0") return "0"

        val result = CharArray(num1.length + num2.length) { '0' }

        for (i in num1.length - 1 downTo 0) {
            for (j in num2.length - 1 downTo 0) {
                val mul = (num1[i] - '0') * (num2[j] - '0')
                val p1 = i + j
                val p2 = i + j + 1

                val sum = mul + (result[p2] - '0')
                result[p2] = ((sum % 10) + '0'.code).toChar()
                val carry = (sum / 10) + (result[p1] - '0')
                result[p1] = (carry + '0'.code).toChar()
            }
        }

        return String(result).dropWhile { it == '0' }
    }
