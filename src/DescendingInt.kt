class Solution68 {
    fun solution(n: Long): Long = String(n.toString().toCharArray().sortedDescending().toCharArray()).toLong()
}