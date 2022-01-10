package general.user_cases.member.infrastructure;

import general.kernel.NoSuchEntityException;
import general.kernel.NoSuchPaymentException;
import general.user_cases.member.domain.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryPaymentRepository implements PaymentRepository {
    private final AtomicInteger count = new AtomicInteger(0);

    private final Map<PaymentId, Payment> data = new ConcurrentHashMap<>();


    @Override
    public PaymentId nextIdentity() {
        return new PaymentId(count.incrementAndGet());
    }

    @Override
    public Payment findById(PaymentId id) throws NoSuchEntityException {
        final Payment payment = data.get(id);
        if (payment == null) {
            throw NoSuchPaymentException.withId(id);
        }
        return payment;
    }

    @Override
    public void add(Payment payment) {
        data.put(payment.id(),payment);
    }

    @Override
    public void delete(PaymentId id) {
        data.remove(id);
    }

    @Override
    public List<Payment> findAll() {
        return List.copyOf(data.values());
    }
}
