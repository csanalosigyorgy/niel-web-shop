package com.pm.nielwebshop.repository;

import com.pm.nielwebshop.model.Address;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {

    @NonNull
    @Query("select a from Address a")
    List<Address> findAll();
}
