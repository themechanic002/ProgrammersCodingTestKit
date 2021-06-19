class Solution45 {
    fun solution(n: Int): String {
        var answer = ""
        if (n % 2 == 0)
            for (i in 0 until n / 2)
                answer += "수박"
        else {
            for (i in 0 until (n + 1) / 2)
                answer += "수박"
            answer.substring(0, n)
        }
        return answer
    }
}