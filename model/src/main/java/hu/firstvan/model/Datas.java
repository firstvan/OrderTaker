package hu.firstvan.model;


import org.joda.time.Instant;
import org.joda.time.ReadableInstant;
import org.joda.time.Years;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

/**
 * It's a static class to store all important data, like actual customer, ordered items.
 */
public class Datas {

    /**
     * Actual customer.
     */
    private static Customer customer;

    /**
     * Return the actual customer.
     *
     * @return actual customer
     */
    public static Customer getCustomer() {
        return customer;
    }

    /**
     * Set the actual customer.
     *
     * @param customer customer, who will be shopping
     */
    public static void setCustomer(Customer customer) {
        Datas.customer = customer;
    }

    /**
     * List of ordered items.
     */
    private static ArrayList<Products> orderedItems = new ArrayList<>();

    /**
     * Add a product to the ordered list.
     *
     * @param p product, what we want to add order
     */
    public static void add(Products p) {
        int orderedTemp = 0;
        if (orderedItems.contains(p)) {
            for (int i = 0; i < orderedItems.size(); i++) {
                if (orderedItems.get(i).equals(p)) {
                    orderedTemp = orderedItems.get(i).getOrderdPiece();
                    orderedItems.remove(i);
                }
            }
        }
        p.setOrderdPiece(p.getOrderdPiece() + orderedTemp);
        orderedItems.add(p);
    }

    /**
     * Remove a product from ordered items.
     *
     * @param p product, what we want to remove
     */
    public static void remove(Products p) {
        for (int i = 0; i < orderedItems.size(); i++) {
            if (orderedItems.get(i).equals(p)) {
                orderedItems.remove(i);
            }
        }
    }

    /**
     * Get the list of ordered items.
     *
     * @return list of ordered items
     */
    public static ArrayList<Products> getOrderedItems() {
        return orderedItems;
    }

    /**
     * Calculate the grand total of order. It's contain sales.
     *
     * @return grand total of order
     */
    public static int getGrandTotal() {
        int sum = 0;
        int sales = 0;
        int countDeo = 0;
        for (Products p : orderedItems) {
            int actual = p.getSubTotal();

            if(countDeo == 5){
                sales++;
                countDeo = 0;
            }

            if(sales > 0) {
                if(p.getName().toLowerCase().contains("golyos")){
                    actual = (int)(actual * 0.90);
                    sales--;
                }
            }

            if(p.getName().toLowerCase().contains("deo")){
                countDeo++;
            }

            sum += actual;
        }

        ReadableInstant instant = new Instant(customer.getC_startDate());

        Years years = Years.yearsBetween(instant, new Instant());
        if (years.getYears() >= 30) {
            double temp = sum * 0.97;
            sum = (int) temp;
        } else if (years.getYears() >= 20) {
            double temp = sum * 0.98;
            sum = (int) temp;
        } else if (years.getYears() >= 10) {
            double temp = sum * 0.99;
            sum = (int) temp;
        }

        instant = new Instant(customer.getC_firstOrder());

        Years loyalityYears = Years.yearsBetween(instant, new Instant());

        if (loyalityYears.getYears() >= 50) {
            double temp = sum * 0.5;
            sum = (int) temp;
        } else if (loyalityYears.getYears() >= 5) {
            double percent = (100 - loyalityYears.getYears()) / (double) 100;
            double temp = sum * percent;
            sum = (int) temp;
        }

        return sum;
    }

    /**
     * Modify an ordered piece of an ordered product.
     *
     * @param p product, what we want to modify
     * @param newPiece new piece of modified product
     */
    public static void modifyPiece(Products p, int newPiece) {

        if (orderedItems.contains(p)) {
            for (int i = 0; i < orderedItems.size(); i++) {
                if (orderedItems.get(i).equals(p)) {
                    orderedItems.remove(i);
                    break;
                }
            }
            p.setOrderdPiece(newPiece);
            orderedItems.add(p);
        }
    }
}
