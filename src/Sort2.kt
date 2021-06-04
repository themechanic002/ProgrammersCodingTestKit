import java.util.*

fun main() {
    println(Solution7().solution(intArrayOf(0,0,0,0,0)))
}

class Solution7 {
    fun solution(citations: IntArray): Int {
        var answer = 0
        val queue: Queue<Int> = LinkedList<Int>()
        val sortedArray = citations.sortedArray()

        for (i in 0 until citations.size)
            queue.add(sortedArray[i])

        val index = queue.size

        if (sortedArray.last() == 0)
            return 0

        for (i in 0..index) {

            if (i <= queue.size)
                answer = i
            else
                break

            if (i >= queue.first())
                queue.remove()
        }
        return answer
    }
}