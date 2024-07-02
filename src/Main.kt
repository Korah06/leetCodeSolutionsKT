//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    println(lengthOfLongestSubstring("asdfghijahaub")); //8
    println(lengthOfLongestSubstring("asdafghjkl")) //7
    println(lengthOfLongestSubstring("dvdf")) //3
}

fun lengthOfLongestSubstring(s: String): Int {

    val strArr = s.toCharArray()

    var max: Int = 0;

    val checkList: MutableList<Char> = mutableListOf();

    for ((i, char) in strArr.withIndex()) {

        if (!checkList.contains(char)) {
            checkList.add(char);
        } else {
            if (max < checkList.size) {
                max = checkList.size
            }
            checkList.clear();
            checkList.add(char)
        }

        if (max < checkList.size) {
            max = checkList.size
        }
//        if (i == strArr.size - 1) {
//            if (max < checkList.size) {
//                max = checkList.size
//                checkList.clear();
//            }
//        }
    }
    return max;
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
