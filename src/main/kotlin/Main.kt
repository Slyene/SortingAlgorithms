fun main(args: Array<String>) {
    val a = MergeSort.sort(IntArray(70) { _ ->  (Math.random() * 100).toInt() })
    val b = CountingSort.sort(IntArray(70) { _ ->  (Math.random() * 100).toInt() })
    a.forEach { print("$it ") }
    println()
    b.forEach { print("$it ") }
}