package com.devsuperior.hrpayroll.services;

import com.devsuperior.hrpayroll.entities.Payment;
import com.devsuperior.hrpayroll.feign.WorkerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private WorkerClient workerClient;

    public Payment getPayment(long workerId, int days) {
        var worker = workerClient.findById(workerId);
        if(worker == null){
            return null;
        }
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
