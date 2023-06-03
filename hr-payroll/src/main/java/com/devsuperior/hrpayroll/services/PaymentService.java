package com.devsuperior.hrpayroll.services;

import com.devsuperior.hrpayroll.entities.Payment;
import com.devsuperior.hrpayroll.entities.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    @Value("${hr-worker.host}")
    private String hrWorkerHost;

    @Autowired
    private RestTemplate restTemplate;

    public Payment getPayment(long workerId, int days) {
        Map<String, Object> uriVar = new HashMap<>();
        uriVar.put("id", workerId);

        Worker worker = restTemplate.getForObject(hrWorkerHost + "/workers/{id}", Worker.class, uriVar);
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
