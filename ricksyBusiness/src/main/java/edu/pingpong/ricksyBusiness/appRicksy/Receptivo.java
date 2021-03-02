package edu.pingpong.ricksyBusiness.appRicksy;

import java.util.LinkedHashSet;
import java.util.Set;

class Receptivo {
    
    private Set<GuestDispatcher> guests = new LinkedHashSet<>();

    void registra(GuestDispatcher guest) {
        guests.add(guest);
    }

    void dispatch(CreditCard card) {
        guests.forEach(guest -> guest.dispatch(card));
    }
}
