import java.lang.Math.sqrt

fun main() {
    Solution35().solution(13, 17)
}

class Solution35 {
    fun solution(left: Int, right: Int): Int {
        var answer: Int = 0
        for (i in left..right) {
            if (numberOfDivisor(i) % 2 == 0)
                answer += i
            else
                answer -= i
            println(answer)
        }
        return answer
    }

    fun numberOfDivisor(number: Int): Int {
        var count = 0
        for (i in 1..number) {
            if (number % i == 0)
                count++
        }
        return count
    }
}