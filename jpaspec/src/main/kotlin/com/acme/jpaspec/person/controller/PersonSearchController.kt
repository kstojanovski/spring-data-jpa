package com.acme.jpaspec.person.controller

import com.acme.jpaspec.person.service.PersonService
import com.acme.jpaspec.person.dto.PersonSearchCriteriaDto
import com.acme.jpaspec.person.service.PersonSearchService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/person-search")
internal class PersonSearchController(
    private val personSearchService: PersonSearchService
) {
    @GetMapping("/all")
    fun selectAll() = personSearchService.selectAll()

    @GetMapping("/sub-select")
    fun findBySubSelects(@RequestParam firstName: String, @RequestParam lastName: String) =
        personSearchService.findBySubSelects(firstName, lastName)

    @GetMapping("/by-criteria")
    fun search(@RequestBody personSearchCriteriaDto: PersonSearchCriteriaDto) =
        personSearchService.search(personSearchCriteriaDto)
}