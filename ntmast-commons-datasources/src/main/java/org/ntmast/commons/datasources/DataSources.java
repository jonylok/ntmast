package org.ntmast.commons.datasources;

import java.sql.Connection;

import javax.sql.DataSource;

/**
 * 
 * @author lenovo
 * 
 */
public class DataSources {

	private DataSource dataSource;
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public Connection getDataSource() {
		Connection connection=null ;
		try {
			 connection = dataSource.getConnection();
			if (connection != null)
				System.out.println(" test ok! ");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}
