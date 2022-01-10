package general.user_cases.member.domain;

public enum PaymentContextType {
    masterCard("MasterCard");

    private String value;
    PaymentContextType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
