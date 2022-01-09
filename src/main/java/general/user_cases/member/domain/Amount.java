package general.user_cases.member.domain;

import general.user_cases.member.application.NegativeAmount;
import general.user_cases.member.application.NoCurrencyForAmount;

public final class Amount {
    private double amount;
    private String currency;

    public Amount(double amount, String currency) {
        if(amount<0){
            throw new NegativeAmount();
        }
        if(!currency.equals("")){
            throw new NoCurrencyForAmount();
        }

        this.amount = amount;
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }
    public String getCurrency() {
        return currency;
    }

}
