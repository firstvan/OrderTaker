package hu.firstvan.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by firstvan on 5/30/15.
 */
@XmlRootElement(name = "saleslist")
public class SalesByPeopleList {

    List<SalesByPeople> list;

    public SalesByPeopleList() {
    }

    @XmlElement(name = "person")
    public List<SalesByPeople> getList() {
        return list;
    }

    public void setList(List<SalesByPeople> list) {
        this.list = list;
    }

    public SalesByPeopleList(List<SalesByPeople> list) {
        this.list = list;
    }

    public double getDiscountByCustomerId(int id) {
        double discount = 1.0;
        for (SalesByPeople s : list){
            if(s.getId() == id){

                discount = (100 - s.getSales())/100.0;
                break;
            }
        }
        return discount;
    }
}
