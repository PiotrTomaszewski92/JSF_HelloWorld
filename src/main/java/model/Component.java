package model;

import java.math.BigDecimal;

public class Component {

    private int amount;
    private BigDecimal actualPrice;
    private Product product;
    private Order order;

    public Component() {}

    public Component(int amount, BigDecimal actualPrice, Product product, Order order) {
        this.amount = amount;
        this.actualPrice = actualPrice;
        this.product = product;
        this.order = order;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public BigDecimal getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(BigDecimal actualPrice) {
        this.actualPrice = actualPrice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Component component = (Component) o;

        if (product != null ? !product.equals(component.product) : component.product != null) return false;
        return order != null ? order.equals(component.order) : component.order == null;
    }

    @Override
    public int hashCode() {
        int result = product != null ? product.hashCode() : 0;
        result = 31 * result + (order != null ? order.hashCode() : 0);
        return result;
    }

    public BigDecimal getTotal(){
        return this.actualPrice.multiply(new BigDecimal(this.amount));
    }
}
