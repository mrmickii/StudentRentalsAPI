package com.studentrentals.StudentRentals.Service;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentrentals.StudentRentals.Entity.PaymentEntity;
import com.studentrentals.StudentRentals.Repository.NotificationRepository;



@Service
public class NotificationService {
	
	@Autowired
	NotificationRepository notifrep;
	
	@Autowired
	PaymentService payserv;
	
	public PaymentEntity getPaymentById(int paymentId) {
        java.util.Optional<PaymentEntity> payment = notifrep.findById(paymentId);
        return payment.orElse(null);
    }
	
	public boolean checkPaymentStatus(int paymentId) {
        try {
            PaymentEntity payment = getPaymentById(paymentId);

            if (payment != null) {
                return payserv.paymentStatus(paymentId);
            } else {
                
                return false;
            }

        } catch (Exception e) {
            
            return false;
        }
    }
	
	
	

}
