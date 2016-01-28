package com.lab.delivery.service.address;

import com.lab.delivery.repository.address.AddressRepository;
import com.lab.delivery.service.address.AddressService;

/**
 * Created by Mantixop on 1/28/16.
 */
public class SimpleAddressService implements AddressService {

    private AddressRepository addressRepository;

    public SimpleAddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }
}
