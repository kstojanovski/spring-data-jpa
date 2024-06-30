package com.acme.jpaspec

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.core.annotation.Order
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.stereotype.Component


@EnableJpaRepositories
@SpringBootApplication
class JpaSpecApplication

fun main(args: Array<String>) {
    runApplication<JpaSpecApplication>(*args)
}




//@Component
//@Order(1)
//class WillBeInvokedFirst : CommandLineRunner {
//    override fun run(vararg args: String) {
//        print("Hello, ")
//    }
//}
//@Component
//@Order(2)
//class WillBeInvokedSecond : CommandLineRunner {
//    override fun run(vararg args: String) {
//        println("World!")
//    }
//}