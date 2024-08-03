package utils;

import com.github.javafaker.Faker;
import db_manager.DBConnectionProvider;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.SQLException;

public class Utilities {
    static Faker faker = new Faker();

    public static String generateUsername() {
        return faker.name().name();
    }

    public static String generatePassword() {
        return faker.name().username();
    }

    public <T> T executeQuery(String query, Class<T> clazz) {
        QueryRunner queryRunner = new QueryRunner();
        Connection conn = DBConnectionProvider.getConnection();
        ResultSetHandler<T> resultHandler = new BeanHandler<T>(clazz);
        T pojo = null;
        try {
            pojo = queryRunner.query(conn, query, resultHandler);
        } catch (SQLException e) {

        }
        return pojo;
    }
}
