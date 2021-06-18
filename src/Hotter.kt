import java.util.*

fun main() {
    println(Solution38().solution(intArrayOf(1, 2, 3, 9, 10, 12), 7))
}

class Solution38 {
    fun solution(scoville: IntArray, K: Int): Int {
        var count = 0

        val heapScoville = PriorityQueue<Int>()
        val heapScovilleOverK = PriorityQueue<Int>()
        scoville.forEach { if (it < K) heapScoville.add(it) else heapScovilleOverK.add(it) }

        while (heapScoville.peek() < K) {
            if (heapScoville.size == 1)
                if (heapScovilleOverK.size == 0)
                    return -1
                else
                    return count + 1
            else if (heapScoville.size == 0)
                return count

            val first = heapScoville.poll()
            val second = heapScoville.poll()

            if (first + second == 0)
                return -1
            else {
                count += 1
                val new = first + (second * 2)
                if (new < K)
                    heapScoville.add(new)
                else {
                    heapScovilleOverK.add(new)
                    if (heapScoville.size == 0)
                        return count
                }
            }
        }
        return count
    }
}