class Solution73 {
    fun solution(s: String): String {
        val arr = s.split(" ")
        var answer = ""
        arr.forEach {
            answer += it[0].uppercase()
            answer += it.substring(1).lowercase()
            if(arr.indexOf(it) != arr.lastIndex)
                answer += " "
        }
        return answer
    }
}