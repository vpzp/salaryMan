package com.example.demo;

import com.example.demo.h2.Functions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Component
public class H2DatabaseInitializer {

    @Autowired
    private DataSource dataSource;

    @EventListener(ApplicationReadyEvent.class)
    public void initializeDatabase() {
        try (Connection connection = dataSource.getConnection()) {
            Functions.createFieldFunction(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}