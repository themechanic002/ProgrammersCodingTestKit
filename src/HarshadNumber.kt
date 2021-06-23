class Solution56 {
    fun solution(x: Int): Boolean = x % x.toString().toCharArray().map { it.code - '0'.code }.sum() == 0
}