package com.example.demo.h2;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Functions {
    public static int field(String value, String... values) {
        for (int i = 0; i < values.length; i++) {
            if (values[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    public static void createFieldFunction(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute("CREATE ALIAS IF NOT EXISTS FIELD FOR \"com.example.demo.h2.Functions.field\"");
        }
    }
}
