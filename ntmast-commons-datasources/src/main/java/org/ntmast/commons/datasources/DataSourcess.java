package org.ntmast.commons.datasources;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

public class DataSourcess{
	private DataSource dataSource;

	/**
	 * 获得Spring DataSources
	 * @return
	 */
	public DataSource getDataSource(){
		BeanDefinitionRegistry reg = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(reg);
		reader.loadBeanDefinitions(new ClassPathResource("spring.xml"));
		BeanFactory bf = (BeanFactory) reg;		
		DataSource dataBean = (DataSource) bf.getBean("myDataSource");
		return dataBean;
	}
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Connection connection=null ;
		ResultSet rs = null;
		Statement stmt = null;
		 DataSourcess  dst = new DataSourcess();
		try {
			 connection = dst.getDataSource().getConnection();
			if (connection != null)
				System.out.println(" test ok! ");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			stmt = connection.createStatement();
		} catch (SQLException ex) {
			System.err.println("createStatement();" + ex.getMessage());
		}
		try {
			rs = stmt.executeQuery("select * from RU_SQL");
		} catch (SQLException ex) {
			System.err.println("stmt.excuteQuery();" + ex.getMessage());
		}
	}

}
