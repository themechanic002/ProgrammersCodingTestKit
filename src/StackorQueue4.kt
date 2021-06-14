import java.util.*
import kotlin.collections.ArrayList

fun main() {
    println(Solution24().solution(intArrayOf(1, 2, 3, 2, 3)))
}

class Solution24 {
    fun solution(prices: IntArray): ArrayList<Int> {
        val answer = ArrayList<Int>()
        val pricesQueue = LinkedList<Int>()
        prices.forEach { pricesQueue.add(it) }

        while (pricesQueue.isNotEmpty()) {
            var count = 0
            while (true) {
                if (count == pricesQueue.size - 1) {
                    answer.add(count)
                    break
                } else if (pricesQueue.first <= pricesQueue[count + 1])
                    count++
                else {
                    answer.add(++count)
                    break
                }
            }
            pricesQueue.poll()
        }
        return answer
    }
}