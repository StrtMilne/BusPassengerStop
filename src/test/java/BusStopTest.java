import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BusStopTest {

    private Bus bus;
    private Person person;
    private Person person2;
    private BusStop busStop;

    @Before
    public void before() {
        bus = new Bus("Edinburgh", 100);
        person = new Person();
        person2 = new Person();
        busStop = new BusStop("Princes St");
    }

    @Test
    public void hasName() {
        assertEquals("Princes St", this.busStop.getName());
    }

    @Test
    public void queueStartsEmpty() {
        assertEquals(0, busStop.queueCount());
    }

    @Test
    public void passengerCanJoinQueue() {
        busStop.addPerson(person);
        assertEquals(1, busStop.queueCount());
    }

    @Test
    public void removePassengerFromQueue() {
        busStop.addPerson(person);
        busStop.addPerson(person2);
        busStop.removePerson(person);
        assertEquals(1, busStop.queueCount());
    }
}
