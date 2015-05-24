package hu.firstvan.model;

import java.sql.Date;

/**
 * Represent an order.
 */
public class Orders {
    /**
     * Order id.
     */
    private Integer o_id;

    /**
     * Customer id, who takes order.
     */
    private Integer c_id;

    /**
     * Date of order.
     */
    private Date date;

    /**
     * Grand total of order.
     */
    private Integer order_total;

    /**
     * Constructor to create an order.
     *
     * @param o_id        order id
     * @param c_id        customer id
     * @param date        date of order
     * @param order_total grand total of order
     */
    public Orders(int o_id, int c_id, Date date, int order_total) {
        this.o_id = o_id;
        this.c_id = c_id;
        this.date = date;
        this.order_total = order_total;
    }

    /**
     * Return order id.
     *
     * @return order id
     */
    public Integer getO_id() {
        return o_id;
    }

    /**
     * Set order id.
     *
     * @param o_id order id
     */
    public void setO_id(Integer o_id) {
        this.o_id = o_id;
    }

    /**
     * Get customer id of order.
     *
     * @return customer id of order
     */
    public Integer getC_id() {
        return c_id;
    }

    /**
     * Set customer id of order.
     *
     * @param c_id customer id of order
     */
    public void setC_id(Integer c_id) {
        this.c_id = c_id;
    }

    /**
     * Get date of order.
     *
     * @return date of order.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Set date of order.
     *
     * @param date date of order
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Get grand total of order.
     *
     * @return grand total of order.
     */
    public Integer getOrder_total() {
        return order_total;
    }

    /**
     * Set grand total of order.
     *
     * @param order_total grand total of order.
     */
    public void setOrder_total(Integer order_total) {
        this.order_total = order_total;
    }
}
