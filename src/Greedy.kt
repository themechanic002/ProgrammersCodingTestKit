fun main() {
    println(Solution12().solution(5, intArrayOf(), intArrayOf(1, 2, 3, 4, 5)))
}

class Solution12 {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        var answer = 0
        lost.sort()
        reserve.sort()
        val all = ArrayList<Int>()
        for (i in 0 until n + 2)
            all.add(1)
        for (i in reserve)
            all[i - 1]++
        for (i in lost)
            all[i - 1]--
        for (i in 0 until n)
        //어떤 애가 두벌
            if (all[i] == 2) {
                //앞에 애가 없을 경우
                if (i > 0 && all[i - 1] <= 0) {
                    all[i]--
                    all[i - 1]++
                }
                //뒤에 애가 없을 경우
                else if (all[i + 1] <= 0) {
                    all[i]--
                    all[i + 1]++
                }
            }
        for (i in 0 until n)
            if (all[i] >= 1)
                answer++

        return answer
    }
}