package com.example.pruebaM1.controller

import com.example.pruebaM1.model.Assistant
import com.example.pruebaM1.model.Conference
import com.example.pruebaM1.service.AssistantService
import com.example.pruebaM1.service.ConferenceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/conference")   //endpoint
class ConferenceController {
    @Autowired
    lateinit var conferenceService: ConferenceService
    @GetMapping
    fun list (): ResponseEntity<*> {
        return ResponseEntity(conferenceService.list(), HttpStatus.OK)
    }
    @PostMapping
    fun save (@RequestBody modelo: Conference): ResponseEntity<Conference> {
        return ResponseEntity(conferenceService.save(modelo), HttpStatus.OK)
    }
    @PutMapping
    fun update (@RequestBody modelo: Conference): ResponseEntity<Conference> {
        return ResponseEntity(conferenceService.update(modelo), HttpStatus.OK)
    }
}