package com.tilin.core.product.domain.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stockId = 0L;
    private String amount;
    private Timestamp datetime;

    @ManyToOne()
    @JoinColumn(name = "product_id")
    private Product product_id;

    public Stock(){}

    public Stock(Long stockId, String amount, Timestamp datetime, Product product_id) {
        this.stockId = stockId;
        this.amount = amount;
        this.datetime = datetime;
        this.product_id = product_id;
    }

    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }

    public Product getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Product product_id) {
        this.product_id = product_id;
    }
}
