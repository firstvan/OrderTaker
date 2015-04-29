package hu.firstvan.model;

import java.sql.Date;

/**
 * Created by firstvan on 2015.04.17..
 */
public class Customer {

    private Integer c_id;
    private String c_name;
    private Date c_startDate;
    private String c_addr;
    private Date c_firstOrder;

    public Customer(String c_name, Date c_startDate, String c_addr) {
        this.c_name = c_name;
        this.c_startDate = c_startDate;
        this.c_addr = c_addr;

    }

    public Customer(int c_id, String c_name, Date c_startDate, String c_addr, Date c_firstOrder) {
        this.c_id = c_id;
        this.c_name = c_name;
        this.c_startDate = c_startDate;
        this.c_addr = c_addr;
        this.c_firstOrder = c_firstOrder;
    }

    public Integer getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public Date getC_startDate() {
        return c_startDate;
    }

    public void setC_startDate(Date c_startDate) {
        this.c_startDate = c_startDate;
    }

    public String getC_addr() {
        return c_addr;
    }

    public void setC_addr(String c_addr) {
        this.c_addr = c_addr;
    }

    public Date getC_firstOrder() {
        return c_firstOrder;
    }

    public void setC_firstOrder(Date c_firstOrder) {
        this.c_firstOrder = c_firstOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        return !(c_id != null ? !c_id.equals(customer.c_id) : customer.c_id != null);

    }

}
