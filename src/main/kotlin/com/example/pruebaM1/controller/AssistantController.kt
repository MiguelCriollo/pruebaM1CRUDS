package com.example.pruebaM1.controller

import com.example.pruebaM1.model.Assistant
import com.example.pruebaM1.service.AssistantService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/assistant")   //endpoint
class AssistantController {
    @Autowired
    lateinit var assistantService: AssistantService
    @GetMapping
    fun list (): ResponseEntity<*> {
        return ResponseEntity(assistantService.list(), HttpStatus.OK)
    }
    @PostMapping
    fun save (@RequestBody modelo:Assistant): ResponseEntity<Assistant> {
        return ResponseEntity(assistantService.save(modelo), HttpStatus.OK)
    }
    @PutMapping
    fun update (@RequestBody modelo:Assistant): ResponseEntity<Assistant> {
        return ResponseEntity(assistantService.update(modelo), HttpStatus.OK)
    }
}