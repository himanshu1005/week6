package greatlearning.singleton;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class TestMainSingletonInstance {
    private static int counter = 0;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        AtomicInteger count = new AtomicInteger();
        while (true) {
            executorService.submit(() -> {
                Connection connection = null;
                try {
                    connection = JDBCConnection.getInstance().getConnection();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (connection != null) {
                        try {
                            connection.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }

            });
            if (count.incrementAndGet() >= 10000) {
                System.out.println("Total thread created - " + count.get());
                count.compareAndSet(10000, 0);
                counter++;
                if (counter >= 5) {
                    break;
                }
            }
        }

    } // end of main method

}
