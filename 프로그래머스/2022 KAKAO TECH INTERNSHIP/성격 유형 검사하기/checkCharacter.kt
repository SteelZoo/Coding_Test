import kotlin.math.*

class Solution {
    val characterList = listOf("R","T","C","F","J","M","A","N")
    val scoreList = MutableList(8, { 0 })

    fun solution(survey: Array<String>, choices: IntArray): String {
        val answer = StringBuilder()

        for (index in survey.indices){
            when(choices[index]){
                1,2,3 -> {
                    addScore(survey[index][0].toString(),abs(choices[index]-4))
                }
                5,6,7 -> {
                    addScore(survey[index][1].toString(),abs(choices[index]-4))
                }
            }
        }
        answer.append(getHigherCharacter("R","T"))
        answer.append(getHigherCharacter("C","F"))
        answer.append(getHigherCharacter("J","M"))
        answer.append(getHigherCharacter("A","N"))


        return answer.toString()
    }

    fun addScore(key: String, score: Int){
        scoreList[characterList.indexOf(key)] += score
    }

    fun getHigherCharacter(first: String, second: String): String{
        return if (scoreList[characterList.indexOf(first)] < scoreList[characterList.indexOf(second)]) second else first
    }
}