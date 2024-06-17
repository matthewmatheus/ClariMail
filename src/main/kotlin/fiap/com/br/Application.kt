package com.example



import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import org.jetbrains.exposed.sql.Database
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.slf4j.LoggerFactory

fun main() {
    embeddedServer(Netty, port = 8080, module = Application::module).start(wait = true)
}

fun Application.module() {
    val logger = LoggerFactory.getLogger("Application")

    val dbUrl = System.getenv("DATABASE_URL") ?: "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL"
    val dbUser = System.getenv("DATABASE_USER") ?: "RM551960"
    val dbPassword = System.getenv("DATABASE_PASSWORD") ?: "290300"

    logger.info("Connecting to database: $dbUrl")

    Database.connect(hikariDataSource(dbUrl, dbUser, dbPassword))

    install(ContentNegotiation) {
        json()
    }
    install(Authentication) {
        jwt {
            verifier(JWT.require(Algorithm.HMAC256("your_jwt_secret")).build())
            validate { credential ->
                if (credential.payload.getClaim("id").asInt() != null) {
                    JWTPrincipal(credential.payload)
                } else {
                    null
                }
            }
        }
    }
    routing {
        get("/") {
            call.respondText("Hello, Ktor!")
        }
        // Adicione suas outras rotas aqui
    }

    logger.info("Application started")
}

fun hikariDataSource(url: String, user: String, pw: String): HikariDataSource {
    val config = HikariConfig().apply {
        jdbcUrl = url
        username = user
        password = pw
        driverClassName = "oracle.jdbc.OracleDriver"
        maximumPoolSize = 3
        isAutoCommit = false
        transactionIsolation = "TRANSACTION_READ_COMMITTED"
        validate()
    }
    return HikariDataSource(config)
}
