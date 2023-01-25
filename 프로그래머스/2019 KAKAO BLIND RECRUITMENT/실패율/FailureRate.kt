class Solution {
    fun solution(N: Int, stages: IntArray): IntArray {
        var answer = IntArray(N){it+1}


        val successArray = Array(N+2){0} //편한 접근을 위해 사이즈+2

        //인덱스(스테이지)별 도달 인원카운트
        for (i in stages) {
            successArray[i]++
        }
        //도달인원을 기준으로 각 스테이지 실패율 계산
        val failureRateArray = Array(N+1){0.0} //전부 클리어한 인원은 필요없어서 1~size
        for (index in 1..N) {
            failureRateArray[index] = successArray[index].toDouble()/totalUser(index,successArray).toDouble()
            if (failureRateArray[index].isNaN()) {failureRateArray[index] = 0.0} // 0/0(NaN)이 될때는 0으로 변경
        }

        answer = answer.sortedByDescending {
            failureRateArray[it]
        }.toIntArray()

        return answer
    }

    //해당 스테이지 도달, 통과한 인원
    fun totalUser(stage: Int, successArray: Array<Int>): Int{
        var result = 0
        for (index in stage until successArray.size) {
            result += successArray[index]
        }
        return result
    }
}