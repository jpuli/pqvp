package com.qualapps.ka.data;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class CategoryDataMapper implements RowMapper<CategoryData> {

	public CategoryData mapRow(ResultSet rs, int rowNum) throws SQLException {
		CategoryDataExtractor ext = new CategoryDataExtractor();
		return ext.extractData(rs);
	}
	
	public class CategoryDataExtractor implements ResultSetExtractor<CategoryData> {

		public CategoryData extractData(ResultSet rs) throws SQLException, DataAccessException {
			CategoryData cat = null; 
			if (rs != null) {
				cat = new CategoryData();
				cat.setCatDescr(rs.getString("cat_descr"));
				cat.setCatId(rs.getLong("cat_id"));
				cat.setCatName(rs.getString("cat_name"));
				cat.setChngDate(rs.getDate("change_date"));
				cat.setChngType(rs.getString("change_type"));
				cat.setChngUser(rs.getString("change_user"));
			}
			return cat;
		}
		
	}

}
