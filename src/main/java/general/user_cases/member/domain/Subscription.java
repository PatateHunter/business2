package general.user_cases.member.domain;

import general.user_cases.member.application.SubscriptionNotFound;

import java.util.Objects;

public class Subscription {

    private Amount amount;

    public Subscription (String name) {
     if(Objects.equals(name, MemberShipType.annual.getValue())){
         this.amount = new Amount(300.0,"$");
         return;
     }

     throw SubscriptionNotFound.WithLog(name);
    }

    public Amount getAmount() {
        return amount;
    }

    public Subscription (Double amount, String currency){
         this.amount = new Amount(amount,currency);
    }

}
