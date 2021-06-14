import java.util.*

fun main() {
    println(
        Solution22().solution(
            intArrayOf(2, 1, 3, 2), 2
        )
    )
}

class Solution22 {
    fun solution(priorities: IntArray, location: Int): Int {
        var answer = 0
        var count = 0

        // <문서 이름, 중요도>
        val docu = LinkedList<Pair<Int, Int>>()
        for (i in 0 until priorities.size)
            docu.add(Pair(i, priorities[i]))

        while (true) {
            var ableToPrint: Boolean = true
            for (i in 1 until docu.size)
                if (docu.get(0).second < docu.get(i).second) {
                    ableToPrint = false
                    break
                }
            if (ableToPrint == true) {
                count++
                if (docu.get(0).first == location)
                    return count
                docu.poll()
            } else {
                docu.add(docu.get(0))
                docu.poll()
            }
        }
        return count
    }
}