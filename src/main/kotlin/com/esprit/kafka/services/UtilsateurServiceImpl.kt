package com.esprit.kafka.services


import com.esprit.kafka.entities.Utilisateur
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.cloud.stream.messaging.Source
import org.springframework.messaging.MessageHeaders
import org.springframework.messaging.support.MessageBuilder.createMessage

@Service
open class UtilisateurServiceImpl: UtilisateurService {
    val JSON = jacksonObjectMapper()


    private val logger = LoggerFactory.getLogger(UtilisateurService::class.java)

    @Autowired
    lateinit var output: Source

    override fun sendUtilisateur(data: Utilisateur){
val utilisateur=data
        val dataString = JSON.writeValueAsString(utilisateur)


        val map = hashMapOf(org.springframework.messaging.MessageHeaders.CONTENT_TYPE to "application/octet-stream") as Map< String, Any>

        val datatByte=JSON.writeValueAsBytes(dataString)

        val msg = createMessage(datatByte, MessageHeaders(map))

        output.output().send(msg)
        logger.info("Utilisateur received: " +  msg)

    }



}