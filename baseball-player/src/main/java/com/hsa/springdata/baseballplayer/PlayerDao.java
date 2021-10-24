package com.hsa.springdata.baseballplayer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PlayerDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Player> getAllPlayers(){
		String sql = "SELECT * FROM PLAYER;";
		
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Player>(Player.class));
	}
	
	public List<Player> getPlayerById(int id) {
		String sql = "SELECT * FROM PLAYER WHERE ID= ?";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Player>(Player.class), new Object[] {id});
	}
	
	public int insertPlayer(Player player) {
		String sql = "INSERT INTO PLAYER (ID, Name, Nationality, Birth_date, Titles)" + " VALUES (?,?,?,?,?)";
		return jdbcTemplate.update(sql,new Object[] {player.getId(), player.getName(), player.getNationality(), player.getBirthDate(), player.getTitles()});
	}

}
