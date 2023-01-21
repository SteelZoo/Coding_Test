class Solution {
    fun solution(a: Int, b: Int, n: Int): Int {
        var answer: Int = 0
        var left = n

        while(left/a != 0){
            answer += (left/a)*b
            left = (left/a)*b + (left%a)
        }

        return answer
    }
}

fun main(){
    println(Solution().solution(2,1,20))
}