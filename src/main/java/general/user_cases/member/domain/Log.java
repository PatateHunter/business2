package general.user_cases.member.domain;

import general.kernel.Entity;

import java.util.Objects;

public final class Log implements Entity<LogId> {
    private LogId logid;
    private String message;

    public Log(LogId logid, String message) {
        this.logid = logid;
        this.message = message;
    }


    @Override
    public LogId id() {
        return logid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Log log = (Log) o;
        return Objects.equals(logid, log.logid) && Objects.equals(message, log.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(logid, message);
    }

    @Override
    public String toString() {
        return "Log{" +
                "logid=" + logid +
                ", message='" + message + '\'' +
                '}';
    }
}
