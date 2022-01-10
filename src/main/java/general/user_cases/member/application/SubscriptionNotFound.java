package general.user_cases.member.application;

import general.user_cases.member.domain.Log;
import general.user_cases.member.domain.LogId;
import general.user_cases.member.infrastructure.InMemoryLogRepository;

public final class SubscriptionNotFound extends RuntimeException{
    private static final String messageStart = "Subscription not found for " ;

    public SubscriptionNotFound(String message) {
        super(message);
    }

    public static SubscriptionNotFound WithLog(String input){
        InMemoryLogRepository inMemoryLogRepository = InMemoryLogRepository.getInstance();
        LogId logid = inMemoryLogRepository.nextIdentity();
        inMemoryLogRepository.add(new Log(logid,messageStart + input));
        return new SubscriptionNotFound(messageStart + input);
    }


}
