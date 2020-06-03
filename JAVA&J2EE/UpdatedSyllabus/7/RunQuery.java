import java.sql.*;

class RunQuery {
    Connection conn;
    RunQuery(){
        try{
            Class.forName("com.mysql.jdbc.Driver"); 
            this.conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    void update(String query)
    {
        try{
          if (conn != null) 
            conn.createStatement().executeUpdate(query);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    String show()
    {
        try{
          if (conn != null){
            String ans=""; 
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from info;");
            while (rs.next())
                ans+=rs.getString("id")+" "+rs.getString("name")+" "+rs.getString("age")+" "+rs.getString("doa")+" "+rs.getString("coa")+" "+rs.getString("diag")+" "+rs.getString("treat")+"\n";
          return ans;
          }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return "";
    }
}