package eapli.base.AGVmanagement.AGV.domain;


import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.Immutable;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.*;

import java.util.*;

@Entity
public class Status implements ValueObject, AggregateRoot<Integer> {
    @GeneratedValue
    @Id
    private int id;
    private int battery_left;
    @Column
    @ElementCollection(targetClass=String.class,fetch = FetchType.EAGER)
    private List<String> task;
    @OneToOne(fetch = FetchType.EAGER)
    private AGV AGV;

    /**
     * Returns the primary <b>business</b> id of the entity.
     *
     * <p>
     * This method is marked as a getter for Jackson serialization
     *
     * @return the primary <b>business</b> id of the entity
     */
    @Override
    public Integer identity() {
        return null;
    }

    public enum Availability {
        AVAILABLE,
        WORKING
    }

    private Availability availability;

    public Availability getAvailability() {
        return availability;

    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }

    protected Status() {
    }

    public Status(int battery_left, String task) {
        this.task=new ArrayList<>();
        this.battery_left = battery_left;
        addTask(task);
        if (this.task.size() > 1) {
            setAvailability(Availability.WORKING);
        } else {
            setAvailability(Availability.AVAILABLE);
        }
    }

    public List<String> gettasks() {
        return this.task;
    }

    public int numberoftasks() {
        return gettasks().size();
    }

    public boolean hastasks() {
        return !this.task.isEmpty();
    }

    public void removetask(String orderid) {
        this.task.removeIf(order -> order.equals(orderid));
    }

    public boolean hasOrder(String orderid) {
        for (String order : this.task) {
            if (order.equals(orderid)) {
                return true;
            }
        }
        return false;
    }

    public int getBattery_left() {
        return battery_left;
    }

    public void addTask(String task) {
        this.task.add(task);
        this.availability = Availability.WORKING;
    }

    private void setTask(String task) {
    }

    private void setBattery_left(int time_left) {
        this.battery_left = time_left;
    }

    @Override
    public String toString() {
        return "Task: " + task + "\nTime Left: " + battery_left;
    }

    public String availabilityToString() {
        if (this.availability != Availability.AVAILABLE && this.availability != Availability.WORKING) {
            this.availability = Availability.AVAILABLE;
            return "AVAILABLE";
        }
        if (this.availability == Availability.AVAILABLE) {
            return "AVAILABLE";
        }
        if (this.availability == Availability.WORKING) {
            return "WORKING";
        }
        return "AVAILABLE";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Status status = (Status) o;
        return Objects.equals(battery_left, status.battery_left) && Objects.equals(task, status.task);
    }


    @Override
    public int hashCode() {
        return Objects.hash(battery_left, task);
    }

    /**
     * Entities are compared by identity only, so equals() must only compare
     * identities. In some situations however we might want to compare the
     * contents of the object by value.
     *
     * @param other the other object to compare
     * @return {@code true} if this domain entity have the "same content" as the
     * {@code other}
     */
    @Override
    public boolean sameAs(Object other) {
        return false;
    }
}
