class Solution {
    fun solution(s: String): IntArray {
        var answer = s.split(",")
            .toMutableList()
            .map {
                it.replace("{","")
                    .replace("}","")
                    .toInt()
            }
            .let {list ->
                val hashMap = hashMapOf<Int,Int>()
                list.forEach {
                    hashMap.set(it,hashMap.getOrDefault(it,0)+1)
                }
                hashMap
            }
            .toList()
            .sortedByDescending { it.second }
            .map { it.first }
            .toIntArray()

        return answer
    }
}