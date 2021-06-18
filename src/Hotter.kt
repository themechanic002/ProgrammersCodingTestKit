fun main() {
    println(Solution38().solution(intArrayOf(1, 2, 3, 9, 10, 12), 7))
}

class Solution38 {
    fun solution(scoville: IntArray, K: Int): Int {
        val newScoville = ArrayList<Int>()
        for (i in 0 until scoville.size)
            newScoville.add(scoville[i])
        newScoville.sort()

        var count = 0
        while (newScoville[0] < K) {
            if (newScoville.filter { it == 0 }.size > 1)
                return -1
            else if (newScoville.size <= 1)
                return count
            count++
            newScoville.add(newScoville[0] + (newScoville[1] * 2))
            newScoville.removeAt(1)
            newScoville.removeAt(0)
            newScoville.sort()
        }
        return count
    }
}