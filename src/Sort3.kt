class Solution8 {
    fun solution(array: IntArray, commands: Array<IntArray>): MutableList<Int> {
        var answer = mutableListOf<Int>()

        for (i in 0 until commands.size) {

            val tempArray = mutableListOf<Int>()

            for (j in commands[i][0]..commands[i][1])
                tempArray.add(array[j - 1])
            tempArray.sort()
            answer.add(tempArray[commands[i][2] - 1])
        }
        return answer
    }
}