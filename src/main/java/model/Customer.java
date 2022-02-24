package model;

import model.common.Person;
import enums.Gender;

import java.util.HashMap;
import java.util.Map;

public class Customer extends Person {
  private double walletBalance;
  private final Map<String, Integer>  cart = new HashMap<>();

  public Customer(String firstName, String lastName, Gender gender, double walletBalance){
      super(firstName,lastName,gender);
      this.walletBalance = walletBalance;
  }

  public double getWalletBalance() {
    return walletBalance;
  }

  public void setWalletBalance(int amount){walletBalance+= amount;}

  public Map<String, Integer> getCart() {
    return cart;
  }
}
