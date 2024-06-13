package com.example

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*

object Security {
    private val secret = "your_jwt_secret" // Substitua pelo seu segredo JWT

    fun configureJWT(application: Application) {
        application.install(Authentication) {
            jwt {
                verifier(JWT.require(Algorithm.HMAC256(secret)).build())
                validate { credential ->
                    if (credential.payload.getClaim("id").asInt() != null) {
                        JWTPrincipal(credential.payload)
                    } else {
                        null
                    }
                }
            }
        }
    }
}