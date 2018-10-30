package converters;

import dao.Dao;
import model.Product;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

public class ProductConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        int id = Integer.parseInt(s);
        Product p = Dao.getDao().getProductById(id);
        return p;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        Product p = (Product)o;
        return p.getId() + "";
    }
}
