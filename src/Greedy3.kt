fun main() {
    println(Solution14().solution("1234", 3))
}

class Solution14 {
    val answerList = ArrayList<Int>()

    fun solution(number: String, k: Int): String {
        var answer = ""
        var answerSize = number.length - k

        pick(number, answerSize)

        for (i in answerList)
            answer += i.toString()
        return answer
    }

    fun pick(restNumber: String, answerSize: Int): String {
        if (answerSize == 0)
            return ""
        var max: Int = 0
        var maxI: Int = 0
        var nextmax: Int = 0
        var nextmaxI: Int = 0
        for (i in 0..restNumber.length - answerSize) {
            if (toInt(restNumber[i]) == 9) {
                max = 9
                maxI = i
                break
            } else if (toInt(restNumber[i]) > max) {
                max = toInt(restNumber[i])
                maxI = i
            }
        }
        answerList.add(max)
        return pick(restNumber.substring(maxI + 1), answerSize - 1)
    }

    fun toInt(num: Char) = num.code - 48
}