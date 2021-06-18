class Solution40 {
    fun solution(a: Int, b: Int): String {
        val months = arrayListOf(31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30)
        var day = 0
        for (i in 0 until a - 1)
            day += months[i]
        day += b
        when (day % 7) {
            0 -> return "THU"
            1 -> return "FRI"
            2 -> return "SAT"
            3 -> return "SUN"
            4 -> return "MON"
            5 -> return "TUE"
            else -> return "WED"
        }
    }
}