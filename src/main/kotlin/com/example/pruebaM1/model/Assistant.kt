package com.example.pruebaM1.model

import jakarta.persistence.*

@Entity
@Table(name = "assistant")
class Assistant {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    @Column(name="full_name")
    var fullName: String? = null
    var role: String? = null
    var age: Int? = 0
    @Column(name="conference_id")
    var conferenceId: Long?= null
}