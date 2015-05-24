package hu.firstvan.model;

import java.util.List;

/**
 * Interface that represent DatabaseDao need to implement.
 */
public interface IDatabaseDAO {

    /**
     * Get all customer from database.
     *
     * @return ArrayList of all customer.
     */
    List<Customer> getAllCustomer();

    /**
     * Add a customer to the database. The first order date is the sysdate.
     *
     * @param customer customer to add database
     */
    void AddCustomer(Customer customer);

    /**
     * Return all orders of customer by id.
     *
     * @param userid customers id
     * @return list of customer orders.
     */
    List<Orders> GetUserOrders(int userid);

    /**
     * Search item by item name. If we call's this function by "", we get back all of the products.
     *
     * @param name item name
     * @return list of the searched item (or all items)
     */
    List<Products> getSearchedProducts(String name);

    /**
     * Close the order. It takes to the database the order.
     */
    void closeOrder();
}
