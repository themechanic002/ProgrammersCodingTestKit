class Solution58 {
    fun solution(phone_number: String): String = String(phone_number.substring(0, phone_number.lastIndex - 3).map { '*' }.toCharArray()) + phone_number.substring(phone_number.lastIndex - 3)
}