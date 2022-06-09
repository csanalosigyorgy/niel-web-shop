package com.pm.nielwebshop.dto.creation;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class AddressCreation {

    @NotNull(message = "Field 'Country' must be filled")
    private String country;

    @NotNull(message = "Field 'Zipcode' must be filled")
    @Size(min = 4, max = 4, message = "'Zipcode' field's length must be exactly 4 characters")
    private String zipcode;

    private String city;

    @NotNull(message = "Field 'Street' must be filled")
    private String street;

    @NotNull(message = "Field 'Street number' must be filled")
    private String streetNumber;
}
