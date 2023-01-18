import java.text.SimpleDateFormat
import java.util.Calendar

class Solution {
    fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
        val answer = mutableListOf<Int>()

        val dateformat = SimpleDateFormat("yyyy.MM.dd")
        val termsMap = setTerms(terms)
        val today = dateformat.parse(today)

        for (index in privacies.indices) {
            val limitMonth = termsMap[privacies[index].split(" ")[1]]

            limitMonth?.let {
                val calendar = Calendar.getInstance()
                calendar.time = dateformat.parse(privacies[index].split(" ")[0])
                calendar.add(Calendar.MONTH, limitMonth)


                if (today >= calendar.time) {
                    answer.add(index + 1)
                }
            }
        }

        return answer.toIntArray()
    }

    fun setTerms(terms: Array<String>): HashMap<String, Int> {
        var result = hashMapOf<String, Int>()

        terms.forEach { string ->
            result[string[0].toString()] = string.split(" ")[1].toInt()
        }

        return result
    }
}