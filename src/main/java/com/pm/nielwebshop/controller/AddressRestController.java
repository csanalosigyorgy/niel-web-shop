package com.pm.nielwebshop.controller;


import com.pm.nielwebshop.dto.creation.AddressCreation;
import com.pm.nielwebshop.dto.view.AddressView;
import com.pm.nielwebshop.mapper.AddressMapper;
import com.pm.nielwebshop.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/addresses")
@RequiredArgsConstructor
public class AddressRestController {

    private final AddressService addressService;
    private final AddressMapper addressMapper;

    @GetMapping
    public List<AddressView> getAllAddresses() {
        return addressMapper.toAddressViews(addressService.getAll());
    }

    @GetMapping("/{id}")
    public AddressView getAddressById(@PathVariable Long id) {
        return addressMapper.toAddressView(addressService.getById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AddressView createAddress(@Valid @RequestBody AddressCreation dto) {
        return addressMapper.toAddressView(addressService.createAddress(dto));
    }
}
