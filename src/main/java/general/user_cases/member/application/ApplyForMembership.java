package general.user_cases.member.application;

import general.user_cases.member.domain.Company;
import general.user_cases.member.domain.MemberName;
import general.user_cases.member.domain.MemberShipType;
import general.kernel.Command;

public class ApplyForMembership implements Command {

    public final MemberName name;
    public final Company company;
    public final MemberShipType memberShipType;

    public ApplyForMembership(MemberName name, Company company, MemberShipType memberShipType) {
        this.name = name;
        this.company = company;
        this.memberShipType = memberShipType;
    }
}
