package com.example.businessrulesEngine.model;

public class PaymentRequest {
    private String productName;
    private ProductType productType;
    private CategoryType categoryType;

    /**
     *
     * @param productName the productName
     * @param productType the product type
     * @param categoryType the categoryType
     */
    public PaymentRequest(String productName, ProductType productType, CategoryType categoryType) {
        this.productName = productName;
        this.productType = productType;
        this.categoryType = categoryType;
    }

    /**
     *
     * @return product name.
     */
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public CategoryType getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(CategoryType categoryType) {
        this.categoryType = categoryType;
    }
}
