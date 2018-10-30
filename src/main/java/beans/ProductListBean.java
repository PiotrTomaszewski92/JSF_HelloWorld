package beans;

import dao.Dao;
import model.Category;
import model.Product;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;
import java.util.List;

@ManagedBean
@SessionScoped
public class ProductListBean {
    private ListDataModel<Product> productModel = new ListDataModel<>();
    private Category category;
    private int page = 0;

    private Dao dao = Dao.getDao();

    public ProductListBean(){
        this.refreshModel();
    }

    private void refreshModel() {
        List<Product> list = dao.getProductByCategory(category,page * Dao.PAGE_SIZE, Dao.PAGE_SIZE);
        this.productModel.setWrappedData(list);
    }

    public ListDataModel<Product> getProductModel() {
        return productModel;
    }

    public void setProductModel(ListDataModel<Product> productModel) {
        this.productModel = productModel;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
        this.page = 0;
        this.refreshModel();
    }

    public boolean isNext(){
        double maxPage = Math.ceil((dao.getCountProducts(this.category)+0.0) / Dao.PAGE_SIZE) - 1;
        return (page < maxPage);
    }

    public boolean isPrevious(){
        return this.page > 0;
    }

    public String showPrevious(){
        this.page--;
        this.refreshModel();
        return "";
    }

    public String showNext(){
        this.page++;
        this.refreshModel();
        return "";
    }


}
