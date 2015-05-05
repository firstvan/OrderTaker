package hu.firstvan.model;

import java.sql.Date;

/**
 * This class represent a customer.
 */
public class Customer {

    /**
     * Customer id.
     */
    private Integer c_id;

    /**
     * Customer name.
     */
    private String c_name;

    /**
     * Customer's date of start the store.
     */
    private Date c_startDate;

    /**
     * Customer's address.
     */
    private String c_addr;

    /**
     * Date of first order.
     */
    private Date c_firstOrder;

    /**
     * Create a customer.
     *
     * @param c_name customer's name
     * @param c_startDate customer's start day
     * @param c_addr customer's address
     */
    public Customer(String c_name, Date c_startDate, String c_addr) {
        this.c_name = c_name;
        this.c_startDate = c_startDate;
        this.c_addr = c_addr;

    }

    /**
     * Create a customer.
     *
     * @param c_id customer's id
     * @param c_name customer's name
     * @param c_startDate customer's start day
     * @param c_addr customer's address
     * @param c_firstOrder customer's first order date
     */
    public Customer(int c_id, String c_name, Date c_startDate, String c_addr, Date c_firstOrder) {
        this.c_id = c_id;
        this.c_name = c_name;
        this.c_startDate = c_startDate;
        this.c_addr = c_addr;
        this.c_firstOrder = c_firstOrder;
    }

    /**
     * Return customer's id.
     *
     * @return customer's id
     */
    public Integer getC_id() {
        return c_id;
    }

    /**
     * Set customer's id.
     *
     * @param c_id id of customer
     */
    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    /**
     * Get name of customer.
     *
     * @return name of customer
     */
    public String getC_name() {
        return c_name;
    }

    /**
     * Set name of customer.
     *
     * @param c_name name of customer
     */
    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    /**
     * Get start date of customer.
     *
     * @return start date of customer.
     */
    public Date getC_startDate() {
        return c_startDate;
    }

    /**
     * Set start date of customer.
     *
     * @param c_startDate start date of customer
     */
    public void setC_startDate(Date c_startDate) {
        this.c_startDate = c_startDate;
    }

    /**
     * Get address of customer.
     *
     * @return address of customer.
     */
    public String getC_addr() {
        return c_addr;
    }

    /**
     * Set address of customer.
     *
     * @param c_addr address of customer
     */
    public void setC_addr(String c_addr) {
        this.c_addr = c_addr;
    }

    /**
     * Get first date of customer is ordered.
     *
     * @return first date of customer is ordered
     */
    public Date getC_firstOrder() {
        return c_firstOrder;
    }

    /**
     * Set first date of customer is ordered.
     *
     * @param c_firstOrder first date of customer is ordered
     */
    public void setC_firstOrder(Date c_firstOrder) {
        this.c_firstOrder = c_firstOrder;
    }

    /**
     * Equals two customer, if customer id is identical.
     *
     * @param o another customer
     * @return identical of two customer
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        return !(c_id != null ? !c_id.equals(customer.c_id) : customer.c_id != null);

    }

}
