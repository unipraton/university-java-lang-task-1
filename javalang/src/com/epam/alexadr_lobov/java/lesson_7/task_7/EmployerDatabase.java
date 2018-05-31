package com.epam.alexadr_lobov.java.lesson_7.task_7;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class EmployerDatabase {

    private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("yyyy-MM-dd");

    String url;
    String user;
    String password;

    public EmployerDatabase(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    private List<Employer> getAll(String tableName) throws SQLException {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            Statement statement = connection.createStatement();

            List<Employer> employers = new ArrayList<Employer>();

            ResultSet set = statement.executeQuery("SELECT * FROM " + tableName + ";");
            while (set.next()) {
                // Use getObject to get null instead of 0 for integers and 0.0 for doubles
                Integer id = set.getInt("empno");
                String name = (String) set.getObject("ename");
                String job = (String) set.getObject("job");
                Integer managerId = (Integer) set.getObject("mgr");
                Date hireDate = set.getDate("hiredate");
                Double sales = (Double) set.getObject("sal");
                Double commision = (Double) set.getObject("comm");
                Integer departament = (Integer) set.getObject("deptno");
                employers.add(new Employer(id, name, job, managerId, hireDate, sales, commision, departament));
            }

            statement.close();
            connection.close();

            return employers;
        } catch (Exception ex) {
            throw ex;
        }
    }

    public List<Employer> getAll() throws SQLException {
        return getAll("emp");
    }

    private String formInsertQuery(Employer employer) {
        return "INSERT INTO employees VALUES ("
                + employer.getId() + ','
                + '\'' + employer.getName() + '\'' + ','
                + '\'' + employer.getJob() + '\'' + ','
                + employer.getManagerId() + ','
                + '\'' + DATE_FORMATTER.format(employer.getHireDate()) + '\'' + ','
                + employer.getSales() + ','
                + employer.getCommision() + ','
                + employer.getDepartamentId() + ");";

    }

    private void createTableIfNotExists(Statement statement) throws SQLException {
        statement.execute("DROP TABLE IF EXISTS employees;\n");
        statement.execute(
                "CREATE TABLE employees (\n" +
                "empno int(4) NOT NULL,\n" +
                "ename varchar(20) default NULL,\n" +
                "job varchar(9) default NULL,\n" +
                "mgr int(4) default NULL,\n" +
                "hiredate date default NULL,\n" +
                "sal double(7,2) default NULL,\n" +
                "comm double(7,2) default NULL,\n" +
                "deptno int(2) default NULL,\n" +
                "PRIMARY KEY (empno)\n" +
            ") ENGINE=InnoDB, DEFAULT CHARSET=utf8;");
    }

    public void insertAllIntoEmployeesTable(Iterable<Employer> employers) throws SQLException {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            Statement statement = connection.createStatement();
            createTableIfNotExists(statement);
            for(Employer employer : employers) {
                statement.execute(formInsertQuery(employer));
            }
            statement.close();
        } catch (Exception ex) {
            throw ex;
        }
    }
}
