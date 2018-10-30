package beans;

import dao.Dao;
import model.Category;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.ListDataModel;

@ManagedBean
@RequestScoped
public class CategoryBean {
    private ListDataModel<Category> categoryModel = new ListDataModel<>();


    public CategoryBean() {
        categoryModel.setWrappedData(Dao.getDao().getCategoryList());
    }

    public ListDataModel<Category> getCategoryModel() {
        return categoryModel;
    }

    public void setCategoryModel(ListDataModel<Category> categoryModel) {
        this.categoryModel = categoryModel;
    }

}
