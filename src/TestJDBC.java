import java.sql.* ;

public class TestJDBC {

    public static void main( String[] args ) throws Exception {
//        Connection connection = null;
        try
            {
            Class.forName("org.postgresql.Driver");
            Connection cx = DriverManager.getConnection(
                    "jdbc:postgresql:demodb"
                    ,
                    "postgres"
                    ,
                    "admin");
            
//            String url = "postgresql://localhost:5432/postgres";
//            connection = DriverManager.getConnection(url,"postgres", "admin");
            Statement st = cx.createStatement();

//            ResultSet rs = st.executeQuery("SELECT * FROM Cars");
            ResultSet rs = st.executeQuery("SELECT * FROM personnes");
            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                System.out.println("Le numero " + id + " est " + nom + " " + prenom);
            }
            rs.close();
            st.close();
            cx.close();
            }
        catch (ClassNotFoundException e)
            {
                e.printStackTrace();
                System.exit(1);
            }
        catch (SQLException e)
            {
                e.printStackTrace();
                System.exit(2);
            }
    }

}