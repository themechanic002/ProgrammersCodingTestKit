import java.lang.Math.*

class Solution75 {
    fun solution(n: Int, m: Int): IntArray {
        var answer = intArrayOf()
        return answer
    }

    fun lcm( a:Int, b:Int):Int {
        var maximum = max(a, b)
        var minimum = min(a, b)
        return (a * b) / gcd(a, b)
    }

    fun gcd(a: Int, b: Int): Int {
        var maximum = max(a, b)
        var minimum = min(a, b)
        if (minimum == 0)
            return max(a, b)
        else
            return gcd(minimum, maximum % minimum)
    }
}