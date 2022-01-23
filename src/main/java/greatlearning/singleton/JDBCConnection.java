package greatlearning.singleton;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection implements Serializable {
    private static volatile JDBCConnection jdbcConnection;
    private static volatile int counter = 0;
    private static volatile int dbcounter = 0;
    private volatile transient Connection connection = null;
    private int count = 0;

    private JDBCConnection() {
    }

    public static JDBCConnection getInstance() {
        if (jdbcConnection == null) {
            synchronized (JDBCConnection.class) {
                if (jdbcConnection == null) {
                    jdbcConnection = new JDBCConnection();
                    counter++;
                    System.out.println(counter + " object created is " + jdbcConnection);
                }
            }
        }
        return jdbcConnection;
    }

    public Connection getConnection() {

        if (connection == null) {
            synchronized (this) {
                if (connection == null) {
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
                        dbcounter++;
                        System.out.println(dbcounter + " db connection object is " + connection);
                    } catch (SQLException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return connection;
    }

    public int getCounter() {
        return count;
    }

    public void setCounter(int value) {
        count = value;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public Object readResolve() {
        JDBCConnection connection = getInstance();
        return connection;
    }

    @Override
    public String toString() {
        return "JDBCConnection{" +
                "connection=" + connection +
                ", count=" + count +
                '}';
    }
}
