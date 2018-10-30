package beans;

import dao.Dao;
import model.Product;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class ProductDetailBean {
    private Dao dao = Dao.getDao();
    private Product selectedProduct;

    @ManagedProperty("#{param.id}")
    private int productId;

    @ManagedProperty("#{topProductsBean}")
    private TopProductsBean topProductsBean;

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
        if (productId > 0)
                this.selectedProduct = dao.getProductById(productId);
    }

    public TopProductsBean getTopProductsBean() {
        return topProductsBean;
    }

    public void setTopProductsBean(TopProductsBean topProductsBean) {
        this.topProductsBean = topProductsBean;
        Product p = topProductsBean.getChoiceProduct();
        if (p != null)
            this.selectedProduct = p;
    }
}
