class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        var answer = 1

        val clothesMap = hashMapOf<String,Int>()
        clothes.forEach {
            clothesMap.set(it[1],clothesMap.getOrDefault(it[1],0)+1)
        }

        clothesMap.forEach {
            answer *= (it.value+1)
        }


        return answer-1
    }
}

/**
 * 수학적 해설 : https://school.programmers.co.kr/questions/33347
 */