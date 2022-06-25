package com.techelevator.projects.dao;

import com.techelevator.projects.model.Timesheet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcTimesheetDaoTests extends BaseDaoTests {

    private static final Timesheet TIMESHEET_1 = new Timesheet(1, 1, 1,
            LocalDate.parse("2021-01-01"), 1.0, true, "Timesheet 1");
    private static final Timesheet TIMESHEET_2 = new Timesheet(2, 1, 1,
            LocalDate.parse("2021-01-02"), 1.5, true, "Timesheet 2");
    private static final Timesheet TIMESHEET_3 = new Timesheet(3, 2, 1,
            LocalDate.parse("2021-01-01"), 0.25, true, "Timesheet 3");
    private static final Timesheet TIMESHEET_4 = new Timesheet(4, 2, 2,
            LocalDate.parse("2021-02-01"), 2.0, false, "Timesheet 4");
    
    private JdbcTimesheetDao sut;


    @Before
    public void setup() {
        sut = new JdbcTimesheetDao(dataSource);
    }

    @Test
    public void getTimesheet_returns_correct_timesheet_for_id() {
        Timesheet timesheet = sut.getTimesheet(1);
        assertTimesheetsMatch(TIMESHEET_1, timesheet);

        timesheet = sut.getTimesheet(2);
        assertTimesheetsMatch(TIMESHEET_2, timesheet);

        timesheet = sut.getTimesheet(3);
        assertTimesheetsMatch(TIMESHEET_3, timesheet);

        timesheet = sut.getTimesheet(4);
        assertTimesheetsMatch(TIMESHEET_4, timesheet);
    }

    @Test
    public void getTimesheet_returns_null_when_id_not_found() {

        Timesheet timesheet = sut.getTimesheet(5);
        Assert.assertNull(timesheet);

        timesheet = sut.getTimesheet(0);
        Assert.assertNull(timesheet);
    }
    @Test
    public void getTimesheetsByEmployeeId_returns_list_of_all_timesheets_for_employee() {
        List<Timesheet> actual = sut.getTimesheetsByEmployeeId(1);

        Assert.assertTrue(actual.size() == 2);
        assertTimesheetsMatch(TIMESHEET_1, actual.get(0));
        assertTimesheetsMatch(TIMESHEET_2, actual.get(1));
    }


    @Test
    public void getTimesheetsByProjectId_returns_list_of_all_timesheets_for_project() {
        List<Timesheet> actual = sut.getTimesheetsByProjectId(1);
        Assert.assertTrue(actual.size() == 3);
        assertTimesheetsMatch(TIMESHEET_1, actual.get(0));
        assertTimesheetsMatch(TIMESHEET_2, actual.get(1));
        assertTimesheetsMatch(TIMESHEET_3, actual.get(2));
    }

    @Test
    public void createTimesheet_returns_timesheet_with_id_and_expected_values() {
        Timesheet newTimesheet = new Timesheet();
        newTimesheet.setEmployeeId(1);
        newTimesheet.setBillable(true);
        newTimesheet.setDateWorked(LocalDate.now());
        newTimesheet.setDescription("New Timesheet");
        newTimesheet.setHoursWorked(1.5);
        newTimesheet.setProjectId(1);

        Timesheet savedTimesheet = sut.createTimesheet(newTimesheet);
        Assert.assertNotEquals(0, savedTimesheet.getTimesheetId());

        newTimesheet.setTimesheetId(savedTimesheet.getTimesheetId());
        Assert.assertEquals(newTimesheet.getTimesheetId(), savedTimesheet.getTimesheetId());

    }

    @Test
    public void created_timesheet_has_expected_values_when_retrieved() {
        Timesheet newTimesheet = new Timesheet();
        newTimesheet.setEmployeeId(1);
        newTimesheet.setBillable(true);
        newTimesheet.setDateWorked(LocalDate.now());
        newTimesheet.setDescription("New Timesheet");
        newTimesheet.setHoursWorked(1.5);
        newTimesheet.setProjectId(1);

        Timesheet savedSheet = sut.createTimesheet(newTimesheet);

        Timesheet retrievedSheet = sut.getTimesheet(savedSheet.getTimesheetId());
        assertTimesheetsMatch(savedSheet, retrievedSheet);
    }

    @Test
    public void updated_timesheet_has_expected_values_when_retrieved() {
        Timesheet sheetToUpdate = sut.getTimesheet(2);

        sheetToUpdate.setEmployeeId(2);
        sheetToUpdate.setHoursWorked(2.5);
        sheetToUpdate.setBillable(false);
        sheetToUpdate.setProjectId(1);
        sheetToUpdate.setDateWorked(LocalDate.now());

        sut.updateTimesheet(sheetToUpdate);

        Timesheet retrievedSheet = sut.getTimesheet(2);
        assertTimesheetsMatch(sheetToUpdate, retrievedSheet);
    }

    @Test
    public void deleted_timesheet_cant_be_retrieved() {
        sut.deleteTimesheet(3);

        Timesheet retrievedSheet = sut.getTimesheet(3);
        Assert.assertNull(retrievedSheet);


    }

    @Test
    public void getBillableHours_returns_correct_total() {
        double billableHours = sut.getBillableHours(2, 1);

       Assert.assertEquals(billableHours, TIMESHEET_3.getHoursWorked(), 0);


    }

    private void assertTimesheetsMatch(Timesheet expected, Timesheet actual) {
        Assert.assertEquals(expected.getTimesheetId(), actual.getTimesheetId());
        Assert.assertEquals(expected.getEmployeeId(), actual.getEmployeeId());
        Assert.assertEquals(expected.getProjectId(), actual.getProjectId());
        Assert.assertEquals(expected.getDateWorked(), actual.getDateWorked());
        Assert.assertEquals(expected.getHoursWorked(), actual.getHoursWorked(), 0.001);
        Assert.assertEquals(expected.isBillable(), actual.isBillable());
        Assert.assertEquals(expected.getDescription(), actual.getDescription());
    }

}
