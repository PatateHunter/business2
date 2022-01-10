package general.user_cases.member.exposition;

import general.user_cases.member.domain.MemberShipType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class MemberRequest {

    @NotNull
    @NotBlank
    public String memberName;

    @NotNull
    public CompanyRequest company;

    @NotNull
    public String memberShipType;

    @NotNull
    public String paymentType;
}
