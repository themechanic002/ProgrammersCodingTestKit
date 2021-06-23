fun main() {
    println(
        Solution48().solution(
            3,
            3,
            arrayOf(intArrayOf(1, 1, 2, 2), intArrayOf(1, 2, 2, 3), intArrayOf(2, 1, 3, 2), intArrayOf(2, 2, 3, 3))
        )
    )
}

class Solution48 {
    var answer = ArrayList<Int>()
    fun solution(rows: Int, columns: Int, queries: Array<IntArray>): ArrayList<Int> {
        var matrix = ArrayList<ArrayList<Int>>()
        for (i in 0 until rows) {
            matrix.add(arrayListOf())
            for (j in 0 until columns)
                matrix[i].add((j + 1) + (columns * i))
        }

        for (i in queries)
            matrix = rotate(matrix, i[0] - 1, i[1] - 1, i[2] - 1, i[3] - 1)
        return answer
    }

    fun rotate(matrix: ArrayList<ArrayList<Int>>, y1: Int, x1: Int, y2: Int, x2: Int): ArrayList<ArrayList<Int>> {

        val newMatrix = ArrayList<ArrayList<Int>>()
        for (i in 0 until matrix.size) {
            newMatrix.add(arrayListOf())
            for (j in 0 until matrix.get(i).size)
                newMatrix[i].add((j + 1) + (matrix.get(i).size * i))
        }

        val mins = ArrayList<Int>()

        for (i in 0 until x2 - x1) {
            newMatrix[y1].set(x1 + i + 1, matrix[y1][x1 + i])
            //newMatrix[y1][x1 + i + 1] = matrix[y1][x1 + i]
        }
        for (i in 0 until y2 - y1) {
            newMatrix[y1 + i + 1].set(x2, matrix[y1 + i][x2])
            //newMatrix[y1 + i + 1][x2] = matrix[y1 + i][x2]
        }
        for (i in 0 until x2 - x1) {
            newMatrix[y2].set(x2 - i - 1, matrix[y2][x2 - i])
            //newMatrix[y2][x2 - i - 1] = matrix[y2][x2 - i]
        }
        for (i in 0 until y2 - y1) {
            newMatrix[y2 - i - 1].set(x1, matrix[y2 - i][x1])
            //newMatrix[y2 - i - 1][x1] = matrix[y2 - i][x1]
        }


        for (i in x1..x2) {
            mins.add(newMatrix[y1][i])
            mins.add(newMatrix[y2][i])
        }
        for (i in y1 + 1 until y2) {
            mins.add(newMatrix[i][x1])
            mins.add(newMatrix[i][x2])
        }

        answer.add(mins.sorted().get(0))

        return newMatrix
    }
}