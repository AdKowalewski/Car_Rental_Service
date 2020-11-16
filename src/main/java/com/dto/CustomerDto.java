package com.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDto {

    private Long customerId;

    private String firstName;

    private String lastName;

    private String email;

    private String address;
}
