package com.example.manageruniversity.core.tuition.service.payment;

import com.example.manageruniversity.core.tuition.api.VNPayAPI;
import com.example.manageruniversity.core.tuition.dal.dataobject.Payment;
import com.example.manageruniversity.core.tuition.dal.repo.PaymentRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final VNPayAPI vnPayAPI;
    private final PaymentRepository paymentRepository;
    @Value("${application.frontend.href}")
    private String urlFrontEnd;
    public String buildUrlForPayment(HttpServletRequest request) {
        int amount = Integer.parseInt(request.getParameter("amount"));
        String studentId = request.getParameter("studentId");
        String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
        String vnPayUrl = vnPayAPI.createOrder(amount, studentId, baseUrl);
        return vnPayUrl;
    }

    public String buildUrlForResponse(HttpServletRequest request) {
        int paymentStatus = vnPayAPI.orderReturn(request);
        String urlRedirect = urlFrontEnd + "?status=";
        if(paymentStatus == 1) {
            Long studentId = Long.parseLong(request.getParameter("vnp_OrderInfo"));
            String totalPrice = request.getParameter("vnp_Amount");
            Payment payment = new Payment(studentId, Long.parseLong(totalPrice));

            urlRedirect += "Success";
        } else {
            urlRedirect += "Fail";
        }
        return "redirect:" + urlRedirect;
    }
}
