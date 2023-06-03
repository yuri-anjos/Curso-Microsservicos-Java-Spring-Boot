package com.devsuperior.hreurekaserver.repositories;

import com.devsuperior.hreurekaserver.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
