package general.user_cases.member.domain;

public enum MemberShipType {

   annual(new Amount(300,"$"));

    private Amount amount;
    MemberShipType(Amount amount) {
      this.amount = amount;
    }

    public Amount getAmount() {
        return amount;
    }
}
