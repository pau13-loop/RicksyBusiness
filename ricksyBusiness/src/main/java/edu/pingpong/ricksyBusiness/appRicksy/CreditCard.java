package edu.pingpong.ricksyBusiness.appRicksy;

class CreditCard {
    
    private final String owner;
    private final String number;
    private double credit = 3000d;
    private final String SYMBOL = "EZI";

    public CreditCard(String owner, String number) {
        this.owner = owner;
        this.number = number;
    }

    String number() {
        return this.number;
    }

    String cardOwner() {
        return this.owner;
    }

    double credit() {
        return this.credit;
    }

    @Override
    public String toString() {
        return "Owner: " + this.cardOwner() + "\nNumber: " + this.number() + "\nCredit: " + this.credit() + this.SYMBOL; 
    }
}
