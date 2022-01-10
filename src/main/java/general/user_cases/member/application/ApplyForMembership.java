package general.user_cases.member.application;

import general.user_cases.member.domain.Company;
import general.user_cases.member.domain.MemberName;
import general.kernel.Command;
import general.user_cases.member.domain.Subscription;


public final class ApplyForMembership implements Command {

    public final MemberName name;
    public final Company company;
    public final Subscription subscription;
    public final String PaymentType;

    public ApplyForMembership(MemberName name, Company company, Subscription subscription, String paymentType) {
        this.name = name;
        this.company = company;
        this.subscription = subscription;
        PaymentType = paymentType;
    }
}
