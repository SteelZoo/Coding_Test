import kotlin.math.sqrt

class Solution {
    fun solution(number: Int, limit: Int, power: Int): Int {
        var answer: Int = 0

        for (i in 1..number) {
            val divisorNumber = countDivisor(i)
            if (divisorNumber > limit) {
                answer += power
            } else {
                answer += divisorNumber
            }
        }

        return answer
    }

    fun countDivisor(number: Int): Int {

        var result = 0
        for (i in 1..sqrt(number.toDouble()).toInt()) {
            if (i * i == number) result++
            else if (number % i == 0) result += 2
        }

        return result
    }
}