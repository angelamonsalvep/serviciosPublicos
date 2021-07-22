package com.example.serviciospublicos.models;

public class Pay {

    String typeInvoice;
    String numberInvoice;
    String paidValue;

    public String getTypeInvoice() {
        return typeInvoice;
    }

    public void setTypeInvoice(String typeInvoice) {
        this.typeInvoice = typeInvoice;
    }

    public String getNumberInvoice() {
        return numberInvoice;
    }

    public void setNumberInvoice(String numberInvoice) {
        this.numberInvoice = numberInvoice;
    }

    public String getPaidValue() {
        return paidValue;
    }

    public void setPaidValue(String paidValue) {
        this.paidValue = paidValue;
    }
}
