package com.shufitapp.shufit.Models;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteRutinaId implements Serializable {

    private Integer clienteId;
    private Integer rutinaId;

}
