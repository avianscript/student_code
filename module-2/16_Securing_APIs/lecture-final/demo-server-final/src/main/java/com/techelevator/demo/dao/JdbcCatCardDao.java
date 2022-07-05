package com.techelevator.demo.dao;

import com.techelevator.demo.model.CatCard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCatCardDao implements CatCardDao {

	private JdbcTemplate jdbcTemplate;
	private Logger log = LoggerFactory.getLogger(getClass());

	public JdbcCatCardDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<CatCard> list() {
		List<CatCard> catCards = new ArrayList<>();
		String sql = "SELECT id, img_url, fact, caption FROM catcards ";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while(results.next()) {
			CatCard card = mapRowToCard(results);
			catCards.add(card);
		}
		return catCards;
	}
	
	private CatCard mapRowToCard(SqlRowSet rs) {
		CatCard cc = new CatCard();
		cc.setCatCardId(rs.getLong("id"));
		cc.setCatFact(rs.getString("fact"));
		cc.setImgUrl(rs.getString("img_url"));
		cc.setCaption(rs.getString("caption"));
		return cc;
	};

}
