class Solution69 {
    fun solution(seoul: Array<String>): String {
        return "김서방은 " + seoul.indexOf(seoul.find { it == "Kim" }) + "에 있다"
    }
}