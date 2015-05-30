package hu.firstvan.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by firstvan on 5/30/15.
 */
@XmlRootElement(name="person")
public class SalesByPeople {

    private int id;
    private String name;
    private int sales;

    public SalesByPeople() {
    }

    public SalesByPeople(String name, int sales) {
        this.name = name;
        this.sales = sales;
    }

    public String getName() {
        return name;
    }

    public void setName(String cust_name) {
        this.name = cust_name;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    @XmlAttribute(name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
