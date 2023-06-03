package com.devsuperior.hrpayroll.feign;

import com.devsuperior.hrpayroll.entities.Worker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "hr-worker", path = "/workers")
public interface WorkerClient {

    @GetMapping
    List<Worker> findAll();

    @GetMapping("/{id}")
    Worker findById(@PathVariable Long id);
}
