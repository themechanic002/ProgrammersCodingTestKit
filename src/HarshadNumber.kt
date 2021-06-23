class Solution56 {
    fun solution(x: Int): Boolean = x % x.toString().map { it.code - '0'.code }.sum() == 0
}