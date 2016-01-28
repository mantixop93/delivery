package com.lab.delivery.service.customer;

import com.lab.delivery.domain.Customer;
import com.lab.delivery.repository.customer.CustomerRepository;
import com.lab.delivery.service.address.AddressService;

/**
 * Created by Mantixop on 1/28/16.
 */
public class SimpleCustomerService implements CustomerService {

    private CustomerRepository customerRepository;
    private AddressService addressService;

    public SimpleCustomerService(CustomerRepository customerRepository, AddressService addressService) {
        this.customerRepository = customerRepository;
        this.addressService = addressService;
    }

    public void save(Customer customer) {

    }

    public void addBonus(Customer customer, int bonus) {
    }
}
