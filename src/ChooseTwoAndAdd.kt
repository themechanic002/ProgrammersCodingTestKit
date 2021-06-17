class Solution37 {
    fun solution(numbers: IntArray): List<Int> {
        var answer = ArrayList<Int>()
        for(i in 0 until numbers.size - 1)
            for(j in i + 1 until numbers.size)
                answer.add(numbers[i] + numbers[j])
        return answer.sorted().distinct()
    }
}