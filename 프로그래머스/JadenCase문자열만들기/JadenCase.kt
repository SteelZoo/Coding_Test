class Solution {
    fun solution(s: String): String {
        var stringBuilder = StringBuilder()

        s.forEachIndexed{index, char ->
            if (index == 0){
                stringBuilder.append(char.uppercaseChar())
            } else if (s[index-1] == ' '){
                stringBuilder.append(char.uppercaseChar())
            } else {
                stringBuilder.append(char.lowercaseChar())
            }
        }

        return stringBuilder.toString()
    }
}