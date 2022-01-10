package general;

import general.user_cases.member.domain.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import general.user_cases.member.application.ApplyForMembership;
import general.user_cases.member.application.ApplyForMembershipCommandHandler;

@SpringBootApplication
public class SpringMain {
    public static void main(String[] args) {
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringMain.class, args);

        //--1. Create Valid User
        ApplyForMembershipCommandHandler membershipCommandHandler = applicationContext.getBean(ApplyForMembershipCommandHandler.class);
        ApplyForMembership applyForMembership = new ApplyForMembership(new MemberName("Ichai"), new Company("MLR", new CompanyId("527484760")),
                new Subscription(MemberShipType.annual.getValue()), PaymentContextType.masterCard.getValue());
        final MemberId memberId = membershipCommandHandler.handle(applyForMembership);


    }
}
