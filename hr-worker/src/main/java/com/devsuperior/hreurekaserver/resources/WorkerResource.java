package com.devsuperior.hreurekaserver.resources;

import com.devsuperior.hreurekaserver.entities.Worker;
import com.devsuperior.hreurekaserver.services.WorkerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RefreshScope
@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

    private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);

    @Autowired
    private Environment env;

    @Autowired
    private WorkerService workerService;

    @GetMapping
    public List<Worker> findAll() {
        return workerService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Worker findById(@PathVariable Long id) {
        logger.info("Port: " + env.getProperty("local.server.port"));
        return workerService.findById(id);
    }
}
