class Solution48 {
    fun solution(rows: Int, columns: Int, queries: Array<IntArray>): IntArray {
        var matrix = ArrayList<ArrayList<Int>>()
        var index = 0
        for (i in 0 until rows) {
            matrix.add(arrayListOf())
            for (j in 0 until columns) {
                index++
                matrix[i].add(index)
            }
        }
        queries.forEach {

            val rec = ArrayList<Int>()
            for (i in matrix[it.get(0) - 1][it.get(1) - 1] until matrix[it.get(0) - 1][it.get(3)] - 1) {
                rec.add(i)
            }
            for (i in matrix[it.get(0) - 1][it.get(3) - 1] until matrix[it.get(2) - 1][it.get(3) - 1] step columns) {
                rec.add(i)
            }
            for (i in matrix[it.get(2) - 1][it.get(3) - 1] downTo matrix[it.get(2) - 1][it.get(0) + 1 - 1]) {
                rec.add(i)
            }
            for (i in matrix[it.get(2) - 1][it.get(0) - 1] downTo matrix[it.get(0) + 1 - 1][it.get(1) - 1] step columns) {
                rec.add(i)
            }

            val first = rec[0]
            for(i in 0 until rec.size){
                if(i == rec.size - 1)
                    rec.set(i, first)
                else
                    rec.set(i, rec[i + 1])
            }


        }


        return answer
    }
}