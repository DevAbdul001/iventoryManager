package com.inventory.app.Services;

import com.inventory.app.Models.Payment;
import com.inventory.app.Repositories.PaymentRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService( PaymentRepository paymentRepository){
        this.paymentRepository = paymentRepository;
    }

    public Payment createPayment(BigDecimal amount, Long orderId, Long userId, String status){
        Payment payment = new Payment(amount, orderId ,userId, status);
        return paymentRepository.save(payment);
    }


}
