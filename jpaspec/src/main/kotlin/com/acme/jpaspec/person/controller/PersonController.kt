package com.acme.jpaspec.person.controller

import com.acme.jpaspec.person.service.PersonService
import com.acme.jpaspec.person.dto.AnonymousPersonDto
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/person")
internal class PersonController(
    private val personService: PersonService
) {
    @GetMapping("/{id}")
    fun select(@PathVariable("id") id: UUID) = personService.select(id)

    @PostMapping
    fun insert(@RequestBody anonymousPersonDto: AnonymousPersonDto) = personService.insert(anonymousPersonDto)

    @PutMapping("/{id}")
    fun update(@PathVariable("id") id: UUID, @RequestBody anonymousPersonDto: AnonymousPersonDto) = personService.update(id, anonymousPersonDto)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: UUID) = personService.delete(id)
}