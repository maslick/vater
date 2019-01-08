package io.maslick.vater

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class VaterApp

fun main(args: Array<String>) {
    runApplication<VaterApp>(*args)
}

@RestController
class VaterRestController(val service: IService) {
    @GetMapping("/low")
    fun getThreeLowest() = service.get3Lowest()

    @GetMapping("/high")
    fun getThreeHighest() = service.get3Highest()
}

