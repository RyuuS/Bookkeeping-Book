package collection;

import entity.Category;
import util.DateUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CollectionTest {
    public static void main(String[] args) {
        /**
         * add  增加对象，默认是object
         * contains 判断是否存在
         * get  获取指定位置的对象
         * indexOf 获取对象所处的位置
         * remove 删除
         * set 替换
         * size 获取大小
         * toArray  转为数组
         * addAll 把另一个容器所有对象都加进来
         * clear    清空
         */
        ArrayList arraysList = new ArrayList();
        arraysList.add("abc");
        arraysList.add(new DateUtil());
        System.out.println(arraysList.contains(new DateUtil()));
        System.out.println(arraysList.set(1,"def"));
        System.out.println(arraysList.get(1));
        arraysList.clear();
        List<Category> categories = new ArrayList<Category>();
        List<Category> categories2 = new ArrayList<>();
        List<?> apHeroList = new ArrayList<>();
        List<Hero> lols = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            lols.add(new Hero("hero" + i));
        }
        Hero heroNum = null;
        int tmp = 0;
        for (int i = 0; i < lols.size(); i++) {
            tmp = Integer.valueOf(lols.get(i).name.substring(4));
            if(tmp%8==0) {
                System.out.println(lols.get(i));
                lols.remove(i);
            }
        }
        List<Hero> linkedList =new LinkedList<>();
        /**
         * ll.getFirst();
         * ll.getLast();
         * ll.removeFirst();
         * ll.removeLast();
         */
        List<Hero> arrayList = new ArrayList<>();
        insert(linkedList);
        insert(arrayList);
    }
    public static void insert(List<Hero> l){
        double start = System.currentTimeMillis();
        Hero hero = new Hero("test");
        for (int i = 0; i < 10000; i++) {
            l.add(0,hero);
        }
        double end = System.currentTimeMillis();
        System.out.printf("%s在头部添加元素需要%f毫秒\n",l.getClass().getName(),end-start);
    }
}
class LOL {

}
class Item extends LOL{

}
class Hero extends LOL{
    String name;
    public Hero(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                '}';
    }
}
