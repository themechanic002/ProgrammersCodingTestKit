import java.util.*

fun main() {
    println(Solution52().solution("(()())()"))
}

class Solution52 {
    fun solution(p: String): String {
        return convert(p)
    }

    fun convert(p: String): String {
        if (p.isBlank()) return ""

        var u = ""
        var v = ""
        for (i in 0 until p.length) {
            u += p[i].toString()
            if (isBalanced(u))
                break
        }
        if (u.lastIndex != p.lastIndex)
            v = p.substring(u.lastIndex + 1)

        if (isRight(u))
            return u + convert(v)
        else
            return "(" + convert(v) + ")" + reverse(u.substring(1, u.lastIndex))

    }

    fun isRight(p: String): Boolean {
        val stack = Stack<Char>()
        for (i in p) {
            if (i == '(')
                stack.push('(')
            else if (i == ')') {
                if (stack.isEmpty())
                    return false
                else
                    stack.pop()
            }
        }
        return stack.isEmpty()
    }

    fun isBalanced(p: String): Boolean =
        p.toCharArray().filter { it == '(' }.size == p.toCharArray().filter { it == ')' }.size

    fun reverse(p: String): String {
        var temp = ""
        for (i in p) {
            if (i == '(')
                temp += ")"
            else if (i == ')')
                temp += "("
        }
        return temp
    }
}