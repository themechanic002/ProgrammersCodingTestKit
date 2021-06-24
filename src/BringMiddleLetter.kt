fun main() {
    Solution39().solution("123456")
}

class Solution39 {
    fun solution(s: String): String =
        if (s.length % 2 == 0) (s[s.length / 2 - 1].toString() + s[s.length / 2]) else s[s.length / 2].toString()
}