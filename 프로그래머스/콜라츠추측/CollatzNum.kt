class Solution {
    fun solution(num: Int): Int {
        var answer = 0
        var collatzNum = num

        while (collatzNum != 1) {
            when(collatzNum%2){
                0->{
                    collatzNum = collatzNum/2
                }
                1->{
                    collatzNum = (collatzNum*3)+1
                }
            }
            answer++
            if(answer>500){
                answer = -1
                break
            }
        }


        return answer
    }
}