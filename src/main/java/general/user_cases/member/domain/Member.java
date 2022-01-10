package general.user_cases.member.domain;

import general.kernel.Entity;

import java.util.Objects;

public final class Member implements Entity<MemberId> {
    private MemberId memberId;
    private MemberName name;
    private Company company;
    private Subscription subscription;


    public Member(MemberId memberId,MemberName name, Company company, Subscription subscription) {
        this.memberId = memberId;
        this.name = name;
        this.company = company;
        this.subscription = subscription;
    }

   /* public static Member of(MemberId memberId,MemberName name,Company company,MemberShipType type){
        return new Member(memberId,name,company,type);
    }*/

    public MemberId getMemberId() {
        return memberId;
    }

    public MemberName getName() {
        return name;
    }

    public Company getCompany() {
        return company;
    }


    @Override
    public MemberId id() {
        return memberId;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(memberId, member.memberId) && Objects.equals(name, member.name) && Objects.equals(company, member.company) && Objects.equals(subscription, member.subscription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, name, company, subscription);
    }
}
