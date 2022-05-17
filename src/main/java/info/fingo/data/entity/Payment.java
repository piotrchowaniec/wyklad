package info.fingo.data.entity;


public class Payment {

  private long paymentId;
  private long customerId;
  private long staffId;
  private long rentalId;
  private String amount;
  private java.sql.Timestamp paymentDate;


  public long getPaymentId() {
    return paymentId;
  }

  public void setPaymentId(long paymentId) {
    this.paymentId = paymentId;
  }


  public long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(long customerId) {
    this.customerId = customerId;
  }


  public long getStaffId() {
    return staffId;
  }

  public void setStaffId(long staffId) {
    this.staffId = staffId;
  }


  public long getRentalId() {
    return rentalId;
  }

  public void setRentalId(long rentalId) {
    this.rentalId = rentalId;
  }


  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }


  public java.sql.Timestamp getPaymentDate() {
    return paymentDate;
  }

  public void setPaymentDate(java.sql.Timestamp paymentDate) {
    this.paymentDate = paymentDate;
  }

}
