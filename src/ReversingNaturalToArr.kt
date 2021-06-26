class Solution65 {
    fun solution(n: Long): IntArray = n.toString().reversed().map { it.code - '0'.code }.toIntArray()
}