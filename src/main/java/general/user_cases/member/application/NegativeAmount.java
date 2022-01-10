package general.user_cases.member.application;

import general.user_cases.member.domain.Log;
import general.user_cases.member.domain.LogId;
import general.user_cases.member.infrastructure.InMemoryLogRepository;

public final class NegativeAmount extends RuntimeException{
    private static final String messageStart = "Negative amount for " ;
    public NegativeAmount(String message) {
        super(message);
    }

    public static NegativeAmount WithLog(Double input){
        InMemoryLogRepository inMemoryLogRepository = InMemoryLogRepository.getInstance();
        LogId logid = inMemoryLogRepository.nextIdentity();
        inMemoryLogRepository.add(new Log(logid,messageStart + input));
        return new NegativeAmount(messageStart + input);
    }
}
