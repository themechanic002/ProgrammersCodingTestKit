class Solution42 {
    fun solution(a: Int, b: Int): Long {
        var answer: Long = 0
        val small: Int
        val big: Int
        if(a>b){
            small = b
            big = a
        }else{
            small = a
            big = b
        }
        for(i in small .. big)
            answer += i
        return answer
    }
}