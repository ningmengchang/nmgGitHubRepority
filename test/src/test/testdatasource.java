package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.junit.Test;


public class testdatasource {
	public Connection getconn(String jndiName) {  
	    Connection conn = null;  
	    try {  
	          
	        // weblogic 环境下使用         
	        Hashtable ht = new Hashtable();  
	        ht.put(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory");  
	        ht.put(Context.PROVIDER_URL, "t3://http://10.235.110.139:9080");  
/*	        ht.put(Context.SECURITY_PRINCIPAL, "WEBRESVER1212");//用户名  
	        ht.put(Context.SECURITY_CREDENTIALS, "WEBRESVER1212");//密码   
*/	        
	        Context ctx;  
	        ctx = new InitialContext(ht);  
	        String RESMASTER_DATASOURCE_JDNI =
			        "jdbc/oracle/ResTxDataSource";
	        DataSource source = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle/ResTxDataSource");  
	        Connection connection = source.getConnection();  
	        if (connection != null) {  
	            conn = connection;  
	        }  
	    } catch (NamingException e) {  
	       e.printStackTrace();
	    } catch (SQLException e) {  
	        // logger.error(e);  
	       e.printStackTrace();
	    }  
	    return conn;  
	}  
	public String getEmosType(String prodInstId) throws SQLException {
		// TODO Auto-generated method stub
		String sql=" select t1.order_code from gom_order t1 where t1.order_id in(select t.order_id from srv_instance t where t.prod_inst_id=? and t.route_type='1704' and t.route_id is not null and rownum=1) ";
	    String orderCode="";
	    String emosType="";
		Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            conn = getconn("");
            pstmt = conn.prepareStatement(sql.toString());
            pstmt.setString(1, prodInstId);
            rs = pstmt.executeQuery();
            if(rs.next()){
            	orderCode=rs.getString("order_code");
            }
        } 
        catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            rs.close();
            pstmt.close();
            conn.close();
        }
        if(orderCode!=null&&orderCode.contains("-")){
        	emosType=orderCode.split("-")[1];
        }
        return emosType;
	}
	@Test
 public void test() {
	
	 try {
		String emosType=getEmosType("newProdIdRefreshId13020118360663652607820");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 }
}
