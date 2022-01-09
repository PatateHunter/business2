package general.user_cases.member.application;

import general.kernel.EventListener;

public class ApplyForMembershipEventListener implements EventListener<ApplyForMembershipEvent> {
    @Override
    public void listenTo(ApplyForMembershipEvent event) {
        System.out.println("ApplyForMembershipEvent");
    }
}
