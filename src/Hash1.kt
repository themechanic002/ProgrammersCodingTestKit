import java.util.*

fun main() {
    Solution().solution(
        clothes = arrayOf(
            arrayOf("yellow_hat", "headgear"),
            arrayOf("blue_sunglasses", "eyewear"),
            arrayOf("green_turban", "headgear")
        )
    )
}


class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        var answer = 0

        val hashMap = TreeMap<String, Int>()
        val list = mutableListOf<String>()

        for (i in 0 until clothes.size) {

            if (hashMap.containsKey(clothes.get(i).get(1))) {
                hashMap.put(clothes.get(i).get(1), hashMap.getValue(clothes.get(i).get(1)) + 1)
            } else {
                hashMap.put(clothes.get(i).get(1), 1)
                list.add(clothes.get(i).get(1))
            }

        }
        if (hashMap.size == 0) {
            answer = 0
        } else {
            answer = 1

            for (i in 0 until list.size) {
                answer *= (hashMap.getValue(list[i]) + 1)
            }
            answer -= 1
        }
        
        return answer
    }
}