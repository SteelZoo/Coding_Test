class Solution {
    fun solution(n: Int, a: Int, b: Int): Int {
        var answer = 1
        var tempA = a
        var tempB = b

        while(!isMatch(tempA,tempB)){
            answer++
            tempA = tempA/2 + tempA%2
            tempB = tempB/2 + tempB%2
        }

        return answer
    }

    fun isMatch(a: Int, b: Int): Boolean{
        return ((a/2+a%2) == (b/2+b%2))
    }
}