fun main() {
    println(Solution28().solution("aabbaccc"))
}

class Solution28 {
    fun solution(s: String): Int {
        var answer = ArrayList<String>()

        for (i in 1..(s.length) / 2) { //글자 한 집합의 길이
            var one = ""
            for (j in 0 until s.length - i) { //글자를 한칸씩 오른쪽으로 옮기면서 중복 찾기
                var count = 0
                val tempArray = ArrayList<String>()
                var temp = s.substring(j)
                while (temp[i - 1] != null) {
                    tempArray.add(temp.substring(0, i))
                    temp = temp.substring(i)
                }
                for (k in 0 until tempArray.size) {
                    if (tempArray[k + 1] != null && tempArray[k] == tempArray[k + 1])
                        count++
                    else {
                        one = one + count.toString() + tempArray[k]
                        if (tempArray[k + 1] != null)
                            for (l in k until tempArray.size)
                                one = one + tempArray[k]
                        break
                    }
                }
            }
            answer.add(one)
        }

        return answer.sortedBy { it.length }.first().length
    }
}