package com.lab.delivery.repository.pizza;

import com.lab.delivery.domain.Pizza;
import org.springframework.stereotype.Repository;

/**
 * Created by Mantixop on 1/21/16.
 */

public interface PizzaRepository {
    Pizza findById(Integer id);
}
