package com.techelevator.dao;

import com.techelevator.model.Park;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcParkDao implements ParkDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcParkDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Park getPark(int parkId) {
        String sql = "SELECT * FROM park WHERE park_id = ?";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, parkId);

        if (rowSet.next()) {
            Park park = mapRowToPark(rowSet);
            return park;
        }

        return null;
    }

    @Override
    public List<Park> getParksByState(String stateAbbreviation) {
        List<Park> parkList = new ArrayList<>();

        String sql = "SELECT park.* FROM park_state \n" +
                "JOIN park ON park.park_id = park_state.park_id\n" +
                "WHERE state_abbreviation = ?";

        SqlRowSet parks = jdbcTemplate.queryForRowSet(sql, stateAbbreviation);
        while (parks.next()) {
            Park thePark = mapRowToPark(parks);
            parkList.add(thePark);
        }

        return parkList;

    }

    @Override
    public Park createPark(Park park) {
        String sql = "INSERT INTO park VALUES (DEFAULT, ?, ?, ?, ?) RETURNING park_id";

        Integer newId = jdbcTemplate.queryForObject(sql, Integer.class, park.getParkName(), park.getDateEstablished(),
                park.getArea(), park.getHasCamping());

        if (newId != null) {
            park.setParkId(newId);
        }

        return park;
    }

    @Override
    public void updatePark(Park park) {
        String sql = "UPDATE park SET park_name = ?, date_established = ?, area = ?, has_camping = ? WHERE\n" +
                "park_id = ?;";
        int count = jdbcTemplate.update(sql, park.getParkName(), park.getDateEstablished(), park.getArea(),
                park.getHasCamping(), park.getParkId());

        System.out.println(count);

    }

    @Override
    public void deletePark(int parkId) {

        /*
        DELETE FROM park_state WHERE park_id = 8;
DELETE FROM park WHERE park_id = 8;
         */

        String sql = "DELETE FROM park_state WHERE park_id = ?";
        jdbcTemplate.update(sql,parkId);

        sql = "DELETE FROM park WHERE park_id = ?";
        jdbcTemplate.update(sql,parkId);

    }

    @Override
    public void addParkToState(int parkId, String stateAbbreviation) {
        String sql = "INSERT INTO park_state VALUES (?, ?)";
        jdbcTemplate.update(sql, parkId, stateAbbreviation);
    }



    @Override
    public void removeParkFromState(int parkId, String stateAbbreviation) {

    }

    private Park mapRowToPark(SqlRowSet row) {
        Park newPark = new Park();
        newPark.setParkId(row.getInt("park_id"));
        newPark.setParkName(row.getString("park_name"));
        newPark.setHasCamping(row.getBoolean("has_camping"));
        newPark.setArea(row.getDouble("area"));
        newPark.setDateEstablished(row.getDate("date_established").toLocalDate());

        return newPark;
    }
}
