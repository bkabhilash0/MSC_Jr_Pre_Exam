import java.sql.*;

public class DB {
    public static void main(String[] args) {
        try{
//            Class.forName("com.mysql.jdbc.Driver");
            Connection conn= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/rcss_dev","bkabhilash","Abhilash@9837");
            System.out.println("Connection Success");

            conn.setAutoCommit(false);

            Statement st = conn.createStatement();

            PreparedStatement pst = conn.prepareStatement("SELECT id,name from college");
            ResultSet rs = pst.executeQuery();

            ResultSetMetaData meta = rs.getMetaData();

//            System.out.println(meta.getColumnCount());
//            System.out.println(meta.getColumnName(1));
//            System.out.println(meta.getColumnName(2));
//            System.out.println(meta.getColumnTypeName(2));
//            System.out.println(meta.getTableName(1));
//            System.out.println(meta.isNullable(2));

            while(rs.next()){
                System.out.println(rs.getInt(1) + " - " + rs.getString(2) );
            }

            PreparedStatement insert = conn.prepareStatement("INSERT INTO college(name,location,updated_at) VALUES(?,?,'2024-03-03 13:26:26.213') ");
            insert.setString(1,"Prepare Statement");
            insert.setString(2,"Parametrized");
//
            insert.execute();
            System.out.println("Success");
//            conn.commit();
            conn.rollback();


//            PreparedStatement update = conn.prepareStatement("UPDATE college set name=? where id=?");
//            update.setString(1,"Updated");
//            update.setInt(2,12);
//
//            PreparedStatement delete = conn.prepareStatement("DELETE FROM college where id=?");
//            delete.setInt(1,12);
//
//            insert.execute();
//            update.executeUpdate();
//            delete.execute();
//            System.out.println("Delete Successful");

            conn.close();

        }catch(SQLException sq){
            System.out.println("SQL Exception");
            System.out.println(sq.getMessage());
            System.out.println(sq.getErrorCode());
            System.out.println(sq.getSQLState());
        } catch(Exception e){
            System.out.println(e);
            System.out.println("Error Connecting");
        }
    }
}
