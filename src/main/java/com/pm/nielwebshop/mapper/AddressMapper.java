package com.pm.nielwebshop.mapper;

import com.pm.nielwebshop.dto.creation.AddressCreation;
import com.pm.nielwebshop.dto.view.AddressView;
import com.pm.nielwebshop.model.Address;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AddressMapper {

    private final ModelMapper mapper;

    public AddressView toAddressView(Address address) {
        return mapper.map(address, AddressView.class);
    }

    public List<AddressView> toAddressViews(List<Address> addresses) {
        return addresses.stream()
                .map(this::toAddressView)
                .collect(Collectors.toList());
    }

    public Address toAddressEntity(AddressCreation dto) {
        return mapper.map(dto, Address.class);
    }
}

