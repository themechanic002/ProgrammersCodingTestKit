class Solution73 {
    fun solution(s: String): String {
        val arr = s.replace("\\s+".toRegex(), " ").split(" ")
        var answer = ""
        arr.forEach {
            answer += jadenCase(it)
            if (arr.indexOf(it) != arr.lastIndex)
                answer += " "
        }
        return answer
    }

    fun jadenCase(s: String): String {
        if (s.length == 1)
            return s.uppercase()
        else
            return s[0].uppercase() + s.substring(1).lowercase()
    }
}