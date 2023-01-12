class Solution {
    fun solution(citations: IntArray): Int {
        var answer = 0

        val sortedCitations = citations.sortedDescending()

        for (i in sortedCitations.indices) {
            if (sortedCitations[i] >= i+1) {
                answer++
            }
        }

        return answer
    }
}