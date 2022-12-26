class Solution {
    fun solution(answers: IntArray): IntArray {

        val supojaList = listOf(
            Supoja(listOf(1, 2, 3, 4, 5)),
            Supoja(listOf(2, 1, 2, 3, 2, 4, 2, 5)),
            Supoja(listOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5))
        )

        supojaList.forEach {
            it.score = checkScore(answers, it.pattern)
        }

        return getAnswer(supojaList)
    }

    fun getAnswer(supojaList: List<Supoja>): IntArray {
        val answer = mutableListOf<Int>()

        supojaList.forEachIndexed { index, supoja ->
            if (answer.isEmpty()) {
                answer.add(index + 1)
            } else if (supojaList[answer[0]-1].score == supoja.score) {
                answer.add(index + 1)
            } else if (supojaList[answer[0]-1].score < supoja.score) {
                answer.clear()
                answer.add(index + 1)
            }
        }

        return answer.toIntArray()
    }

    fun checkScore(answers: IntArray, pattern: List<Int>): Int {
        var result = 0
        answers.forEachIndexed { index, s ->
            if (s == pattern[index % pattern.size]) {
                result++
            }
        }
        return result
    }


    data class Supoja(
        val pattern: List<Int> = listOf(),
        var score: Int = 0
    )
}