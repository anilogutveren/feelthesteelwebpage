package com.feelthesteel.band.webpage.entity

import lombok.Data
import javax.persistence.Embeddable

@Embeddable
@Data
class Roles {
    private val role: String = ""
}
