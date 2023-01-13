class Solution {
    fun solution(n: Int, left: Long, right: Long): IntArray {
        var answer: MutableList<Int> = mutableListOf()

        for (index in left .. right) {
            var num = index/n + 1
            if (index%n > index/n) {
                num += index%n - index/n
            }
            answer.add(num.toInt())
        }

        return answer.toIntArray()
    }
}