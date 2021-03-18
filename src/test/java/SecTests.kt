package test.java
import main.java.FunctionNotDefinedException
import org.junit.*
import main.java.Sec
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvFileSource
import kotlin.math.PI
import org.junit.jupiter.api.Test


class SecTests {

    companion object {
        val SEC_DELTA = 0.001
    }

    @ParameterizedTest
    @CsvFileSource(resources = ["testValuesOnIntervalFromMinusPiDiv2ToPiDiv2.csv"])
    fun `sec on interval from (-pi div 2) to (pi div 2)`(xValue: Double, yRes: Double) {
        Assert.assertEquals(Sec.sec(xValue), yRes, SEC_DELTA)
    }

    @ParameterizedTest
    @CsvFileSource(resources = ["testValuesOnIntervalFromMinusPiDiv2ToPiDiv2.csv"])
    fun `sec on interval from (pi div 2) to (3 * pi div 2)`(xValue: Double, yRes: Double) {
        Assert.assertEquals(Sec.sec(xValue + PI), -yRes, SEC_DELTA)
    }

    @ParameterizedTest
    @CsvFileSource(resources = ["testValuesOnIntervalFromMinusPiDiv2ToPiDiv2.csv"])
    fun `sec on interval from (3pi div 2) to (5pi div 2)`(xValue: Double, yRes: Double) {
        Assert.assertEquals(Sec.sec(xValue + PI*2), yRes, SEC_DELTA)
    }

    @ParameterizedTest
    @CsvFileSource(resources = ["testValuesOnIntervalFromMinusPiDiv2ToPiDiv2.csv"])
    fun `sec on interval from (-3*pi div 2) to (-pi div 2)`(xValue: Double, yRes: Double) {
        Assert.assertEquals(Sec.sec(xValue - PI), -yRes, SEC_DELTA)
    }

    @Test
    fun `sec in undefined points should throw FunctionUndefinedException`() {
        val start = PI/2

        for (i in -1..2) {
            Assertions.assertThrows(FunctionNotDefinedException::class.java) {
                Sec.sec(start + PI*i)
            }
        }
    }
}