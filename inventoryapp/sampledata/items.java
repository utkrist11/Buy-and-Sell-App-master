package com.ce17b019.inventoryapp.sampledata;

public class items {

    private final String productName;
    private final int quantity1;
    private final int quantity2;


    public items(String productName, int quantity1,int quantity2) {
        this.productName = productName;
        this.quantity1 = quantity1;
        this.quantity2 = quantity2;


    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity1() {
        return quantity1;
    }

    public int getQuantity2() {
        return quantity2;
    }



    @Override
    public String toString() {
        return "items{" +
                "productName='" + productName + '\'' +
                ", quantity=" + quantity1 +
                ", quantity=" + quantity2 +
                '}';
    }
}
