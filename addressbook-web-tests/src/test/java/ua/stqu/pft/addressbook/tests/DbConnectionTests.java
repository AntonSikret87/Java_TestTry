package ua.stqu.pft.addressbook.tests;

import org.testng.annotations.Test;
import ua.stqu.pft.addressbook.model.GroupData;
import ua.stqu.pft.addressbook.model.Groups;

import java.sql.*;

/**
 * Created by sikretSSD on 10.04.2016.
 */
public class DbConnectionTests {

    @Test
    public void testDbConnection(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook?user=root&password=");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select group_id,group_name,group_header,group_footer from group_list");
            Groups groups = new Groups();
            while (rs.next()){
                groups.add(new GroupData().withId(rs.getInt("group_id")).withName(rs.getString("group_name"))
                        .withHeader("group_header").withFooter("group_footer"));
            }
            rs.close();
            st.close();
            conn.close();
            System.out.println(groups);
        }catch (SQLException ex){
            System.out.println("SQLExeption: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("SQLExeption: " + ex.getErrorCode());
        }
    }
}
