package general.user_cases.member.exposition;

import general.user_cases.member.domain.MemberShipType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class MemberRequest {

    @NotNull
    @NotBlank
    public MemberNameRequest memberName;

    @NotNull
    @NotBlank
    public CompanyRequest company;

    @NotNull
    public MemberShipType memberShipType;
}
