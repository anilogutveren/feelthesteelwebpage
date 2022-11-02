package com.feelthesteel.band.webpage.controller.withwiremock

import com.feelthesteel.band.webpage.service.impl.MusiciansServiceImpl
import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.client.WireMock.aResponse
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.options
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo
import com.github.tomakehurst.wiremock.common.ConsoleNotifier
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock
import org.springframework.test.context.ActiveProfiles

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWireMock(port = 9999)
@ActiveProfiles("test")
internal class MusicianControllerTestWithVM() {

    val wiremock: WireMockServer = WireMockServer(options("").withPort(9999))

    @Autowired
    private lateinit var musiciansServiceImpl: MusiciansServiceImpl

    @BeforeEach
    fun setUp() {
        wiremock.start()
    }

    @AfterEach
    fun cleanUp() {
        wiremock.stop()
    }

    @Test
    fun getAllMusicians() {
        // Stubbing WireMock
        stubFor(
            get(urlEqualTo("/musicians"))
                .willReturn(aResponse().withHeader("Content-Type", "application/json").withBody("Hello World!"))
        )
        // We're asserting if WireMock responded properly
        assertThat(this.musiciansServiceImpl.getAllMusicians()).isEqualTo(listOf(null))
    }

    /*    private val logger: Logger = LoggerFactory.getLogger(javaClass)
        private val CONTENT_TYPE = "application/json"
        private val TRACKING_ID = "abcde"

        @MockBean
        private lateinit var musiciansServiceImpl: MusiciansServiceImpl

        @BeforeAll
        fun setUp() {
            val wireMockServer: WireMockServer
        }

    *//*    WireMockServer wireMockServer = new WireMockServer(wireMockConfig().port(8089)); //No-args constructor will start on port 8080, no HTTPS
    wireMockServer.start();

// Do some stuff

    WireMock.reset();

// Finish doing stuff

    wireMockServer.stop();*//*



    @Test
    fun getAllMusicians() {
    }

    @Test
    fun getMusicianByName() {
    }

    @Test
    fun deleteAllMusicians() {
    }

    @Test
    fun registerNewMusician() {
    }

    @Test
    fun registerNewMusicians() {
    }*/
}
