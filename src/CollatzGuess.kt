class Solution71 {
    fun solution(num: Int): Int {
        var n = num
        var count = 0
        while (n != 1) {
            if (count == 500)
                return -1
            n = collatz(n)
            count++
        }
        return count
    }
    fun collatz(num: Int): Int = if (num % 2 == 0) num / 2 else num * 3 + 1
}