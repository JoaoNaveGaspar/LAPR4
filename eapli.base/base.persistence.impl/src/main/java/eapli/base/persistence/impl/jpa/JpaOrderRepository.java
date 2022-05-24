package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.ordermanagement.domain.Orders;
import eapli.base.ordermanagement.repositories.OrderRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JpaOrderRepository extends JpaAutoTxRepository<Orders, String, String> implements OrderRepository {
    public JpaOrderRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JpaOrderRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "id");
    }

}
