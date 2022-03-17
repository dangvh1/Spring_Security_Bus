package com.example.Spring_Security_Bus.DTO;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

}
