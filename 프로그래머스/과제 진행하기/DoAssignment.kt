import java.text.SimpleDateFormat
import java.util.*

fun main(){
    Solution().solution(
        arrayOf(
            arrayOf("science", "12:40", "50"),
            arrayOf("music", "12:20", "40"),
            arrayOf("history", "14:00", "30"),
            arrayOf("computer", "12:30", "100")
        )
    )
}

class Solution {
    val dateFormat = SimpleDateFormat("HH:mm")
    val MINUTE_TO_MILLIS = 1000*60L

    fun solution(plans: Array<Array<String>>): Array<String> {
        var answer = mutableListOf<String>()

        var nowTime = dateFormat.parse("00:00")
        val homeworkList = initHomeworkList(plans)
        val watingStack = mutableListOf<Homework>()

        while(watingStack.isNotEmpty() || homeworkList.isNotEmpty()){ //멈춘과제스택과 남은과제 배열이 모두 비었을 때 벗어남
            if(watingStack.isEmpty()){ //멈춘과제스택만 비었을 때
                watingStack.add(homeworkList.removeFirst().also{nowTime = dateFormat.parse(it.startTime)})
            } else if (homeworkList.isEmpty()) { //남은과제배열만 비었을 때
                while(watingStack.isNotEmpty()){
                    answer.add(watingStack.removeLast().name)
                }
            } else if ( //멈춘과제스택의 예상 종료시간이 남은과제1순위의 시작시간 보다 늦을 때
                nowTime.time + MINUTE_TO_MILLIS*watingStack.last().playTime >
                dateFormat.parse(homeworkList.first().startTime).time
            ) {
                watingStack.last().playTime -= minuteStoL(nowTime.time,dateFormat.parse(homeworkList.first().startTime).time)
                nowTime = dateFormat.parse(homeworkList.first().startTime)
                watingStack.add(homeworkList.removeFirst())
            } else if ( //멈춘과제스택의 예상 종료시간이 남은과제1순위의 시작시간과 같을 때
                nowTime.time + MINUTE_TO_MILLIS*watingStack.last().playTime ==
                dateFormat.parse(homeworkList.first().startTime).time
            ) {
                nowTime = Date(nowTime.time + MINUTE_TO_MILLIS*watingStack.last().playTime)
                answer.add(watingStack.removeLast().name)
                watingStack.add(homeworkList.removeFirst())
            } else if ( //멈춘과제스택의 예상 종료시간이 남은과제1순위의 시작시간 보다 빠를 때
                nowTime.time + MINUTE_TO_MILLIS*watingStack.last().playTime <
                dateFormat.parse(homeworkList.first().startTime).time
            ) {
                nowTime = Date(nowTime.time + MINUTE_TO_MILLIS*watingStack.last().playTime)
                answer.add(watingStack.removeLast().name)
            }
        }


        return answer.toTypedArray()
    }

    fun initHomeworkList(plans: Array<Array<String>>):MutableList<Homework> = plans.map{
        Homework(
            it[0],
            it[1],
            it[2].toInt()
        )
    }.sortedBy {
        dateFormat.parse(it.startTime)
    }.toMutableList()

    fun minuteStoL(small: Long, large: Long): Int{
        return ((large - small)/(1000*60)).toInt()
    }

}

data class Homework(
    val name: String,
    val startTime: String,
    var playTime: Int,
)