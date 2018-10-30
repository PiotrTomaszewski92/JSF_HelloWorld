package beans;

import dao.Dao;
import model.Product;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class TopProductsBean {
    private Product choiceProduct;
    private List<SelectItem> topProducts;
    private Dao dao = Dao.getDao();

    public TopProductsBean(){
        this.topProducts = new ArrayList<>();
        List<Product> products = dao.getTopProducts();
        for (Product p : products)
            this.topProducts.add(new SelectItem(p, p.getName()));
    }


    public Product getChoiceProduct() {
        return choiceProduct;
    }

    public void setChoiceProduct(Product choiceProduct) {
        this.choiceProduct = choiceProduct;
    }

    public List<SelectItem> getTopProducts() {
        return topProducts;
    }

    public void setTopProducts(List<SelectItem> topProducts) {
        this.topProducts = topProducts;
    }



}
