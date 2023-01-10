class MergeSort {
    companion object {
        fun sort(sequence: IntArray): IntArray {
            val sortedSequence: IntArray
            if (sequence.size == 1) return sequence
            else {
                val half = sequence.size.floorDiv(2)
                val leftHalfSize = half
                val rightHalfSize = sequence.size - half
                var leftHalfArray = IntArray(leftHalfSize)
                var rightHalfArray = IntArray(rightHalfSize)
                sequence.copyInto(leftHalfArray, 0, 0, leftHalfSize)
                sequence.copyInto(rightHalfArray, 0, leftHalfSize, sequence.size)
                leftHalfArray = sort(leftHalfArray)
                rightHalfArray = sort(rightHalfArray)
                sortedSequence = merge(leftHalfArray, rightHalfArray)
            }

            return sortedSequence
        }

        private fun merge(left: IntArray, right: IntArray): IntArray {
            val mergedSequence = IntArray(left.size + right.size)
            var leftCounter = 0
            var rightCounter = 0

            for (i in mergedSequence.indices) {
                if (leftCounter == left.size) {
                    mergedSequence[i] = right[rightCounter]
                    rightCounter++
                } else if (rightCounter == right.size) {
                    mergedSequence[i] = left[leftCounter]
                    leftCounter++
                } else if (left[leftCounter] < right[rightCounter]) {
                    mergedSequence[i] = left[leftCounter]
                    leftCounter++
                } else if (right[rightCounter] <= left[leftCounter]) {
                    mergedSequence[i] = right[rightCounter]
                    rightCounter++
                }
            }

            return mergedSequence
        }
    }
}