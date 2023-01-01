class Solution {
    fun solution(k: Int, tangerine: IntArray): Int {
        var answer: Int = 0

        var mandarinMap: MutableMap<Int,Int> = mutableMapOf()

        for (i in tangerine) {
            mandarinMap[i]?.let { mandarinMap[i] = it+1 }
            if (mandarinMap[i] == null) { mandarinMap[i] = 1 }
        }

        var totalMandarin = 0
        var sortedMandarinList = mandarinMap.toList().sortedByDescending { it.second }
        for (pair in sortedMandarinList){
            totalMandarin += pair.second
            answer++
            if (totalMandarin >= k) break
        }

        return answer
    }
}