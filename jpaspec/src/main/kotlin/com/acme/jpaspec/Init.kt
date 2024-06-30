package com.acme.jpaspec

import com.acme.jpaspec.person.dto.AnonymousAddressDto
import com.acme.jpaspec.person.dto.AnonymousPersonDto
import com.acme.jpaspec.person.persistence.AddressTypeEnum
import com.acme.jpaspec.person.persistence.PersonRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
internal class Init : CommandLineRunner {

    var log: Logger = LoggerFactory.getLogger(Init::class.java)

    @Autowired
    lateinit var personRepository : PersonRepository

    override fun run(vararg args: String) {
//        createAndInsertPersonsIntoDb()
    }

    private fun createAndInsertPersonsIntoDb() {
        log.info("create and insert persons into db")
        personRepository.saveAndFlush(
            AnonymousPersonDto(
                firstName = "Emilio Dale",
                lastName = "Phyllis Holland",
                age = 23,
                anonymousAddresses = listOf(
                    AnonymousAddressDto(
                        type = AddressTypeEnum.PRIVATE,
                        street = "vivendo",
                        houseNumber = "platonem",
                        postalCode = "conceptam",
                        city = "Classet",
                        country = "Libya"
                    )
                )
            ).toNewEntity()
        )
        personRepository.saveAndFlush(
            AnonymousPersonDto(
                firstName = "Randolph Knox",
                lastName = "Thaddeus Palmer",
                age = 22,
                anonymousAddresses = listOf(
                    AnonymousAddressDto(
                        type = AddressTypeEnum.PRIVATE,
                        street = "sollicitudin",
                        houseNumber = "laoreet",
                        postalCode = "cras",
                        city = "Spies",
                        country = "Israel"
                    ),
                    AnonymousAddressDto(
                        type = AddressTypeEnum.COMPANY,
                        street = "repudiandae",
                        houseNumber = "sem",
                        postalCode = "sem",
                        city = "Clemen",
                        country = "Cape Verde"
                    )
                )
            ).toNewEntity()
        )
    }
}