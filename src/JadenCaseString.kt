class Solution73 {
    fun solution(s: String): String {
        var answer = ""
        val str = s.replace("\\s+".toRegex(), " ")
        str.forEach {
            if(it == ' ')
                answer += " "
            else if(it == s.first())
                answer += it.uppercase()
            else if(answer.last() == ' ')
                answer += it.uppercase()
            else
                answer += it.lowercase()
        }
        return answer
    }
}