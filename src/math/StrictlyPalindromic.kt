package math

fun isStrictlyPalindromic(n: Int): Boolean {
    //All numbers greather than or equal to 4 are false
    if(n >= 4) {
        return false
    }
    for(base in 2..(n-2)) {
        val nString = generateBase(n, base)
        if(isPalindrome(nString).not()) {
            return false
        }
    }
    return true
}

private fun generateBase(n: Int, base: Int): String {
    val result = StringBuilder()
    var current = n

    while(current > 0) {
        result.insert(0, current % base)
        current /= base
    }

    return result.toString()
}

private fun isPalindrome(nString: String): Boolean {
    val array = nString.toCharArray()

    var right = array.size - 1
    var left = 0
    while(left < right) {
        if(array[left++] != array[right--]) {
            return false
        }
    }

    return true
}