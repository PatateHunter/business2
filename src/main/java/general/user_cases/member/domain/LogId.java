package general.user_cases.member.domain;

import general.kernel.ValueObjectID;

import java.util.Objects;

public final class LogId implements ValueObjectID {
    private final int value;

    public LogId(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogId logId = (LogId) o;
        return value == logId.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "LogId{" +
                "value=" + value +
                '}';
    }
}
