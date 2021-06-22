import java.util.*

class Solution53 {
    fun solution(s: String): Int {
        var count = 0
        var s2 = s
        for (i in 0 until s.length) {
            if (isRight(s2))
                count++
            s2 = s2.substring(1) + s2[0].toString()
        }
        return count
    }

    fun isRight(s: String): Boolean {
        val stack = Stack<Char>()

        for (i in s) {
            when (i) {
                '(' -> stack.push('(')
                '{' -> stack.push('{')
                '[' -> stack.push('[')
                ')' -> {
                    if (stack.isEmpty() || stack.lastElement() != '(')
                        return false
                    else
                        stack.pop()
                }
                '}' -> {
                    if (stack.isEmpty() || stack.lastElement() != '{')
                        return false
                    else
                        stack.pop()
                }
                ']' -> {
                    if (stack.isEmpty() || stack.lastElement() != '[')
                        return false
                    else
                        stack.pop()
                }
            }
        }
        return stack.isEmpty()
    }
}