package acp.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import acp.entities.Category;

public class CategoriesRowMapper implements RowMapper<Category> {

	public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
		Category cat = new Category();

		cat.setId(rs.getInt("id"));
		cat.setName(rs.getString("name"));

		return cat;

	}
}
