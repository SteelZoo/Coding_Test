class Solution {
    fun solution(t: String, p: String): Int {
        var answer: Int = 0

        for (i in 0 .. t.length- p.length) {
            if (t.substring(i until (i+p.length)).toLong() <= p.toLong() ){
                answer++
            }
        }

        return answer
    }
}