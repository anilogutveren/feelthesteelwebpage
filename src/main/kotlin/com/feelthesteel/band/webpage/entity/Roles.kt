package com.feelthesteel.band.webpage.entity

import javax.persistence.Embeddable
import lombok.Data
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter

@Embeddable
@Data
@Getter
@Setter
@NoArgsConstructor
class Roles {
    private val role: String = ""
}



