class Solution71 {
    fun solution(num: Int): Int {
        var n = num.toLong()
        var count = 0
        while (n != 1L) {
            if (count >= 500)
                return -1
            n = collatz(n)
            count++
        }
        return count
    }

    fun collatz(num: Long): Long = if (num % 2L == 0L) num / 2L else (num * 3L) + 1L
}