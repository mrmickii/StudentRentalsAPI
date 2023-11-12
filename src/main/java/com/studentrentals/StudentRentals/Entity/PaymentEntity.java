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
		private int amount;
		
		@Column(name="status")
		private boolean status;

		public PaymentEntity() {
			super();
		}

		public PaymentEntity(int paymentId, String paymentMethod, int amount, boolean status) {
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

		public int getAmount() {
			return amount;
		}

		public boolean isStatus() {
			return status;
		}

		public void setPaymentId(int paymentId) {
			this.paymentid = paymentId;
		}

		public void setPaymentMethod(String paymentMethod) {
			this.paymentmethod = paymentMethod;
		}

		public void setAmount(int amount) {
			this.amount = amount;
		}

		public void setStatus(boolean status) {
			this.status = status;
		}
}
