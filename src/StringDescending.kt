class Solution43 {
    fun solution(s: String): String {
        val list = ArrayList<Char>()
        var answer = ""
        for (i in s)
            list.add(i)
        list.sortDescending()
        for (i in list)
            answer += i.toString()
        return answer
    }
}