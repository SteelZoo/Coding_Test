class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        val answer = mutableListOf<Int>()

        var completedCount = 0
        val proceeding = mutableListOf<Int>()
        proceeding.addAll(progresses.toList())

        while (completedCount < proceeding.size) {
            var tempCompleted = 0
            for (target in proceeding) {
                if (target >= 100) tempCompleted++
                else break
            }

            for (i in 0 until proceeding.size) {
                proceeding[i] += speeds[i]
            }

            if ((tempCompleted - completedCount) != 0) {answer.add(tempCompleted - completedCount)}
            completedCount = tempCompleted
        }

        return answer.toIntArray()
    }
}