class Solution49 {
    fun solution(s: String): String {
        val numArray = ArrayList<Int>()
        var answer = ""
        s.split(" ").forEach {
            if (it.contains("-"))
                numArray.add(0 - it.replace("-", "").toInt())
            else
                numArray.add(it.toInt())
        }
        answer += numArray.sorted().first().toString()
        answer += " "
        answer += numArray.sorted().last().toString()
        return answer
    }
}