package com.qualapps.ka.data;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class ArtifactDataMapper implements RowMapper<ArtifactData> {

	public ArtifactData mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		return null;
	}
	
	public class ArtifactDataExtractor implements ResultSetExtractor<ArtifactData> {

		public ArtifactData extractData(ResultSet rs) throws SQLException, DataAccessException {
			ArtifactData arti = null;
			if (rs != null) {
				arti = new ArtifactData();
				arti.setArtId(rs.getLong("article_art_id"));
				arti.setArtifId(rs.getLong("artif_id"));
				arti.setArtifLoc(rs.getString("arti_loc"));
				arti.setArtifType(rs.getString("arti_type"));
				arti.setArtifDesc(rs.getString("arti_desc"));
				arti.setChngDate(rs.getDate("change_date"));
				arti.setChngType(rs.getString("change_type"));
				arti.setChngUser(rs.getString("change_user"));
			}
			return arti;
		}
		
	}

}
