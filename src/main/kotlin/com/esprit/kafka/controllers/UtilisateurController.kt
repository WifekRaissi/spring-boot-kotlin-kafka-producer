package com.esprit.kafka.controllers


import com.esprit.kafka.entities.Utilisateur
import com.esprit.kafka.services.UtilisateurService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping
open class UtilisateureController {



    @Autowired
    lateinit var utilisateurService: UtilisateurService

    @PostMapping("/utilisateurs")

    fun greeting(@RequestBody utilisateur: Utilisateur): Utilisateur {
        utilisateurService.sendUtilisateur(utilisateur)
		return utilisateur
	}
             

}


