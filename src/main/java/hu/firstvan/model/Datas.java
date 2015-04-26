package hu.firstvan.model;


import org.joda.time.Instant;
import org.joda.time.ReadableInstant;
import org.joda.time.Years;

import java.util.ArrayList;

/**
 * Created by firstvan on 2015.04.17..
 */
public class Datas {
    private static Customer customer;

    public static Customer getCustomer() {
        return customer;
    }

    public static void setCustomer(Customer customer) {
        Datas.customer = customer;
    }

    private static ArrayList<Products> orderdItems = new ArrayList<>();

    public static void add(Products p) {
        int orderdTemp = 0;
        if (orderdItems.contains(p)) {
            for (int i = 0; i < orderdItems.size(); i++) {
                if (orderdItems.get(i).equals(p)) {
                    orderdTemp = orderdItems.get(i).getOrderdPiece();
                    orderdItems.remove(i);
                }
            }
        }
        p.setOrderdPiece(p.getOrderdPiece() + orderdTemp);
        orderdItems.add(p);
    }

    public static void remove(Products p) {
        for (int i = 0; i < orderdItems.size(); i++) {
            if (orderdItems.get(i).equals(p)) {
                orderdItems.remove(i);
            }
        }
    }

    public static ArrayList<Products> getOrderdItems() {
        return orderdItems;
    }

    public static int getGrandTotal() {
        int sum = 0;

        for (Products p : orderdItems) {
            sum += p.getSubTotal();
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

    public static void modifyPiece(Products p, int newPiece) {

        if (orderdItems.contains(p)) {
            for (int i = 0; i < orderdItems.size(); i++) {
                if (orderdItems.get(i).equals(p)) {
                    orderdItems.remove(i);
                }
            }
        }

        p.setOrderdPiece(newPiece);
        orderdItems.add(p);
    }
}
