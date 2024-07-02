//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    println(longestPalindrome("babad")) // bab
    println(longestPalindrome("cbbd")) // bb
}

fun longestPalindrome(s: String): String {
    var winnerPalindrome: MutableList<Char> = mutableListOf()
    val strArr = s.toCharArray()

    for (fChar in strArr.indices) {
        for (sChar in fChar..<strArr.size) {
            val subStr:CharArray = strArr.copyOfRange(fChar, sChar + 1)
            if (subStr.size > winnerPalindrome.size && subStr.contentEquals(subStr.reversedArray())) {
                winnerPalindrome = subStr.toMutableList()
            }
        }
    }

    return winnerPalindrome.joinToString("")
}

fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {

    val mergedArray = (nums1 + nums2).sorted();

    if(mergedArray.size %2 == 0){
        val mid = mergedArray.size / 2
        return (mergedArray[mid] + mergedArray[mid - 1]) / 2.0
    }
    return mergedArray[mergedArray.size / 2].toDouble()

}

fun lengthOfLongestSubstring(s: String): Int {

    val strArr = s.toCharArray()

    var maxValue = 0;

    for (fChar in strArr.indices) {
        val set = mutableSetOf<Char>()
        for (sChar in fChar..<strArr.size) {
            if (set.contains(strArr[sChar])) {
                break
            }
            set.add(strArr[sChar])
        }
        if (set.size > maxValue) {
            maxValue = set.size
        }
    }

    return maxValue;
}


fun intToRoman(num: Int): String {
    val roman = StringBuilder()
    var n = num

    while (n > 0) {
        when {
            n >= 1000 -> {
                roman.append("M")
                n -= 1000
            }
            n >= 900 -> {
                roman.append("CM")
                n -= 900
            }
            n >= 500 -> {
                roman.append("D")
                n -= 500
            }
            n >= 400 -> {
                roman.append("CD")
                n -= 400
            }
            n >= 100 -> {
                roman.append("C")
                n -= 100
            }
            n >= 90 -> {
                roman.append("XC")
                n -= 90
            }
            n >= 50 -> {
                roman.append("L")
                n -= 50
            }
            n >= 40 -> {
                roman.append("XL")
                n -= 40
            }
            n >= 10 -> {
                roman.append("X")
                n -= 10
            }
            n >= 9 -> {
                roman.append("IX")
                n -= 9
            }
            n >= 5 -> {
                roman.append("V")
                n -= 5
            }
            n >= 4 -> {
                roman.append("IV")
                n -= 4
            }
            n >= 1 -> {
                roman.append("I")
                n -= 1
            }
        }
    }

    return roman.toString()
}

fun parenthesis(s: String): Boolean {
    val stack = mutableListOf<Char>()

    for (char in s) {
        when (char) {
            '(', '{', '[' -> stack.add(char)
            ')' -> {
                if (stack.isEmpty() || stack.removeAt(stack.size - 1) != '(') return false
            }
            '}' -> {
                if (stack.isEmpty() || stack.removeAt(stack.size - 1) != '{') return false
            }
            ']' -> {
                if (stack.isEmpty() || stack.removeAt(stack.size - 1) != '[') return false
            }
        }
    }

    return stack.isEmpty()
}
