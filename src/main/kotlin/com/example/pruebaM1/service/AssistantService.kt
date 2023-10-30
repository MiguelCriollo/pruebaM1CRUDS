package com.example.pruebaM1.service

import com.example.pruebaM1.model.Assistant
import com.example.pruebaM1.model.Conference
import com.example.pruebaM1.repository.AssistantRepository
import com.example.pruebaM1.repository.ConferenceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class AssistantService {
    @Autowired
    lateinit var conferenceRepository: ConferenceRepository
    @Autowired
    lateinit var assistantRepository:AssistantRepository

    fun list ():List<Assistant>{
        return assistantRepository.findAll()
    }

    fun save(modelo: Assistant): Assistant {
        try{
            conferenceRepository.findById(modelo.conferenceId)
                ?:throw Exception("Id del cliente no existe")
            return assistantRepository.save(modelo)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun update(modelo: Assistant): Assistant {
        try {
            assistantRepository.findById(modelo.id)
                ?: throw Exception("ID no existe")

            return assistantRepository.save(modelo)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
}