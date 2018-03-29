package com.esprit.kafka.services


import com.esprit.kafka.entities.Utilisateur
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.cloud.stream.messaging.Source
import org.springframework.messaging.MessageHeaders
import org.springframework.messaging.support.MessageBuilder.createMessage
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

@Service
open class UtilisateurServiceImpl: UtilisateurService {
    val JSON = jacksonObjectMapper()


    private val logger = LoggerFactory.getLogger(UtilisateurService::class.java)

    @Autowired
    lateinit var output: Source

    override fun sendUtilisateur(data: Utilisateur){
        val test=data

        val map = hashMapOf(org.springframework.messaging.MessageHeaders.CONTENT_TYPE to "application/octet-stream") as Map< String, Utilisateur>
        val jsonInString = JSON.writeValueAsString(test)

        val msg = createMessage(test, MessageHeaders(map))
        output.output().send(msg)
    }



}