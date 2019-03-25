package io.maslick.vater

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = NONE)
class Testing {

    @Autowired
    lateinit var service: IService

    @Autowired
    lateinit var rest: IRestJsonVat

    @Test
    fun testRest() {
        val body = rest.getEntry().execute().body()
        Assert.assertEquals(28, body!!.rates.size)
    }

    @Test
    fun testService() {
        service.get3Highest().forEach { println(it) }
        service.get3Lowest().forEach { println(it) }

        Assert.assertEquals(3, service.get3Highest().size)
        Assert.assertEquals(3, service.get3Lowest().size)
    }
}