package com.lab.delivery.service.customer;

import com.lab.delivery.domain.Customer;
import com.lab.delivery.repository.customer.CustomerRepository;
import com.lab.delivery.service.address.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Mantixop on 1/28/16.
 */

@Service
public class SimpleCustomerService implements CustomerService {

    private CustomerRepository customerRepository;
    private AddressService addressService;

    @Autowired
    public SimpleCustomerService(CustomerRepository customerRepository, AddressService addressService) {
        this.customerRepository = customerRepository;
        this.addressService = addressService;
    }

    public void save(Customer customer) {

    }

    public void addBonus(Customer customer, int bonus) {
    }
}
