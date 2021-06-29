class Solution68 {
    fun solution(n: Long): Long {
        return n.toString().toCharArray().sortedDescending().toString().toLong()
    }
}