package eapli.base.customermanagement.application;


import eapli.base.customermanagement.domain.model.Customer;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import org.springframework.beans.factory.annotation.Autowired;


@UseCaseController
public class ListCustomerController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    @Autowired
    private ListCustomerServices lcs;

    public Iterable<Customer> allCustomers() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.SALES_CLERK);
        return lcs.allCustomers();
    }

}
