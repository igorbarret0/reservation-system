package com.igor.reservation_system.infrastructure.controller;

import com.igor.reservation_system.applications.usecases.payment.MakePaymentUseCase;
import com.igor.reservation_system.infrastructure.dtos.PaymentRequest;
import com.igor.reservation_system.infrastructure.dtos.PaymentResponse;
import com.igor.reservation_system.infrastructure.mapper.PaymentMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {

    private MakePaymentUseCase makePaymentUseCase;
    private PaymentMapper paymentMapper;

    public PaymentController(MakePaymentUseCase makePaymentUseCase, PaymentMapper paymentMapper) {
        this.makePaymentUseCase = makePaymentUseCase;
        this.paymentMapper = paymentMapper;
    }

    @PostMapping
    public ResponseEntity<PaymentResponse> makePayment(
            @RequestBody PaymentRequest request
    ) {

        var payment = makePaymentUseCase.makePaymentUseCase(paymentMapper.toPaymentFromPaymentRequest(request));
        return new ResponseEntity<>(paymentMapper.toPaymentResponseFromPayment(payment), HttpStatus.OK);
    }

}
