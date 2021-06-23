class Solution59 {
    fun solution(n: Int): Int {
        var answer = 0
        return answer
    }

    fun fibonacci(n: Long): Long {

        var first = 0L
        var second = 1L
        return when (n) {
            1L -> first
            2L -> second
            else -> {
                var temp = first + second
                for (i in 3..n) {
                    temp = first + second
                    first = second
                    second = temp
                }
                temp
            }
        }

    }
}