package com.techelevator.dao;

import com.techelevator.model.Park;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

public class JdbcParkDaoTests extends BaseDaoTests {

    private static final Park PARK_1 =
            new Park(1, "Park 1", LocalDate.parse("1800-01-02"), 100, true);
    private static final Park PARK_2 =
            new Park(2, "Park 2", LocalDate.parse("1900-12-31"), 200, false);
    private static final Park PARK_3 =
            new Park(3, "Park 3", LocalDate.parse("2000-06-15"), 300, false);

    private JdbcParkDao sut;

    @Before
    public void setup() {
        sut = new JdbcParkDao(dataSource);
    }

    @Test
    public void getPark_returns_correct_park_for_id() {
        Park actual = sut.getPark(2);
        Assert.assertEquals(PARK_2, actual);
    }

    @Test
    public void getPark_returns_null_when_id_not_found() {
        Park actual = sut.getPark(999);
        Assert.assertNull(actual);
    }

    @Test
    public void getParksByState_returns_all_parks_for_state() {
        List<Park> actual = sut.getParksByState("AA");
        Assert.assertTrue(actual.size() == 2);
        Assert.assertEquals(PARK_1, actual.get(0));
        Assert.assertEquals(PARK_3, actual.get(1));
    }

    @Test
    public void getParksByState_returns_empty_list_for_abbreviation_not_in_db() {
        List<Park> actual = sut.getParksByState("XX");
        Assert.assertEquals(0,actual.size());
    }

    @Test
    public void createPark_returns_park_with_id_and_expected_values() {
        Park newPark = new Park();
        newPark.setParkName("Test 1");
        newPark.setDateEstablished(LocalDate.now());
        newPark.setArea(25.5);
        newPark.setHasCamping(true);

        Park savedPark = sut.createPark(newPark);
        Assert.assertNotEquals(0, savedPark.getParkId());

        newPark.setParkId(savedPark.getParkId());
        Assert.assertEquals(newPark, savedPark);
    }

    @Test
    public void created_park_has_expected_values_when_retrieved() {
        Park newPark = new Park();
        newPark.setParkName("Test 1");
        newPark.setDateEstablished(LocalDate.now());
        newPark.setArea(25.5);
        newPark.setHasCamping(true);

        Park savedPark = sut.createPark(newPark);

        Park retrievedPark = sut.getPark(savedPark.getParkId());
        Assert.assertEquals(savedPark, retrievedPark);
    }

    @Test
    public void updated_park_has_expected_values_when_retrieved() {
        Park parkToUpdate = sut.getPark(2);
        parkToUpdate.setHasCamping(true);

        sut.updatePark(parkToUpdate);

        Park retrievedPark = sut.getPark(2);
        Assert.assertEquals(parkToUpdate, retrievedPark);

    }

    @Test
    public void deleted_park_cant_be_retrieved() {
        sut.deletePark(3);

        Park retrievePark = sut.getPark(3);
        Assert.assertNull(retrievePark);
    }

    @Test
    public void park_added_to_state_is_in_list_of_parks_by_state() {
        sut.addParkToState(2, "AA");

        List<Park> actual = sut.getParksByState("AA");
        Assert.assertEquals(3, actual.size());
        Assert.assertTrue(actual.contains(PARK_2));
    }

    @Test
    public void park_removed_from_state_is_not_in_list_of_parks_by_state() {
        sut.removeParkFromState(2, "BB");

        List<Park> actual = sut.getParksByState("BB");
        Assert.assertEquals(0, actual.size());
        Assert.assertFalse(actual.contains(PARK_2));
    }

    private void assertParksMatch(Park expected, Park actual) {
        Assert.assertEquals(expected.getParkId(), actual.getParkId());
        Assert.assertEquals(expected.getParkName(), actual.getParkName());
        Assert.assertEquals(expected.getDateEstablished(), actual.getDateEstablished());
        Assert.assertEquals(expected.getArea(), actual.getArea(), 0.1);
        Assert.assertEquals(expected.getHasCamping(), actual.getHasCamping());
    }

}
