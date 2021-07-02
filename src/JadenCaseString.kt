class Solution73 {
    fun solution(s: String): String {
        var answer = ""
        s.forEach {
            if(it == ' ')
                answer += " "
            else if(answer.isBlank() || answer.last() == ' ')
                answer += it.uppercase()
            else
                answer += it.lowercase()
        }
        return answer
    }
}