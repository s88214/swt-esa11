package org.example;

import java.sql.ResultSet;
import java.sql.SQLException;

public class sqlSelect {

    static String selectString0 = "select\n" +
            "    count(*) as count\n" +
            "from USERS\n" +
            "inner join V_USERSALTERSGRUPPE on V_USERSALTERSGRUPPE.USERID = users.USERID\n" +
            "inner join QUERYDATA_IPOD on ANONID = users.USERID\n" +
            "where ALTERSGRUPPE = '90+'\n" +
            "group by ALTERSGRUPPE\n" +
            "order by count desc\n";

    static String selectString1 = "select\n" +
            "    count(*) as count\n" +
            "from USERS\n" +
            "inner join V_USERSALTERSGRUPPE on V_USERSALTERSGRUPPE.USERID = users.USERID\n" +
            "inner join QUERYDATA_IPOD on ANONID = users.USERID\n" +
            "where ALTERSGRUPPE = '60+'\n" +
            "group by ALTERSGRUPPE\n" +
            "order by count desc\n";

    static String selectString7 = "select\n" +
            "    count(*) as count\n" +
            "from USERS\n" +
            "inner join V_USERSALTERSGRUPPE on V_USERSALTERSGRUPPE.USERID = users.USERID\n" +
            "inner join QUERYDATA_IPOD on ANONID = users.USERID\n" +
            "group by ALTERSGRUPPE\n" +
            "order by count desc\n";

    public static void main(String[] args) {

        sqlDBUtil connection = new sqlDBUtil("jdbc:oracle:thin:@localhost:1521:rispdb1", "s88214", "dassdFFS731");
        //ResultSet results = connection.executeQuery(selectString);
        int size = connection.executeQueryReturnCount(selectString1);
        int size7 = connection.executeQueryReturnCount(selectString7);
        int size0 = connection.executeQueryReturnCount(selectString0);
/*
        try {
            while (results.next()) {
                System.out.println(results.getString(1));  // 1 steht für die erste Spalte in der Ergebnistabelle
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

 */
    }
}
