package general.user_cases.member.application;
import general.kernel.CommandHandler;
import general.kernel.EventDispatcher;
import general.kernel.Event;
import general.user_cases.member.domain.*;

public final class ApplyForMembershipCommandHandler implements CommandHandler<ApplyForMembership, MemberId> {
    private final MemberRepository memberRepository;
    private final PaymentRepository paymentRepository;
    private final EventDispatcher<Event> eventEventDispatcher;

    public ApplyForMembershipCommandHandler(MemberRepository memberRepository,PaymentRepository paymentRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.memberRepository = memberRepository;
        this.eventEventDispatcher = eventEventDispatcher;
        this.paymentRepository = paymentRepository;
    }

    @Override
    public MemberId handle(ApplyForMembership applyForMembership) {
        final MemberId memberId = memberRepository.nextIdentity();
        Member member = new Member(memberId, applyForMembership.name,applyForMembership.company, applyForMembership.subscription);

        final PaymentId paymentId = paymentRepository.nextIdentity();
        Payment payment = new Payment(paymentId,applyForMembership.subscription.getAmount(),member);

        PaymentContext paymentContext = new PaymentContext(applyForMembership.PaymentType);
        paymentContext.pay(payment);

        paymentRepository.add(payment);


        memberRepository.add(member);
        eventEventDispatcher.dispatch(new ApplyForMembershipEvent(memberId));
        return memberId;
    }
}
