package general;

import general.kernel.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import general.user_cases.member.application.ApplyForMembership;
import general.user_cases.member.application.ApplyForMembershipCommandHandler;
import general.user_cases.member.application.ApplyForMembershipEvent;
import general.user_cases.member.application.ApplyForMembershipEventListener;
import general.user_cases.member.domain.MemberRepository;
import general.user_cases.member.infrastructure.DefaultEventDispatcher;
import general.user_cases.member.infrastructure.InMemoryMemberRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class MemberConfiguration {

    @Bean
    public MemberRepository memberRepository() {
        return new InMemoryMemberRepository();
    }

    @Bean
    public EventDispatcher<Event> eventEventDispatcher() {
        final Map<Class<? extends Event>, List<EventListener<? extends Event>>> listenerMap = new HashMap<>();
       // listenerMap.put(ModifyUserAddressEvent.class, List.of(new ModifyUserAddressEventListener()));
        listenerMap.put(ApplyForMembershipEvent.class, List.of(new ApplyForMembershipEventListener()));
        return new DefaultEventDispatcher(listenerMap);
    }

    @Bean
    public ApplyForMembershipCommandHandler applyForMembershipCommandHandler() {
        return new ApplyForMembershipCommandHandler(memberRepository(), eventEventDispatcher());
    }

  /*  @Bean
    public ModifyUserAddressCommandHandler modifyUserAddressCommandHandler() {
        return new ModifyUserAddressCommandHandler(userRepository(), eventEventDispatcher());
    }*/

    @Bean
    public CommandBus commandBus() {
        final Map<Class<? extends Command>, CommandHandler> commandHandlerMap = new HashMap<>();
        commandHandlerMap.put(ApplyForMembership.class, new ApplyForMembershipCommandHandler(memberRepository(), eventEventDispatcher()));
      //  commandHandlerMap.put(ModifyUserAddress.class, new ModifyUserAddressCommandHandler(userRepository(), eventEventDispatcher()));
        return new SimpleCommandBus(commandHandlerMap);
    }

   /* @Bean
    public QueryBus queryBus() {
        final Map<Class<? extends Query>, QueryHandler> queryHandlerMap =
                Collections.singletonMap(RetrieveUsers.class, new RetrieveUsersHandler(userRepository()));
        return new SimpleQueryBus(queryHandlerMap);
    }*/


}
