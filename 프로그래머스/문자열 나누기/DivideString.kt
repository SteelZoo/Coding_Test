class Solution {
    fun solution(s: String): Int {
        var answer: Int = 0

        var firstChar = ' '
        var firstCount = 0
        var otherCount = 0

        s.forEachIndexed { index, c ->
            if (index == s.length-1) {
                answer++
                return@forEachIndexed
            }
            if (firstChar == ' ') {
                firstChar = c
                firstCount ++
            } else {
                if (c == firstChar){
                    firstCount++
                } else {
                    otherCount++
                }
                if (otherCount == firstCount){
                    answer++
                    otherCount = 0
                    firstCount = 0
                    firstChar = ' '
                }
            }
        }

        return answer
    }
}