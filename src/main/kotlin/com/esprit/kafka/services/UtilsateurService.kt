package com.esprit.kafka.services


import com.esprit.kafka.entities.Utilisateur



interface UtilisateurService{


    fun sendUtilisateur(data: Utilisateur)
}