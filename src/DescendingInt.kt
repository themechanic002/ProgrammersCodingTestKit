class Solution68 {
    fun solution(n: Long): Long {
        return String(n.toString().toCharArray().sortedDescending().toCharArray()).toLong()
    }
}