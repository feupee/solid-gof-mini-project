package com.felipe.solidgof.repository;

import com.felipe.solidgof.model.Order;

/**
 * DIP: persistence is abstracted behind this interface.
 */
public interface OrderRepository {
    void save(Order order);
}
