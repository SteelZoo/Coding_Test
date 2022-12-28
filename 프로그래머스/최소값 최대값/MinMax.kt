class Solution {
    fun solution(s: String): String {
        var max: Int? = null
        var min: Int? = null

        s.split(" ")
            .forEach{
                val num = it.toInt()
                if (max == null && min == null) {
                    max = num
                    min = num
                } else {
                    if(num>max!!) {
                        max = num
                    } else if (num<min!!) {
                        min = num
                    }
                }
            }


        return "$min $max"
    }
}