package general.user_cases.member.application;

import general.user_cases.member.domain.Log;
import general.user_cases.member.domain.LogId;
import general.user_cases.member.infrastructure.InMemoryLogRepository;

public final class NoSuchPaymentType extends RuntimeException{
    private static final String messageStart = "No Payment type for " ;
    public NoSuchPaymentType(String message) {
        super(message);
    }

    public static NoSuchPaymentType WithLog(String input){
        InMemoryLogRepository inMemoryLogRepository = InMemoryLogRepository.getInstance();
        LogId logid = inMemoryLogRepository.nextIdentity();
        inMemoryLogRepository.add(new Log(logid,messageStart + input));
        return new NoSuchPaymentType(messageStart + input);
    }
}
