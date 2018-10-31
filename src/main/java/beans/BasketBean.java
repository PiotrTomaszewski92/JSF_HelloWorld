package beans;

import dao.Dao;
import model.Component;
import model.Order;
import model.Product;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@ManagedBean
@SessionScoped
public class BasketBean {
    private Order order = new Order();
    private Component component;
    private Product selectedProduct;

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    public String finishOrder(){
        Dao.getDao().addOrder(order);
        order = new Order();
        return "ok";
    }

    public String remove(){
        for(Component c : order.getComponentList())
            if (c.equals(this.component)) {
                order.getComponentList().remove(c);
                break;

            }
        return "";
    }

    public String addToBasket(){
        for (Component c : order.getComponentList()){
            if (c.getProduct().equals(selectedProduct)){
                c.setCount(c.getCount()+1);
                return "basket.xhtml";
            }
        }
        Component c = new Component(1,selectedProduct.getPrice(), selectedProduct, order);
        order.getComponentList().add(c);
        return "basket.xhtml";
    }


    public void actionListener(ActionEvent actionEvent) {
        String textId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("productId");
        int id = Integer.parseInt(textId);
        this.selectedProduct = Dao.getDao().getProductById(id);
    }
}
