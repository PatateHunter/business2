package general.user_cases.member.domain;

public enum MemberShipType {

   annual("annual");

    private String value;
    MemberShipType(String value) {
      this.value = value;
    }

    public String getValue() {
        return value;
    }
}
