import java.lang.Math.*

fun main() {
    println(Solution29().solution(3, 2))
}

class Solution29 {
    fun solution(w: Int, h: Int): Long {
        val gcd = gcd(w, h) // 두 수의 최대공약수
        val littleW = w / gcd
        val littleH = h / gcd
        var answer: Long = 0
        val slope = littleH.toDouble() / littleW.toDouble()
        for (i in 1 until littleH)
            for (k in 1 until littleW)
                if (i.toDouble() <= slope * k.toDouble()) {
                    answer += littleW - k
                    break
                }

        answer = (w.toLong() * h.toLong()) - (gcd * (littleH * littleW - (answer * 2)))

        return answer
    }

    fun gcd(a: Int, b: Int): Long {
        var max = max(a, b)
        var min = min(a, b)
        if (min == 0) return max(a, b).toLong()
        else return gcd(min, max % min)
    }
}