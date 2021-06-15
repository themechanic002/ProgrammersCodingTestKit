import java.lang.Math.*

fun main() {
    println(Solution31().solution(intArrayOf(1, 2, 3, 4)))
}

class Solution31 {
    fun solution(nums: IntArray): Int {
        val array = ArrayList<Int>()
        for (a in 0..nums.size - 3)
            for (b in a + 1..nums.size - 2)
                for (c in b + 1..nums.size - 1)
                    array.add(nums[a] + nums[b] + nums[c])
        return array.filter { isPrime(it) }.size
    }

    fun isPrime(num: Int): Boolean {
        for (i in 2..sqrt(num.toDouble()).toInt())
            if (num % i == 0)
                return false
        return true
    }
}