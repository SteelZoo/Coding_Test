fun main() {

    val arrayInt: Array<IntArray>
    = arrayOf(intArrayOf(60,50),
        intArrayOf(30,70),
        intArrayOf(60,30),
        intArrayOf(80,40))

    println(Solution().solution(arrayInt))
}



class Solution {
    fun solution(sizes: Array<IntArray>): Int {
        var answer: Int = 0

        var max1 = 0
        var max2 = 0
        sizes.map {
            if(it[0]<it[1]){
                val temp = it[0]
                it[0] = it[1]
                it[1] = temp
            }
            it
        }.forEach {
            if (it[0]>max1){
                max1 = it[0]
            }
            if (it[1]>max2){
                max2 = it[1]
            }
        }

        return max1*max2
    }
}