fun main() {
    println(Solution28().solution("bbaabaaaab"))
}

class Solution28 {
    fun solution(s: String): Int {
        var answer = ArrayList<String>()
        answer.add(s)

        for (i in 1..(s.length) / 2) { //글자 한 집합의 길이
            var one = s
            var makingOne = ""
            val tempArray = ArrayList<String>()
            for (k in 0 until (one.length) / i) //tempArray에 글자 집합끼리 뭉쳐서 넣어놓기
                tempArray.add(one.substring(i * k, (i * k) + i))
            tempArray.add(one.substring((one.length / i) * i))


            for (j in tempArray) { //한 집합마다
                var count = 1
                var index = tempArray.indexOf(j)
                while (j != "") {
                    if (index + 1 > tempArray.lastIndex) {
                        break
                    }
                    if (tempArray[index] == tempArray[index + 1]) { //어떤 글자 집합이 바로 다음 글자 집합이랑 똑같다면
                        index++
                        count++
                    } else {
                        break
                    }
                }
                when (count > 1) { //똑같은 게 한 번이면 의미 없으니까 2번 이상일 때부터 숫자로 변환
                    true -> {
                        makingOne = makingOne + count + j
                        for (m in 1 until count) {
                            if (tempArray.indexOf(j) + m > tempArray.lastIndex)
                                break
                            tempArray.set(tempArray.indexOf(j) + m, "")
                        }
                    }
                    false -> makingOne = makingOne + j
                }
            }
            answer.add(makingOne)
        }

        return answer.sortedBy { it.length }.first().length
    }
}