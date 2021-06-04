fun main() {
    Solution6().solution(intArrayOf(3, 30, 34, 5, 9))
}

class Solution6 {
    fun solution(numbers: IntArray): String {
        var answer = ""

        val stringNumbers = mutableListOf<String>()
        var sortedNumbers = listOf<String>()

        for (i in 0 until numbers.size) {
            stringNumbers.add(numbers[i].toString())
        }

        sortedNumbers = stringNumbers.sortedWith(Comparator { a, b -> (b + a).compareTo(a + b) })
        //어떤 두 string을 뽑아도 그 순서대로 더한 게 반대보다 큰 경우로 정렬함
        
        for (i in 0 until stringNumbers.size) {
            answer = answer.plus(sortedNumbers[i])
        }

        if (answer.startsWith("0"))
            return "0"
        return answer
    }
}