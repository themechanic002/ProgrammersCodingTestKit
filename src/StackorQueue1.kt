import java.util.*

fun main() {
    Solution3().solution(intArrayOf(93, 30, 55), intArrayOf(1, 30, 5))
}

class Solution3 {
    fun solution(progresses: IntArray, speeds: IntArray): MutableList<Int> {
        var answer = mutableListOf<Int>()

        val leftDay: Queue<Int> = LinkedList()
        for (i in 0 until progresses.size) {
            if ((100 - progresses[i]) % speeds[i] > 0)
                leftDay.add((100 - progresses[i]) / speeds[i] + 1)
            else
                leftDay.add((100 - progresses[i]) / speeds[i])
        }

        while (!leftDay.isEmpty()) { //비워질 때까지 계속
            if (leftDay.peek() <= 0) {
                answer.add(0)

                while (leftDay.peek() <= 0) {
                    leftDay.remove()
                    answer.set(answer.lastIndex, answer.last() + 1)
                    if (leftDay.isEmpty())
                        break
                }

            } else {
                val loop = leftDay.size
                for (i in 0 until loop) {
                    leftDay.add(leftDay.peek() - 1)
                    leftDay.remove()
                }
            }
        }
        return answer
    }
}