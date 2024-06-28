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