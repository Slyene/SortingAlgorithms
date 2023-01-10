class CountingSort {
    companion object {
        fun sort(sequence: IntArray): IntArray {
            val min = sequence.min()
            val max = sequence.max()

            val support = IntArray(max - min + 1)

            for (i in sequence) support[i - min] += 1

            var index = 0
            for (i in support.indices) {
                for (element in 0 until support[i]) {
                    sequence[index] = i + min
                    index++
                }
            }

            return sequence
        }
    }
}