package com.pm.nielwebshop.service;

import com.pm.nielwebshop.dto.creation.AddressCreation;
import com.pm.nielwebshop.exception.EntityNotFoundByIdException;
import com.pm.nielwebshop.mapper.AddressMapper;
import com.pm.nielwebshop.model.Address;
import com.pm.nielwebshop.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    public Address getById(Long id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundByIdException("Address", id));
    }

    public Address createAddress(AddressCreation dto) {
        Address address = addressMapper.toAddressEntity(dto);
        addressRepository.save(address);
        return address;
    }
}
