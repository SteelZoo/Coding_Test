class Solution {
    fun solution(s: String): Int {
        var answer = 0
        val targetStringList = s.toMutableList()

        for (i in s.indices){
            targetStringList.add(targetStringList.removeFirst())
            if (isRightBracket(targetStringList)) answer++
        }


        return answer
    }

    fun isRightBracket(s: MutableList<Char>): Boolean{
        val bracketStack = mutableListOf<Char>()
        for (c in s){
            when(c){
                '(','[','{'->{bracketStack.add(c)}
                ')',']','}'->{
                    if (bracketStack.isEmpty()) return false
                    when(c){
                        ')'->{if (bracketStack.last() == '(') bracketStack.removeLast()}
                        ']'->{if (bracketStack.last() == '[') bracketStack.removeLast()}
                        '}'->{if (bracketStack.last() == '{') bracketStack.removeLast()}
                    }
                }
            }
        }
        return bracketStack.isEmpty()
    }
}