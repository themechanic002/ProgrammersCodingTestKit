fun main() {
    println(
        Solution33().solution(
            arrayOf(
                intArrayOf(0, 0, 0, 0, 0),
                intArrayOf(0, 0, 1, 0, 3),
                intArrayOf(0, 2, 5, 0, 1),
                intArrayOf(4, 2, 4, 4, 2),
                intArrayOf(3, 5, 1, 3, 1)
            ),
            intArrayOf(1, 5, 3, 5, 1, 2, 1, 4)
        )
    )
}

class Solution33 {
    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        val basket = ArrayList<Int>()
        var disappeared = 0

        for (i in 0 until moves.size) {
            for (b in 0 until board.size) {
                val item = board[b][moves[i] - 1]
                if (item != 0) {
                    basket.add(item)
                    board[b].set(moves[i] - 1, 0)
                    break
                }
            }

            if (basket.size > 1 && basket[basket.lastIndex] == basket[basket.lastIndex - 1]) {
                basket.removeAt(basket.lastIndex)
                basket.removeAt(basket.lastIndex)
                disappeared += 2
            }
        }

        return disappeared
    }
}