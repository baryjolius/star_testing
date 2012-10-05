import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import oracle.jdbc.pool.OracleConnectionPoolDataSource;

import org.junit.BeforeClass;
import org.junit.Test;
import org.nc.MaklumatCalon.logic.MaklumatCalon;


public class test {
	@BeforeClass
    public static void setUpClass() throws Exception {
        // rcarver - setup the jndi context and the datasource
        try {
            // Create initial context
            System.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
            System.setProperty(Context.URL_PKG_PREFIXES, "org.apache.naming");            
            InitialContext ic = new InitialContext();

            ic.createSubcontext("java:");
            ic.createSubcontext("java:comp");
            ic.createSubcontext("java:comp/env");
            ic.createSubcontext("java:comp/env/jdbc");
           
            // Construct DataSource
            OracleConnectionPoolDataSource ds = new OracleConnectionPoolDataSource();
            ds.setURL("jdbc:oracle:thin:@//localhost:1521/orcl");
            ds.setUser("mpmdbtr");
            ds.setPassword("mpmdbtr");
            
            ic.bind("java:comp/env/jdbc/mpmDB", ds);
        } catch (NamingException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
	
	
	//@Test
	public void testNamaNegeri() throws SQLException {
		MaklumatCalon mkltCalon = new MaklumatCalon();
		
		System.out.println("size :"+mkltCalon.namaNegeri("S"));
	}
	
	//@Test
	public void testSenaraiCalon() throws SQLException {
		MaklumatCalon mkltCalon = new MaklumatCalon();
		String nama = "";
		System.out.println("sql :"+mkltCalon.senaraiCalonSekolah(nama).size());
		
		for(String[] item:mkltCalon.senaraiCalonSekolah(nama)){
			System.out.println("item 0 :"+item[0]+", item1 :"+item[1]);
		}
	}
	
	@Test
	public void testMaklumatCalon() throws SQLException {
		MaklumatCalon mkltCalon = new MaklumatCalon();
		String[] calonSek = mkltCalon.maklumatCalonSekolah("1");
		System.out.println("item 0 :"+calonSek[0]+", item1 :"+calonSek[1]);
	}
	
	@Test
	public void testSenaraiNegeri() throws SQLException {
		MaklumatCalon mkltCalon = new MaklumatCalon();
		System.out.println("item 0 :"+mkltCalon.senaraiNegeri());
	}
}
