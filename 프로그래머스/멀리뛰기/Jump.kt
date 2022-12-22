class Jump {
    fun solution(n: Int): Long {
        if(n<3) return n.toLong()

        var answer: Long = 0
        val list = LongArray(n+1)
        list[1] = 1
        list[2] = 2

        for(i in 3..n){
            list[i] = (list[i-1] + list[i-2])%1234567
        }

        answer = list[n]%1234567
        return answer
    }
}