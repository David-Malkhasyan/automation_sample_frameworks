package db_manager;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class DBQueryHelper {

    protected static final Logger logger = LogManager.getLogger(DBQueryHelper.class);


    public static String selectFromWhere(String conditionColumn, String conditionValue, String table, String... parameters) {
        return "Select " + getParametersForDBQuery(parameters) + " From " + table + " Where " + conditionColumn + "=" + "'" + conditionValue + "'";
    }

    private static String getParametersForDBQuery(String... parameters) {
        StringBuilder query = new StringBuilder();
        List<String> params = Arrays.stream(parameters).toList();
        for (int i = 0; i < params.size(); i++) {
            if (i < params.size() - 1) {
                query.append(params.get(i)).append(", ");
            } else {
                query.append(params.get(i));
            }
        }
        return query.toString();
    }

    public static <T> T executeQuery(String query, Class<T> clazz) {
        QueryRunner queryRunner = new QueryRunner();
        Connection conn = DBConnectionProvider.getConnection();
        ResultSetHandler<T> resultHandler = new BeanHandler<>(clazz);
        T pojo = null;
        try {
            logger.info("Retrieving data with following query:" + query);
            pojo = queryRunner.query(conn, query, resultHandler);
            logger.error("SQL query execution success");
        } catch (SQLException e) {
            logger.error("Something went wrong in query execution");
        }
        return pojo;
    }

    public static <T> List<T> executeQueryForList(String query, Class<T> clazz) {
        QueryRunner queryRunner = new QueryRunner();
        Connection conn = DBConnectionProvider.getConnection();
        ResultSetHandler<List<T>> resultHandler = new BeanListHandler<>(clazz);
        List<T> pojo = null;
        try {
            logger.info("Retrieving data with following query:" + query);
            pojo = queryRunner.query(conn, query, resultHandler);
            logger.error("SQL query execution success");
        } catch (SQLException e) {
            logger.error("Something went wrong in query execution");
        }
        return pojo;
    }
}
