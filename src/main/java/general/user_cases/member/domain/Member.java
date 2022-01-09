package general.user_cases.member.domain;

import general.kernel.Entity;

import java.util.Objects;

public final class Member implements Entity<MemberId> {
    private MemberId memberId;
    private MemberName name;
    private Company company;
    private MemberShipType memberShipType;


    private Member(MemberId memberId,MemberName name, Company company, MemberShipType memberShipType) {
        this.name = name;
        this.company = company;
        this.memberShipType = memberShipType;
    }

    public static Member of(MemberId memberId,MemberName name,Company company,MemberShipType type){
        return new Member(memberId,name,company,type);
    }

    public MemberId getMemberId() {
        return memberId;
    }

    public MemberName getName() {
        return name;
    }

    public Company getCompany() {
        return company;
    }

    public MemberShipType getMemberShipType() {
        return memberShipType;
    }

    @Override
    public MemberId id() {
        return memberId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(name, member.name) && Objects.equals(company, member.company) && memberShipType == member.memberShipType && Objects.equals(memberId, member.memberId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, company, memberShipType, memberId);
    }
}
