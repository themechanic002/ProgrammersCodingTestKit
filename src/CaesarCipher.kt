class Solution46 {
    fun solution(s: String, n: Int): String {
        var answer = ""
        s.forEach {
            answer += translator(it, n)
        }
        return answer
    }

    fun translator(c: Char, n: Int): Char {
        var newC = c
        for (i in 0 until n) {
            when (newC) {
                ' ' -> return ' '
                'z' -> newC = 'a'
                'Z' -> newC = 'A'
                else -> newC = (newC.code + 1).toChar()
            }
        }
        return newC
    }
}