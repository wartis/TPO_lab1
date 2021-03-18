package main.java

import java.lang.Exception
import java.math.BigDecimal
import kotlin.math.pow

object Sec{
    fun sec(x : Double, n: Int = 10) : Double {
        if (n <= 0)
            throw WrongArgumentException()

        val cos = cosViaRow(x % (2*Math.PI), n)

        if (cos > -0.000001 && cos < 0.000001)
            throw FunctionNotDefinedException()

        return 1.0 / cos
    }

    private fun factorial(n: Int) : Long
            = if (n == 0) 1 else factorial(n - 1) * n


    private fun cosViaRow(x: Double, n: Int = 8) : Double {
        var res : Double = 0.0
//        for (i in 0..n) {
//            res += ((-1.0).pow(i) * x.pow(2*i)) /
//                    factorial(i * 2)
//        }

        (0..n).iterator().forEach {
            res += ((-1.0).pow(it) * x.pow(2*it)) /
                    factorial(it * 2)
        }

        return res
    }

}

class WrongArgumentException : Exception("Wrong argument!")
class FunctionNotDefinedException : Exception()