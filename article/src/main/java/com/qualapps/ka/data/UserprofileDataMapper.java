package com.qualapps.ka.data;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class UserprofileDataMapper implements RowMapper<UserProfileData> {

	public UserProfileData mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserprofileDataExtractor ext = new UserprofileDataExtractor();
		return ext.extractData(rs);
	}
	
	public class UserprofileDataExtractor implements ResultSetExtractor<UserProfileData> {

		public UserProfileData extractData(ResultSet rs) throws SQLException, DataAccessException {
			UserProfileData usr = null;
			if (rs != null) {
				usr = new UserProfileData();
				usr.setUsrName(rs.getString("usr_name"));
				usr.setUsrProfileId(rs.getLong("usr_profile_id"));
				usr.setUsrPwd(rs.getString("usr_pwd"));
				usr.setUsrRole(rs.getString("usr_role"));
			}
			return usr;
		}
		
	}

}
