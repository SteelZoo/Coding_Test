class Solution {
    fun solution(n: Int): Int {
        var answer = 0

        var before2 = 0
        var before1 = 1

        for (i in 0 until (n-1)) {
            answer = (before1 + before2) % 1234567
            before2 = before1
            before1 = answer
        }

        return answer
    }
}