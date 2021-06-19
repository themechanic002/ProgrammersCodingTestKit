class Solution46 {
    fun solution(s: String, n: Int): String {
        var answer = ""
        s.forEach {
            when (it) {
                'z' -> answer += ('a'.code + n - 1).toChar()
                'Z' -> answer += ('A'.code + n - 1).toChar()
                else -> answer += (it.code + n).toChar()
            }
        }
        return answer
    }
}