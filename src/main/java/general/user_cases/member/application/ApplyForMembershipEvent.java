package general.user_cases.member.application;

import general.kernel.ApplicationEvent;
import general.user_cases.member.domain.MemberId;

public class ApplyForMembershipEvent implements ApplicationEvent {
    private final MemberId memberId;

    public ApplyForMembershipEvent(MemberId memberId){ this.memberId = memberId;}
        }
