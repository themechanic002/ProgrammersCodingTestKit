class Solution64 {
    fun solution(s: String): String {
        var answer = ""
        var index = 0
        for (i in s) {
            if (i == ' ') {
                answer += " "
                index = 0
            } else if (index % 2 == 0) {
                answer += i.toString().uppercase()
                index++
            } else if (index % 2 == 1) {
                answer += i.toString().lowercase()
                index++
            }
        }
        return answer
    }
}