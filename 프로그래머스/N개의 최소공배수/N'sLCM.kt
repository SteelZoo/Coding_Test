class Solution {
    fun solution(arr: IntArray): Int {
        var answer = lcm(arr[0],arr[1])

        if(arr.size>2){
            for (i in 2 until arr.size){
                answer = lcm(answer,arr[i])
            }
        }


        return answer
    }


    fun lcm(a: Int, b: Int): Int{
        return (a*b)/gcd(a,b)
    }

    fun gcd(a: Int, b: Int): Int{
        var bigger = 0
        var smaller = 0
        var remain = -1

        if (a>b) {
            bigger = a
            smaller = b
        }
        else {
            bigger = b
            smaller = a
        }

        while (smaller != 0){
            remain = bigger%smaller
            bigger = smaller
            smaller = remain
        }

        return bigger
    }
}