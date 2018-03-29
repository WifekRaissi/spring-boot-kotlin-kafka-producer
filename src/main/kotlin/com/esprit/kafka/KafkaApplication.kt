package com.esprit.kafka

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.cloud.stream.messaging.Source

@SpringBootApplication
@EnableKafka
@EnableBinding( Source::class)
open class KafkaApplication




      fun main(args: Array<String>) {

                SpringApplication.run(KafkaApplication::class.java, *args)
            }


