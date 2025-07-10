package com.eclipse.hotel.api.repository;

import com.eclipse.hotel.api.model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customers,Long> {
}
