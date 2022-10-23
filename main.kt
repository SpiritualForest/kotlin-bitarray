import bitarray.BitArray

fun main() {
    var ba = BitArray(64)
    
    ba[0] = true
    println(ba) // 1
    println(ba[0]) // 1
    
    ba[1] = true
    println(ba) // 3
    println(ba[1]) // 1

    ba[2] = true
    println(ba) // 7
    println(ba[2]) // 1
    
    ba[1] = false
    println(ba) // 5
    println(ba[1]) // 0

    ba[32] = true
    println(ba)
    println(ba[32])

    println("Testing GitHub workflows CI")
}
