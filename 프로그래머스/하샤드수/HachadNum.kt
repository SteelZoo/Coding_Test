class Solution {
    fun solution(x: Int): Boolean {
        var answer = true
        var total = 0

        total = getEachSum(x)

        print(total)

        if ((x%total) != 0) answer = false

        return answer
    }


    fun getEachSum(x: Int): Int{
        if (x == 0) return 0

        return (x%10) + getEachSum(x/10)
    }
}