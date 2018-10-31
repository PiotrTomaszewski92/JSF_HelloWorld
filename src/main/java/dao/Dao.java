package dao;

import model.Category;
import model.Order;
import model.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Dao {

    private static Dao instance = new Dao();
    private List<Category> categoryList = new ArrayList<>();
    private List<Product> productList = new ArrayList<>();
    private List<Order> orderList = new ArrayList<>();

    public static final int PAGE_SIZE = 3;


    {
        Category processor = new Category(1,"processor");
        Category memory = new Category(2,"memory");
        categoryList.add(processor);
        categoryList.add(memory);

        Product p = new Product(1,"Processor Quad", new BigDecimal( 550), 10, processor ,"Example description");
        productList.add(p);
        p = new Product(2,"Processor Dual", new BigDecimal( 4400), 10, processor ,"Example description");
        productList.add(p);
        p = new Product(3,"Processor Single", new BigDecimal( 30), 10, processor ,"Example description");
        productList.add(p);
        p = new Product(4,"Processor ABC", new BigDecimal( 4400), 10, processor ,"Example description");
        productList.add(p);
        p = new Product(5,"Processor Trio", new BigDecimal( 30), 10, processor ,"Example description");
        productList.add(p);
        p = new Product(4,"RAM 4GB", new BigDecimal( 350), 10, memory ,"Example description");
        productList.add(p);


    }

    public static Dao getDao(){
        return instance;
    }

    private List<Product> getProductByCategory(Category category){
        List<Product> selected = new ArrayList<>();
        if(category == null)
            selected = this.productList;
        else
            for(Product p : productList)
                if (p.getCategory().equals(category))
                        selected.add(p);

        return selected;
    }

    public  List<Product> getProductByCategory(Category category, int start, int count){
        List<Product> selected = getProductByCategory(category);

        if (start >= selected.size())
            return new ArrayList<>();
        else
            if(start < selected.size() && start + count > selected.size())
                selected = selected.subList(start,selected.size());
            else
                selected = selected.subList(start, start + count);

        return selected;
    }

    public int getCountProducts (Category category){
        return getProductByCategory(category).size();
    }

    public List<Category> getCategoryList(){
        return this.categoryList;
    }

    public Product getProductById(int id){
        for (Product p : productList)
            if (p.getId() == id)
                return p;
        return null;
    }

    public List<Product> getTopProducts(){
        return this.productList.subList(0,2);
    }

    public void addOrder(Order order){
        orderList.add(order);
    }
}
