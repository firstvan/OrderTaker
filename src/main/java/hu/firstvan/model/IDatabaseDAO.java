package hu.firstvan.model;

import java.util.List;

/**
 * Interface that represent DatabaseDao need to implement.
 */
public interface IDatabaseDAO {
    List<Customer> getAllCustomer();
    void AddCustomer(Customer customer);
    List<Orders> GetUserOrders(int userid);
    List<Products> getSearchedProducts(String name);
    void closeOrder();
}
