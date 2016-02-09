package com.lab.delivery.repository;

import com.lab.delivery.domain.Customer;
import com.lab.delivery.repository.customer.CustomerRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Mantixop on 1/28/16.
 */

@Repository
public class InMemCustomerRepository implements CustomerRepository {
    public Customer save(Customer customer) {
        return customer;
    }
}
