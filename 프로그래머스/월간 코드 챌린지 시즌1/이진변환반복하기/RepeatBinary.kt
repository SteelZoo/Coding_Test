class Solution {
    fun solution(s: String): IntArray {
        var answer: IntArray = intArrayOf()
        var numString = s
        var deleteZero = 0
        var countBinary = 0


        while (numString != "1") {
            deleteZero += numString.count { it == '0' }
            numString = numString.replace("0","")

            numString = numString.length.toString(2)
            countBinary++

            if (numString == "1") break
        }

        answer = intArrayOf(countBinary,deleteZero)

        return answer
    }
}