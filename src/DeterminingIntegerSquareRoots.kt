import kotlin.math.*

class Solution61 {
    fun solution(n: Long): Long {
        if(isSquareRoot(n.toDouble()))
            return (sqrt(n.toDouble()) + 1.0).pow(2).toLong()
        else return -1L
    }
    fun isSquareRoot(n: Double): Boolean = sqrt(n).toInt().toDouble().pow(2) == n
}