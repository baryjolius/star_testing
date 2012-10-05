package cjf.daab.ext.util;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;

import cjf.daab.ConnectionManager;
import cjf.daab.DatabaseFactory;
import cjf.daab.EntityActivity;
import cjf.daab.ext.util.CoralLiferayConnectionStringProps;

/**
 * 
 * @author Ridzuan Mohamad
 * @since 25-April, 2012
 */
public class EntityImplementer extends EntityActivity{
	private final static String LIFERAY_UTIL_PREFSPROPS = "com.liferay.portal.kernel.util.PrefsPropsUtil";
	private final static String JNDI_DEFAULT_NAME = "jdbc/mpmDB";
	private final static String JDBC_DEFAULT_URL = "jdbc:oracle:thin:@//localhost:1521/orcl";
	private final static String JDBC_DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	private final static String USERNAME = "mpmdbtr";
	private final static String PASSWORD = "mpmdbtr";
	
	public Connection getConnection() throws SQLException{
		DatabaseFactory databaseFactory = getDatabaseFactory();		
		Connection connection = ConnectionManager.getConnection(databaseFactory);
		return connection;
	}
	
	private DatabaseFactory getDatabaseFactory(){
		DatabaseFactory databaseFactory = new DatabaseFactory();
		
		//// this code will used defined JNDI as database connection
		databaseFactory = getDatabaseFactoryJNDI();
		databaseFactory.setPrefixRequired(true);
		
		//// this code will used defined JDBC as database connection
		//databaseFactory = getDatabaseFactoryJDBC();
		
		return databaseFactory;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private DatabaseFactory getDatabaseFactoryJNDI(){
		DatabaseFactory dbf = new DatabaseFactory();
		try{
			//try to load com.liferay.portal.kernel.util.PrefsPropsUtil - exist
			Class api = Class.forName(LIFERAY_UTIL_PREFSPROPS);
			Method method = api.getDeclaredMethod("getString", String.class);
			String jndiName = (String) method.invoke(null, CoralLiferayConnectionStringProps.JDBC_DEFAULT_JNDI_NAME);
			dbf.setDatasourceContext(jndiName);
			
		} catch (ClassNotFoundException e1) {
			log("[ConnectionManager:getConnection:ClassNotFoundException] - Liferay kernel API not exist");
			dbf.setDatasourceContext(JNDI_DEFAULT_NAME);
		} catch (Exception e) {
			log("[EntityImplementer:getDatabaseFactoryJDBC:Exception] - unable to load JNDI setting from Liferay: ", e);
			dbf.setDatasourceContext(JNDI_DEFAULT_NAME);
		}
		
		return dbf;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private DatabaseFactory getDatabaseFactoryJDBC(){
		DatabaseFactory dbf = new DatabaseFactory();
		try{
			//try to load com.liferay.portal.kernel.util.PrefsPropsUtil - exist
			Class api = Class.forName(LIFERAY_UTIL_PREFSPROPS);
			Method method = api.getDeclaredMethod("getString", String.class);
			
			String connectionString = (String) method.invoke(null, CoralLiferayConnectionStringProps.JDBC_DEFAULT_URL);
			String driverName = (String) method.invoke(null, CoralLiferayConnectionStringProps.JDBC_DEFAULT_DRIVER_CLASSNAME);
			String username = (String) method.invoke(null, CoralLiferayConnectionStringProps.JDBC_DEFAULT_USERNAME);
			String password = (String) method.invoke(null, CoralLiferayConnectionStringProps.JDBC_DEFAULT_PASSWORD);
			
			dbf.setConnectionString(connectionString);
			dbf.setDriverClassName(driverName);
			dbf.setUsername(username);
			dbf.setPassword(password);
			
		} catch (ClassNotFoundException e1) {
			log("[ConnectionManager:getConnection:ClassNotFoundException] - Liferay kernel API not exist");
			dbf.setConnectionString(JDBC_DEFAULT_URL);
			dbf.setDriverClassName(JDBC_DRIVER_NAME);
			dbf.setUsername(USERNAME);
			dbf.setPassword(PASSWORD);
			
		} catch (Exception e) {
			log("[EntityImplementer:getDatabaseFactoryJDBC:Exception] - unable to load JNDI setting from Liferay: ", e);
			dbf.setConnectionString(JDBC_DEFAULT_URL);
			dbf.setDriverClassName(JDBC_DRIVER_NAME);
			dbf.setUsername(USERNAME);
			dbf.setPassword(PASSWORD);
		}
		
		return dbf;
	}
}
