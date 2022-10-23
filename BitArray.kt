// Kotlin implementation of a BitArray that uses integers to store boolean values
package bitarray

import kotlin.math.ceil

class BitArray(private val sizeInBits: Int) {
    private val list = MutableList(ceil(sizeInBits / 32f).toInt()) { 0 }

    operator fun get(i: Int): Boolean {
        if ((i < 0) || (i > sizeInBits)) {
            throw IndexOutOfBoundsException(i)
        }

        val integer = list[i / 32]

        // x &= 1 << (i % 32)
        val bit = integer and (1 shl (i % 32))

        return bit > 0
    }

    operator fun set(i: Int, value: Boolean) {
        if ((i < 0) || (i > sizeInBits)) {
            throw IndexOutOfBoundsException(i)
        }
        
        var integer = list[i / 32]
        if (value) {
            // x |= 1 << (i % 32)
            integer = integer or (1 shl (i % 32))
        }
        else {
            // x &= ~(1 << (i % 32))
            integer = integer and (1 shl (i % 32)).inv()
        }
        list[i / 32] = integer
    }
    
    override fun toString(): String {
        var str = ""
        for(x in list) {
            val xbin = x.toString(2)
            str += xbin
            str += "0".repeat(32 - xbin.length)
        }
        return str
    }
}
