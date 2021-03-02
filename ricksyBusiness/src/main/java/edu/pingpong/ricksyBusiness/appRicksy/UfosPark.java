package edu.pingpong.ricksyBusiness.appRicksy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UfosPark implements GuestDispatcher{
    
    private double fee = 500;
    private final Map<String, String> flota = new HashMap<String, String>();

    UfosPark() {}

    void add(String ufoId) {
        flota.put(ufoId, null);
    }

    @Override
    public void dispatch(CreditCard card) {

        Map.Entry<String, String> ovni = null;

        if(!this.flota.containsValue(card.number())) {
            for (Map.Entry<String, String> ufo : this.flota.entrySet()) {
                if(ufo.getValue() == null) {
                    ovni = ufo;
                    break;
                }
            }
        }
        if(ovni != null && card.pay(fee)) {
            this.flota.put(ovni.getKey(), card.number());
        }    
    }

    String getUfoOf(String cardNumber) {
        String answ = null;

        if(this.flota.containsValue(cardNumber)) {
            for (Map.Entry<String, String> ufo : this.flota.entrySet()) {
            if (ufo.getValue() == cardNumber) {
                answ = ufo.getKey();
                break;
                }
            } 
        }
        return answ;
    }

    @Override
    public String toString() {
        ArrayList<String> ufosIdList = new ArrayList<String>(this.flota.keySet());
        Collections.sort(ufosIdList);
        return ufosIdList.toString();
    }

    boolean containsCard(String cardNumber) {
        return this.flota.containsValue(cardNumber);
    }

    Collection<String> cardNumbers() {
        return this.flota.values();
    }
}
