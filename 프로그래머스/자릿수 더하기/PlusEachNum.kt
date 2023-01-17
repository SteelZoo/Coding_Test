class Solution {
    fun solution(n: Int): Int {
        var answer = 0

        n.toString().forEach{
            answer += it.toString().toInt()
        }

        return answer
    }
}