import kotlin.math.sqrt

class Solution11 {
    fun solution(brown: Int, yellow: Int): ArrayList<Int> {
        var answer = ArrayList<Int>()
        val AB = brown + yellow
        for (a in 1..sqrt(AB.toDouble()).toInt())
            if (AB % a == 0 && a + (AB / a) == (brown + 4) / 2) {
                answer.add(AB / a)
                answer.add(a)
            }
        return answer
    }
}