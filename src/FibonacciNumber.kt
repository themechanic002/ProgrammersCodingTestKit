class Solution59 {
    fun solution(n: Int): Int = fibonacci(n) % 1234567

    fun fibonacci(n: Int): Int {
        var first = 0
        var second = 1
        return when (n) {
            0 -> first
            1 -> second
            else -> {
                var temp = (first + second) % 1234567
                for (i in 2..n) {
                    temp = (first + second) % 1234567
                    first = second
                    second = temp
                }
                temp
            }
        }
    }
}