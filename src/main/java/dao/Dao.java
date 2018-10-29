package dao;

public class Dao {

    private static Dao instance = new Dao();

    public static Dao getDao(){
        return instance;
    }
}
