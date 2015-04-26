package hu.firstvan.model;

import java.sql.Date;

/**
 * Created by firstvan on 2015.04.21..
 */
public class Orders {
    private Integer o_id;
    private Integer c_id;
    private Date date;
    private Integer order_total;

    public Orders(int o_id, int c_id, Date date, int order_total) {
        this.o_id = o_id;
        this.c_id = c_id;
        this.date = date;
        this.order_total = order_total;
    }

    public Integer getO_id() {
        return o_id;
    }

    public void setO_id(Integer o_id) {
        this.o_id = o_id;
    }

    public Integer getC_id() {
        return c_id;
    }

    public void setC_id(Integer c_id) {
        this.c_id = c_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getOrder_total() {
        return order_total;
    }

    public void setOrder_total(Integer order_total) {
        this.order_total = order_total;
    }
}
