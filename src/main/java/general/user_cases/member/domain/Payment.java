package general.user_cases.member.domain;

import general.kernel.Entity;

public class Payment implements Entity<PaymentId> {
    private PaymentId paymentId;
    private Amount amount;
    private Member member;

    public Payment(PaymentId paymentId,Amount amount, Member member) {
        this.amount = amount;
        this.member = member;
        this.paymentId = paymentId;
    }

    public Amount getAmount() {
        return amount;
    }

    public Member getMember() {
        return member;
    }

    @Override
    public PaymentId id() {
        return paymentId;
    }
}
