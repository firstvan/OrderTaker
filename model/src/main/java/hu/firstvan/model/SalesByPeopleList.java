package hu.firstvan.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by firstvan on 5/30/15.
 */
public class SalesByPeopleList {

    List<SalesByPeople> list;

    public SalesByPeopleList() {
        list = new ArrayList<>();
    }

    public List<SalesByPeople> getList() {
        return list;
    }

    public void setList(List<SalesByPeople> list) {
        this.list = list;
    }

    public SalesByPeopleList(List<SalesByPeople> list) {
        this.list = list;
    }
}
