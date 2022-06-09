package com.pm.nielwebshop.dto.view;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressView {
    private Long id;
    private String country;
    private String zipcode;
    private String city;
    private String street;
    private String streetNumber;
}
