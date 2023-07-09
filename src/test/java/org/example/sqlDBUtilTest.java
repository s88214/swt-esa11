package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;



import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class sqlDBUtilTest {

    static String selectString0 = "select\n" +
            "    count(*) as count\n" +
            "from USERS\n" +
            "inner join V_USERSALTERSGRUPPE on V_USERSALTERSGRUPPE.USERID = users.USERID\n" +
            "inner join QUERYDATA_IPOD on ANONID = users.USERID\n" +
            "where ALTERSGRUPPE = '90+'\n" +
            "group by ALTERSGRUPPE\n" +
            "order by count desc\n";


    String selectString1 = "select\n" +
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

    @Test
    void executeQueryTest0() {
        sqlDBUtil connection = mock(sqlDBUtil.class);
        when(connection.executeQueryReturnCount(selectString0)).thenReturn(0);

        assertEquals(0, connection.executeQueryReturnCount(selectString0));
    }

    @Test
    void executeQueryTest1() {
        sqlDBUtil connection = mock(sqlDBUtil.class);
        when(connection.executeQueryReturnCount(selectString1)).thenReturn(1);

        assertEquals(1, connection.executeQueryReturnCount(selectString1));
    }

    @Test
    void executeQueryTest7() {
        sqlDBUtil connection = mock(sqlDBUtil.class);
        when(connection.executeQueryReturnCount(selectString7)).thenReturn(7);

        assertEquals(7, connection.executeQueryReturnCount(selectString7));
    }

}