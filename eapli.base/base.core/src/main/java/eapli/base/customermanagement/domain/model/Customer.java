package eapli.base.customermanagement.domain.model;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Customer implements Serializable, DomainEntity<Integer>, AggregateRoot<Integer> {
    @Id
    private int vat;
    private int phone_number;
    private String birth_date, gender, email, name;
    private final int vat_default = 0, phone_numberdefault = 0;
    private final String birth_datedefault = "No birth daate available", gender_default = "No gender available", email_default = "No email available";
    @ElementCollection
    private Set<Billing_Address> billing_addresses = new HashSet<>();
    @ElementCollection
    private Set<Delivering_Address> delivering_addresses = new HashSet<>();
    @Embedded
    private Shopping_Cart shopping_cart;
    @Embedded
    private Validation validation;

    protected Customer() {
        this.email = email_default;
        this.vat = vat_default;
        this.phone_number = phone_numberdefault;
        this.name = "No name available";
    }

    public Customer(String name, int vat, int phone_number, String email) {
        this.vat = vat;
        this.name = name;
        this.phone_number = phone_number;
        this.email = email;
        this.shopping_cart=new Shopping_Cart();
    }

    public Set<Billing_Address> getBilling_addresses() {
        return billing_addresses;
    }

    public Set<Delivering_Address> getDelivering_addresses() {
        return delivering_addresses;
    }

    public Shopping_Cart getShopping_cart() {
        return shopping_cart;
    }

    public void setBilling_addresses(Set<Billing_Address> billing_addresses) {
        this.billing_addresses = billing_addresses;
    }

    public void addBiling_adresses(Billing_Address billing_addresses) {
        this.billing_addresses.add(billing_addresses);
    }

    public void setDelivering_addresses(Set<Delivering_Address> delivering_addresses) {
        this.delivering_addresses = delivering_addresses;
    }

    public void addDelivering_adresses(Delivering_Address delivering_address) {
        this.delivering_addresses.add((delivering_address));
    }

    public void setValidation(Validation validation) {
        this.validation = validation;
    }

    public void setShopping_cart(Shopping_Cart shopping_cart) {
        this.shopping_cart = shopping_cart;
    }

    public Validation getValidation() {
        return validation;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

    public void setVat(int vat) {
        this.vat = vat;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public int getVat() {
        return vat;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Integer identity() {
        return null;
    }
}
