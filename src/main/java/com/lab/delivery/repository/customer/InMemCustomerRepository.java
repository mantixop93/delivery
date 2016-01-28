package com.lab.delivery.repository.customer;

import com.lab.delivery.domain.Customer;

/**
 * Created by Mantixop on 1/28/16.
 */
public class InMemCustomerRepository implements CustomerRepository {
    public Customer save(Customer customer) {
        return customer;
    }
}
