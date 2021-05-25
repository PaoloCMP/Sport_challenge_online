package dao;

import java.sql.*;

public class ScegliLivelloDao {

    


    public boolean setLivello(int utenteId, String sport, String livello) throws SQLException {
    	
    	Connection connection;
    	Statement statement=null;
    	Statement stm=null;
    	ResultSet rsSLD=null;
    	boolean risultato=false;
    	try {
         connection = DBConnectionSingleton.getConnectionInstance();
         statement = connection.createStatement();
         stm = connection.createStatement();
        String q = "SELECT MAX(ID) AS ID FROM campo";
         rsSLD = stm.executeQuery(q);
        int idSLD = 0;
        while(rsSLD.next()){
            if (rsSLD.getString("ID")==null)
                idSLD = 0;
            else idSLD = rsSLD.getInt("ID")+1;
        }

        String query = String.format("INSERT INTO user_sport (ID, USER, SPORT, LIVELLO, PREFERITO) VALUES(%s, %s, '%s', '%s', 0) ON DUPLICATE KEY UPDATE LIVELLO='%s'",
                idSLD, utenteId, sport, livello, livello);

        if (statement.execute(query)== true) {
        	risultato=true;
        }
        
        }
    	catch (Exception e) {
			// TODO: handle exception
		}
    	finally {
    		try { if(rsSLD!=null) rsSLD.close(); } catch (Exception e) { /* Ignored */ }
    	     try { if (statement!=null) statement.close(); } catch (Exception e) { /* Ignored */ }
    	     try { if (stm!=null) stm.close(); } catch (Exception e) { /* Ignored */ }

		}
        return risultato;
    }
}
