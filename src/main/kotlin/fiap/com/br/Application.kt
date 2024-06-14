package fiap.com.br

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

fun main() {
    embeddedServer(Netty, port = 8080, module = Application::module).start(wait = true)
}

fun Application.module() {
    val dbUrl = System.getenv("DATABASE_URL") ?: "jdbc:postgresql://localhost:5432/your_database"
    val dbUser = System.getenv("DATABASE_USER") ?: "your_user"
    val dbPassword = System.getenv("DATABASE_PASSWORD") ?: "your_password"

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
    // Adicione suas rotas aqui
}

fun hikariDataSource(url: String, user: String, pw: String): HikariDataSource {
    val config = HikariConfig().apply {
        jdbcUrl = url
        username = user
        password = pw
        driverClassName = "org.postgresql.Driver"
        maximumPoolSize = 3
        isAutoCommit = false
        transactionIsolation = "TRANSACTION_REPEATABLE_READ"
        validate()
    }
    return HikariDataSource(config)
}
