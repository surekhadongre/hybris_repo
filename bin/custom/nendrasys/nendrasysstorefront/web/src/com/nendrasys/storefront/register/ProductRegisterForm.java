package com.nendrasys.storefront.register;

public class ProductRegisterForm {
    private String productId;
    private int quantityNeeded;
    private String companyName;

    public String getProductId() {
        return this.productId;
    }

    public void setProductId(final String productId) {
        this.productId = productId;
    }

    public int getQuantityNeeded() {
        return this.quantityNeeded;
    }

    public void setQuantityNeeded(final int quantityNeeded) {
        this.quantityNeeded = quantityNeeded;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(final String companyName) {
        this.companyName = companyName;
    }
}
