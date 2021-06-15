import java.lang.Math.*

fun main() {
    println(Solution30().solution(3, 2))
}

class Solution30 {
    fun solution(w: Int, h: Int): Long {
        val gcd = gcd(w, h) // 두 수의 최대공약수
        val littleW = w / gcd
        val littleH = h / gcd
        return w.toLong() * h.toLong() - (gcd * (littleW + littleH - 1))
    }

    fun gcd(a: Int, b: Int): Long {
        var max = max(a, b)
        var min = min(a, b)
        if (min == 0) return max(a, b).toLong()
        else return gcd(min, max % min)
    }
}