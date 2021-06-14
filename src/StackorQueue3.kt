import java.util.*

fun main() {
    println(Solution23().solution(100, 100, intArrayOf(10)))
}

class Solution23 {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        var time = 0
        val crossingTrucks = LinkedList<Int>()
        val truckWeights = LinkedList<Int>()
        val eachTime = LinkedList<Int>()
        truck_weights.forEach {
            truckWeights.add(it)
        }

        while (crossingTrucks.isNotEmpty() || truckWeights.isNotEmpty()) {
            time++
            for (i in 0 until eachTime.size) {
                eachTime.set(i, eachTime.get(i) + 1)
            }

            if (eachTime.size != 0 && eachTime.first >= bridge_length) {
                crossingTrucks.poll()
                eachTime.poll()
            }
            if (truckWeights.size != 0 && crossingTrucks.sum() + truckWeights.first <= weight) {
                crossingTrucks.add(truckWeights.first)
                truckWeights.poll()
                eachTime.add(0)
            }
        }
        return time - 1
    }
}