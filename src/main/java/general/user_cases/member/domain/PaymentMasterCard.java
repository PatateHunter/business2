package general.user_cases.member.domain;

import java.util.Objects;

public class PaymentMasterCard implements PaymentStategy{
    @Override
    public void pay(Payment payment) {
        System.out.println("Membre "+payment.getMember().id().getValue() + " payment avec master card");
       // On peut rajouter ici une exception personnalisée si le payment rate
    }
}
