class Solution51 {
    fun solution(strings: Array<String>, n: Int): List<String> = strings.sortedWith(compareBy({ it[n] }, { it }))
}