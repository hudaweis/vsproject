package com.vshuok.es.showcase.excel.repository;

import org.hibernate.Session;
import org.hibernate.jdbc.Work;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Connection;
import java.sql.SQLException;


public class ExcelDataRepositoryImpl {


    @PersistenceContext
    private EntityManager em;


    public void truncate() {
        em.unwrap(Session.class).doWork(new Work() {
            @Override
            public void execute(final Connection connection) throws SQLException {
                connection.createStatement().execute("truncate table showcase_excel_data");
            }
        });


    }
}
