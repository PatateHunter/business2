package general.kernel;

import general.user_cases.member.domain.Log;
import general.user_cases.member.domain.LogId;
import general.user_cases.member.infrastructure.InMemoryLogRepository;

public class NoSuchLogException extends RuntimeException {
    private static final String messageStart = "No log entity found with ID %d." ;
    public NoSuchLogException(String message) {
        super(message);
    }

    public static NoSuchLogException withId(LogId id) {
        InMemoryLogRepository inMemoryLogRepository = InMemoryLogRepository.getInstance();
        LogId logid = inMemoryLogRepository.nextIdentity();
        inMemoryLogRepository.add(new Log(logid,messageStart + id));
        return new NoSuchLogException(String.format(messageStart, id.getValue()));
    }
}
