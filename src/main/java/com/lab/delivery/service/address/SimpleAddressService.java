package com.lab.delivery.service.address;

import com.lab.delivery.repository.address.AddressRepository;
import com.lab.delivery.service.address.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Mantixop on 1/28/16.
 */

@Service
public class SimpleAddressService implements AddressService {

    private AddressRepository addressRepository;

    @Autowired
    public SimpleAddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }
}
