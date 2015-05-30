package hu.firstvan.model;

/**
 * Created by firstvan on 5/30/15.
 */
public class SalesByPeople {

    private String cust_name;
    private int sales;

    public SalesByPeople() {
    }

    public SalesByPeople(String cust_name, int sales) {
        this.cust_name = cust_name;
        this.sales = sales;
    }

    public String getCust_name() {
        return cust_name;
    }

    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }
}
