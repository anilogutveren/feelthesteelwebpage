package com.feelthesteel.band.webpage.testconfig

import org.junit.jupiter.api.extension.AfterAllCallback
import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.platform.commons.logging.LoggerFactory
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers
import org.testcontainers.utility.DockerImageName

@Retention
@Target(AnnotationTarget.CLASS)
@ExtendWith(TestContainers::class)
@DirtiesContext
annotation class EnableDatabase

@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@Testcontainers
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TestContainers : BeforeAllCallback, AfterAllCallback {
    private val log = LoggerFactory.getLogger(this.javaClass)

    companion object {
        @Container
        val postgresContainer = PostgreSQLContainer(DockerImageName.parse("postgres:11.7-alpine"))
            .withDatabaseName("db")
            .withUsername("user")
            .withPassword("password")

        @JvmStatic
        @DynamicPropertySource
        fun datasourceConfig(registry: DynamicPropertyRegistry) {
            postgresContainer.start()
            registry.add("spring.datasource.password", postgresContainer::getPassword)
            registry.add("spring.datasource.username", postgresContainer::getUsername)
        }
    }

    override fun beforeAll(context: ExtensionContext) = onlyForInitialContext(context) {
        log.info { "Starting Postgres Container ..." }
        postgresContainer.start()
    }

    override fun afterAll(context: ExtensionContext) = onlyForInitialContext(context) {
        log.info { "Stopping Postgres Container ..." }
        postgresContainer.stop()
    }

    private fun onlyForInitialContext(context: ExtensionContext, body: (ExtensionContext.Store) -> Unit) {
        val store = context.getStore(ExtensionContext.Namespace.create("DatabaseTestExtension"))
        val initialContext = store.get("initialContext", ExtensionContext::class.java)
        if (initialContext == null || initialContext == context) {
            body(store)
            store.put("initialContext", context)
        }
    }
}
