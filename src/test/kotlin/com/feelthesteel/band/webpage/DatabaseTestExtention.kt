package com.feelthesteel.band.webpage

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@Retention
@Target(AnnotationTarget.CLASS)
@EnableDatabase
@DataJpaTest
annotation class RepositoryTest
