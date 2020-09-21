package service;

import dao.CategoryDAO;
import dao.ConfigDAO;
import entity.Category;

public class CategoryService {
    public static String name = "";
    public static CategoryDAO dao;
    static {
        init(name);
    }
    public static void init(String name){
        Category category = dao.getKey(name);
        if(category == null){
            category.setName(name);
            dao.add(category);
        }
    }
}
