class Solution9 {
    fun solution(answers: IntArray): MutableList<Int> {
        var answer = mutableListOf<Int>()

        var num1 = 0
        var num2 = 0
        var num3 = 0

        val score = mutableMapOf<Int, Int>()


        for (i in 0 until answers.size) {
            val temp = (i % 5) + 1
            if (temp == answers.get(i))
                num1++
        }

        for (i in 0 until answers.size) {
            var temp = 0
            when (i % 8) {
                1 -> temp = 1
                3 -> temp = 3
                5 -> temp = 4
                7 -> temp = 5
                else -> temp = 2
            }
            if (temp == answers.get(i))
                num2++
        }

        for (i in 0 until answers.size) {
            var temp = 0
            when (i % 10) {
                0, 1 -> temp = 3
                2, 3 -> temp = 1
                4, 5 -> temp = 2
                6, 7 -> temp = 4
                8, 9 -> temp = 5
            }
            if (temp == answers.get(i))
                num3++
        }

        score.put(1, num1)
        score.put(2, num2)
        score.put(3, num3)

        val scoreList = score.toList().sortedWith(compareBy({ -it.second }, { it.first }))


        answer.add(scoreList.get(0).first)
        if(scoreList.get(0).second == scoreList.get(1).second)
            answer.add(scoreList.get(1).first)
        if(scoreList.get(0).second == scoreList.get(2).second)
            answer.add(scoreList.get(2).first)


        return answer
    }
}