package com.example.pruebaM1.service

import com.example.pruebaM1.model.Conference
import com.example.pruebaM1.repository.ConferenceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
@Service
class ConferenceService {
    @Autowired
    lateinit var conferenceRepository: ConferenceRepository

    fun list ():List<Conference>{
        return conferenceRepository.findAll()
    }
    fun save(modelo: Conference): Conference{
        try{
            return conferenceRepository.save(modelo)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun update(modelo: Conference): Conference{
        try {
            conferenceRepository.findById(modelo.id)
                ?: throw Exception("ID no existe")

            return conferenceRepository.save(modelo)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
}