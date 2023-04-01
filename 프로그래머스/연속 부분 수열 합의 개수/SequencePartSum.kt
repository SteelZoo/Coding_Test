class Solution {
    fun solution(elements: IntArray): Int {
        var answer: Int = 0

        val elementsTwice = mutableListOf<Int>()
        for (i in 0 until elements.size*2){
            elementsTwice.add(elements[i%elements.size])
        }

        val sumSet = mutableSetOf<Int>()
        for(i in elements.indices){
            elements.forEachIndexed { index, element ->
                var sum = 0
                for (j in index .. index+i){
                    sum += elementsTwice[j]
                }
                sumSet.add(sum)
            }
        }
        answer += sumSet.size

        return answer
    }
}