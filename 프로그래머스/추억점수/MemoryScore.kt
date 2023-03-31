class Solution {
    fun solution(name: Array<String>, yearning: IntArray, photo: Array<Array<String>>): IntArray {
        var answer = mutableListOf<Int>()

        photo.forEach{ each ->
            var score = 0
            each.forEach{ person ->
                val index = name.indexOf(person)
                if(index>=0){
                    score += yearning[index]
                }
            }
            answer.add(score)
        }

        return answer.toIntArray()
    }
}