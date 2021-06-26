class Solution65 {
    fun solution(n: Long): List<Int> = n.toString().reversed().map{ it.toInt() - '0'.toInt() }.toList()
}