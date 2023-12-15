package com.studentrentals.StudentRentals.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tblpayment")
public class PaymentEntity {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="paymentid")
		private int paymentid;
		
		@Column(name="paymentmethod")
		private String paymentmethod;
		
		@Column(name="amount")
		private double amount;
		
		@Column(name="status")
		private boolean status;

		public PaymentEntity() {
			super();
		}

		public PaymentEntity(int paymentId, String paymentMethod, double amount, boolean status) {
			super();
			this.paymentid = paymentId;
			this.paymentmethod = paymentMethod;
			this.amount = amount;
			this.status = status;
		}

		public int getPaymentId() {
			return paymentid;
		}

		public String getPaymentMethod() {
			return paymentmethod;
		}

		public double getAmount() {
			return amount;
		}

		 public boolean getStatus() {
		        return status;
		}

		public void setPaymentId(int paymentId) {
			this.paymentid = paymentId;
		}

		public void setPaymentMethod(String paymentMethod) {
			this.paymentmethod = paymentMethod;
		}

		public void setAmount(double amount) {
			this.amount = amount;
		}

		public void setStatus(boolean status) {
			this.status = status;
		}
		
		@Override
		public String toString() {
		    StringBuilder sb = new StringBuilder();
		    sb.append("Payment Details{ ");
		    sb.append("paymentid= ").append(paymentid).append(", ");
		    sb.append("paymentMethod= ").append(paymentmethod).append(", ");
		    sb.append("amount= ").append(amount).append(", ");
		    sb.append("status= ").append(status).append(" } \n");
		    return sb.toString();
		}
		
}
