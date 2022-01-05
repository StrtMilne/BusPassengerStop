import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BusTest {

    private Bus bus;
    private Person person;
    private BusStop busStop;

    @Before
    public void before() {
        bus = new Bus("Edinburgh", 100);
        person = new Person();
        busStop = new BusStop("Princes St");
        busStop.addPerson(person);
    }

    @Test
    public void startsEmpty() {
        assertEquals(0, bus.passengerCount());
    }

    @Test
    public void hasDestination() {
        assertEquals("Edinburgh", bus.getDestination());
    }

    @Test
    public void hasCapacity() {
        assertEquals(100, bus.getCapacity());
    }

    @Test
    public void canAddPassengerIfNotCapacity() {
        bus.addPassenger(person);
        assertEquals(1, bus.passengerCount());
    }

    @Test
    public void cantAddPassengerOverCapacity() {
        Bus bus = new Bus("Edinburgh", 2);
        bus.addPassenger(person);
        bus.addPassenger(person);
        bus.addPassenger(person);
        assertEquals(2, bus.passengerCount());
    }

    @Test
    public void canRemovePassenger() {
        bus.addPassenger(person);
        bus.removePassenger(person);
        assertEquals(0, bus.passengerCount());
    }

    @Test
    public void pickupPassengerAddsToBus() {
        bus.pickUpFromStop(person, busStop);
        assertEquals(1, bus.passengerCount());
        assertEquals(0, busStop.queueCount());
    }

}
