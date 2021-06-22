import java.util.*
import kotlin.collections.ArrayList

class Solution53 {
    fun solution(s: String): Int {
        var answer: Int = -1
        return answer
    }

    fun isRight(s: String): Boolean {
        val stack1 = Stack<Char>()
        val stack2 = Stack<Char>()
        val stack3 = Stack<Char>()

        for(i in s){
            when(i){
                '(' -> stack1.push('(')
                '{' -> stack2.push('{')
                '[' -> stack3.push('[')
                ')' -> {
                    if(stack1.isEmpty())
                        return false
                    else
                        stack1.pop()
                }
                '}' -> {
                    if(stack2.isEmpty())
                        return false
                    else
                        stack2.pop()
                }
                ']' -> {
                    if(stack3.isEmpty())
                        return false
                    else
                        stack3.pop()
                }
            }
        }
        return stack1.isEmpty() && stack2.isEmpty() && stack3.isEmpty()
    }
}