package Domain.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Set;
import Persistence.CustomerPersist;

import static javax.persistence.Persistence.createEntityManagerFactory;

public class CustomerController {
    CustomerPersist customerPersist=new CustomerPersist();
    public void createCustomer(String nome, int vat, int phonenumber, String email, Set<Billing_Address>billing_addresses,Set<Delivering_Address>delivering_addresses,String birth,String gender) {
        Customer customer = new Customer(nome,vat, phonenumber, email);
        customer.setBilling_addresses(billing_addresses);
        customer.setDelivering_addresses(delivering_addresses);
        customer.setBirth_date(birth);
        customer.setGender(gender);
        customerPersist.createcustomerpersist(customer);
    }


}
