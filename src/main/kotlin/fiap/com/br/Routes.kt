package com.example

import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.serialization.jackson.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.request.*
import org.jetbrains.exposed.sql.transactions.transaction

fun Application.module() {
    install(ContentNegotiation) {
        jackson { }
    }
    install(Authentication) {
        jwt {
            // Configurações do JWT
        }
    }
    routing {
        route("/api") {
            authenticate {
                post("/register") {
                    // Implementar registro
                }
                post("/login") {
                    // Implementar login
                }
                post("/emails") {
                    // Implementar envio de email
                }
                get("/emails") {
                    // Implementar recebimento de emails
                }
            }
        }
    }
}
