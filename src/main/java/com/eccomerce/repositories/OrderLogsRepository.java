package com.eccomerce.repositories;

import com.eccomerce.entities.OrderLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLogsRepository extends JpaRepository<OrderLog, String> {
}
