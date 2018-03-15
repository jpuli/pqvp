package com.qualapps.ka.data;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class ArticleDataMapper implements RowMapper<ArticleData> {

	public ArticleData mapRow(ResultSet rs, int row) throws SQLException {
		ArticleDataExtractor ext = new ArticleDataExtractor();
		return ext.extractData(rs);
	}
	
	public class ArticleDataExtractor implements ResultSetExtractor<ArticleData> {

		public ArticleData extractData(ResultSet rs) throws SQLException, DataAccessException {
			ArticleData art = null;
			if (rs != null) {
				art = new ArticleData();
				art.setArtContent(rs.getString("art_content"));
				art.setArtId(rs.getLong("art_id"));
				art.setArtStatus(rs.getString("art_status"));
				art.setArtTile(rs.getString("art_title"));
				art.setArtViews(rs.getLong("art_views"));
				art.setArtRating(rs.getLong("art_rating"));
				art.setArtCreator(rs.getString("art_creator"));
				art.setArtCreateTime(rs.getDate("art_create_time"));
				art.setArtTags(rs.getString("art_tags"));
				art.setArtAccess(rs.getString("art_access"));
				art.setChngDate(rs.getDate("change_date"));
				art.setChngType(rs.getString("change_type"));
				art.setChngUser(rs.getString("change_user"));
			}
			return art;
		}
		
	}

}
