package com.example.manageruniversity.core.tuition.controller;

import com.example.manageruniversity.core.tuition.service.payment.PaymentService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequiredArgsConstructor
@Controller
public class PaymentController {

    private final PaymentService paymentService;
    @PostMapping("/api/payment")
    @ResponseBody
    public String payTuition(HttpServletRequest request) {
        return paymentService.buildUrlForPayment(request);
    }

    @GetMapping("/vnpay-payment")
    public String redirect(HttpServletRequest request){
        return paymentService.buildUrlForResponse(request);
    }

}
