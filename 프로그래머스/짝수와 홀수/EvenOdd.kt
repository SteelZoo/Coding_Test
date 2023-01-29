class Solution {
    fun solution(num: Int): String {
        return num.let{
            if (it % 2 == 1 || it % 2 == -1) "Odd"
            else "Even"
        }
    }
}