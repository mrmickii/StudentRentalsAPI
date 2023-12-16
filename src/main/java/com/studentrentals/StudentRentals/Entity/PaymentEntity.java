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
		
		@Column(name="selectedpaymentoption")
		private String selectedPaymentOption;
		
		@Column(name = "price")
	    private int price;
		
		@Column(name="status")
		private boolean status = true;

		public PaymentEntity() {
			super();
		}

		public PaymentEntity(int paymentId, String selectedPaymentOption, int price, boolean status) {
			super();
			this.paymentid = paymentId;
			this.selectedPaymentOption = selectedPaymentOption;
			this.price = price;
			this.status = status;
		}

		public int getPaymentId() {
			return paymentid;
		}

		public String getSelectedPaymentOption() {
			return selectedPaymentOption;
		}

		public int getPrice() {
			return price;
		}

		 public boolean getStatus() {
		        return status;
		}

		public void setPaymentId(int paymentId) {
			this.paymentid = paymentId;
		}

		public void setSelectedPaymentOption(String selectedPaymentOption) {
			this.selectedPaymentOption = selectedPaymentOption;
		}

		public void setPrice(int price) {
			this.price = price;
		}

		public void setStatusDone() {
			this.status = true;
		}		
		
		public void setStatus(boolean status) {
	        this.status = status;
	    }
}
