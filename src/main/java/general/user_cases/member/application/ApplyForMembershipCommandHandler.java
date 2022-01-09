package general.user_cases.member.application;
import general.kernel.CommandHandler;
import general.kernel.EventDispatcher;
import general.kernel.Event;
import general.user_cases.member.domain.Member;
import general.user_cases.member.domain.MemberId;
import general.user_cases.member.domain.MemberRepository;

public final class ApplyForMembershipCommandHandler implements CommandHandler<ApplyForMembership, MemberId> {
    private final MemberRepository memberRepository;
    private final EventDispatcher<Event> eventEventDispatcher;

    public ApplyForMembershipCommandHandler(MemberRepository memberRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.memberRepository = memberRepository;
        this.eventEventDispatcher = eventEventDispatcher;
    }

    @Override
    public MemberId handle(ApplyForMembership applyForMembership) {
        final MemberId memberId = memberRepository.nextIdentity();
        Member member = Member.of(memberId, applyForMembership.name,applyForMembership.company, applyForMembership.memberShipType);
        memberRepository.add(member);
        eventEventDispatcher.dispatch(new ApplyForMembershipEvent(memberId));
        return memberId;
    }
}
