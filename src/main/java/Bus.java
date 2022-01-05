import java.util.ArrayList;

public class Bus {

    private ArrayList<Person> passengers;
    private String destination;
    private int capacity;

    public Bus(String destination, int capacity) {
        this.passengers = new ArrayList<>();
        this.destination = destination;
        this.capacity = capacity;
    }

    public int passengerCount() {
        return this.passengers.size();
    }

    public String getDestination() {
        return this.destination;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void addPassenger(Person person) {
        if (passengerCount() < getCapacity()) {
            this.passengers.add(person);
        }
    }

    public void removePassenger(Person person) {
        
        if (passengerCount() > 0) {
            this.passengers.remove(person);
        }
    }

    public void pickUpFromStop(Person person, BusStop busStop) {
        this.addPassenger(person);
        busStop.removePerson(person);
    }
}
