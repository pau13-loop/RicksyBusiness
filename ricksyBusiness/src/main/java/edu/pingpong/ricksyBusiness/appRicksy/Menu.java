package edu.pingpong.ricksyBusiness.appRicksy;

import java.util.ArrayList;
import java.util.List;

public class Menu implements GuestDispatcher{

    private int stock = 0;
    private double menuCost = 0d;
    
    Menu(int stock, double menuCost) {
        this.stock = stock;
        this.menuCost = menuCost;
    }

    List<String> customersList = new ArrayList<>();

    @Override
    public void dispatch(CreditCard card) {
        if(this.stock > 0 && card.pay(menuCost)) {
            this.stock--;
            addCustomer(card);
        }
    }

    private void addCustomer(CreditCard card) {
        customersList.add(card.cardOwner());
    }

    public List<String> getCustomersList() {
        return this.customersList;
    }

    int stock() {
        return this.stock;
    }

    @Override
    public String toString() {
        return "Stock: " + stock() + "\n" + getCustomersList();
    }
}
