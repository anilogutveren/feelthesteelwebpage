package com.feelthesteel.band.webpage

import org.springframework.test.context.ActiveProfiles
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers

@ActiveProfiles("test")
@Testcontainers
class TestContainers {

    @Container
    protected var postgreSQLContainer = PostgreSQLContainer()
}