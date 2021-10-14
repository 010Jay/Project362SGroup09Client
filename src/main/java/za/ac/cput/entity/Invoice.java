package za.ac.cput.entity;

/**
 * Invoice.java
 * Entity for the Invoice
 * Author: Siyanda Hlongwa (217091229)
 * Date: 14 September 2021
 **/

public class Invoice {//start of class

    //Attributes
    private String invoiceNumber;
    private String invoiceDate, studentNumber, eventCode, totalPrice;
    private static Invoice invoice;

    public static Invoice getInvoiceInstance()
    {
        if(invoice == null)
        {
            invoice = new Invoice();
        }

        return invoice;
    }

    protected Invoice(){}

    public Invoice(Builder builder){

        this.invoiceNumber = builder.invoiceNumber;
        this.invoiceDate = builder.invoiceDate;
        this.studentNumber = builder.studentNumber;
        this.eventCode = builder.eventCode;
        this.totalPrice = builder.totalPrice;
    }

    //Getters
    public String getInvoiceNumber() {return invoiceNumber;}
    public String getInvoiceDate() {return invoiceDate;}
    public String getStudentNumber() {return studentNumber;}
    public String getEventCode() {return eventCode;}
    public String getTotalPrice() {return totalPrice;}

    //Setters
    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }
    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }
    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }
    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }
    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    //toString
    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceNumber='" + invoiceNumber + '\'' +
                ", invoiceDate='" + invoiceDate + '\'' +
                ", studentNumber='" + studentNumber + '\'' +
                ", eventCode='" + eventCode + '\'' +
                ", totalPrice='" + totalPrice + '\'' +
                '}';
    }

    public static class Builder {

        //Attributes
        private String invoiceNumber, invoiceDate, studentNumber, eventCode, totalPrice;

        public Builder setInvoiceNumber(String invoiceNumber) {
            this.invoiceNumber = invoiceNumber;
            return this;
        }

        public Builder setInvoiceDate(String invoiceDate) {
            this.invoiceDate = invoiceDate;
            return this;
        }

        public Builder setStudentNumber(String studentNumber) {
            this.studentNumber = studentNumber;
            return this;
        }

        public Builder setEventCode(String eventCode) {
            this.eventCode = eventCode;
            return this;
        }

        public Builder setTotalPrice(String totalPrice) {
            this.totalPrice = totalPrice;
            return this;
        }

        public Invoice build()
        {
            return new Invoice(this);
        }

        public Builder copy(Invoice invoice)
        {
            this.invoiceNumber = invoice.invoiceNumber;
            this.invoiceDate = invoice.invoiceDate;
            this.studentNumber = invoice.studentNumber;
            this.eventCode = invoice.eventCode;
            this.totalPrice = invoice.totalPrice;

            return this;
        }
    }

}//end of class