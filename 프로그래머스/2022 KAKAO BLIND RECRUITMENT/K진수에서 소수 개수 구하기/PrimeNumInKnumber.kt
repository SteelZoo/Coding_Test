class Solution {
    fun solution(n: Int, k: Int): Int {
        var answer: Int = 0

        for (s in getKNumber(n, k).split("0")) {
            if (s.isNotEmpty() && isPrimeNumber(s.toLong())) answer++
        }

        return answer
    }

    fun getKNumber(n: Int, k: Int): String {
        var number = n

        val stringBuilder = StringBuilder()

        while (number != 0) {
            stringBuilder.insert(0, number % k)
            number /= k
        }

        return stringBuilder.toString()
    }

    fun isPrimeNumber(n: Long): Boolean {
        if (n < 2) return false
        var i: Long = 2
        while (i * i <= n) {
            if (n % i == 0L) return false
            i++
        }
        return true
    }
}