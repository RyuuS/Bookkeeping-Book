package gui.model;

import entity.Category;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.util.ArrayList;
import java.util.List;

public class CategoryComboBoxModel implements ComboBoxModel {
    //在RecordPanel下，下拉框用到的是Category表
    public List<Category> cs = new ArrayList<>();
    Category c;

    public CategoryComboBoxModel() {
        if(!cs.isEmpty())
            c = cs.get(0);
    }

    @Override
    public void setSelectedItem(Object anItem) {
    }

    @Override
    public Object getSelectedItem() {
        if(!cs.isEmpty())
            return c;
        else return null;
    }

    @Override
    public int getSize() {
        return cs.size();
    }

    @Override
    public Object getElementAt(int index) {
        return cs.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {

    }

    @Override
    public void removeListDataListener(ListDataListener l) {

    }
}
