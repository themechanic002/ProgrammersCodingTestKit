fun main() {
    println(MySolution().solution(intArrayOf(3, 2, 4, 4, 2, 5, 2, 5, 5)).toString())
}

class MySolution {

    fun solution(answer: IntArray): MutableList<Int?> {

        val sortedAnswer = answer.sorted().groupBy { it }
        val myanswer = mutableListOf<Int?>()

        for (i in sortedAnswer.keys) {
            if (sortedAnswer.get(i)?.size == 1) {
                continue
            }
            myanswer.add(sortedAnswer.get(i)?.size)
        }
        if (myanswer.isEmpty())
            myanswer.add(-1)
        return myanswer
    }
}