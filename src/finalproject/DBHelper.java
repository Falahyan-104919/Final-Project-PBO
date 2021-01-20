package finalproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBHelper {
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static final String DB = "finalproject";
    private static final String MYSQL_CONN = "jdbc:mysql://localhost/" + DB;
    private static final String SQLITE_CONN = "jdbc:sqlite:finalproject.sqlite";
 
    public static Connection getConnection(String driver) throws SQLException {
        Connection conn = null;
        switch (driver) {
            case "SQLITE": {
                try {
                    Class.forName("org.sqlite.JDBC");
                    conn = DriverManager.getConnection(SQLITE_CONN);
                    createTable(conn, driver);
                } catch (ClassNotFoundException ex) {
                    System.out.println("Library tidak ada");
                    Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
            case "MYSQL": {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    conn = DriverManager.getConnection(MYSQL_CONN, USER, PASSWORD);
                    createTable(conn, driver);
                } catch (ClassNotFoundException ex) {
                    System.out.println("Library tidak ada");
                    Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
        }
        return conn;
    }

    public static void createTable(Connection conn, String driver) throws SQLException {
        String sqlCreate = "";
        switch (driver) {
            case "MYSQL": {
                sqlCreate = "CREATE TABLE IF NOT EXISTS barang (\n" +
                            "  id int(10) NOT NULL,\n" +
                            "  nama_barang varchar(100) DEFAULT NULL,\n" +
                            "  brand varchar(100) DEFAULT NULL,\n" +
                            "  harga varchar(100) DEFAULT NULL,\n" +
                            "  PRIMARY KEY (id)\n" +
                            ") ENGINE=InnoDB DEFAULT CHARSET=latin1;\n" +
                            "CREATE TABLE IF NOT EXISTS invoice (\n" +
                            "  id int(10) NOT NULL,\n" +
                            "  customer varchar(100) DEFAULT NULL,\n" +
                            "  waktu varchar(100) DEFAULT NULL,\n" +
                            "  PRIMARY KEY (id)\n" +
                            ") ENGINE=InnoDB DEFAULT CHARSET=latin1;\n" +
                            "CREATE TABLE IF NOT EXISTS items (\n" +
                            "  id_invoice int(10) DEFAULT NULL,\n" +
                            "  id_barang int(10) DEFAULT NULL,\n" +
                            "  jumlah int(5) DEFAULT NULL,\n" +
                            "  KEY id_barang (id_barang),\n" +
                            "  KEY id_invoice (id_invoice),\n" +
                            "  FOREIGN KEY (id_barang) REFERENCES barang (id) ON UPDATE CASCADE,\n" +
                            "  FOREIGN KEY (id_invoice) REFERENCES invoice (id) ON UPDATE CASCADE\n" +
                            ") ENGINE=InnoDB DEFAULT CHARSET=latin1;\n" +
                            "CREATE TABLE IF NOT EXISTS laptop (\n" +
                            "  id int(10) NOT NULL,\n" +
                            "  cpu varchar(100) DEFAULT NULL,\n" +
                            "  gpu varchar(100) DEFAULT NULL,\n" +
                            "  ram int(5) DEFAULT NULL,\n" +
                            "  storage int(5) DEFAULT NULL,\n" +
                            "  PRIMARY KEY (id),\n" +
                            "  FOREIGN KEY (id) REFERENCES barang (id) ON UPDATE CASCADE\n" +
                            ") ENGINE=InnoDB DEFAULT CHARSET=latin1 ;\n" +
                            "CREATE TABLE IF NOT EXISTS monitor (\n" +
                            "  id int(10) NOT NULL,\n" +
                            "  tipe_panel varchar(100) DEFAULT NULL,\n" +
                            "  resolusi varchar(100) DEFAULT NULL,\n" +
                            "  ukuran_layar int(5) DEFAULT NULL,\n" +
                            "  refresh_rate int(5) DEFAULT NULL,\n" +
                            "  PRIMARY KEY (id),\n" +
                            "  FOREIGN KEY (id) REFERENCES barang (id) ON UPDATE CASCADE\n" +
                            ") ENGINE=InnoDB DEFAULT CHARSET=latin1;\n" +
                            "CREATE TABLE IF NOT EXISTS printer (\n" +
                            "  id int(10) NOT NULL,\n" +
                            "  jenis_printer varchar(100) DEFAULT NULL,\n" +
                            "  print_rate int(5) DEFAULT NULL,\n" +
                            "  scan tinyint(1) DEFAULT NULL,\n" +
                            "  PRIMARY KEY (id),\n" +
                            "  FOREIGN KEY (id) REFERENCES barang (id) ON UPDATE CASCADE\n" +
                            ") ENGINE=InnoDB DEFAULT CHARSET=latin1;";
                break;
            }
            case "SQLITE": {
                sqlCreate = "CREATE TABLE IF NOT EXISTS barang(\n" +
                            "    id INT(10) PRIMARY KEY,\n" +
                            "    nama_barang VARCHAR(100),\n" +
                            "    brand VARCHAR(100),\n" +
                            "    harga VARCHAR(100)\n" +
                            "); CREATE TABLE IF NOT EXISTS invoice(\n" +
                            "    id INT(10) PRIMARY KEY,\n" +
                            "    customer VARCHAR(100),\n" +
                            "    waktu VARCHAR(100)\n" +
                            "); CREATE TABLE IF NOT EXISTS items(\n" +
                            "    id_invoice INT(10) REFERENCES invoice(id) ON DELETE RESTRICT ON UPDATE CASCADE,\n" +
                            "    id_barang INT(10) REFERENCES barang(id) ON DELETE RESTRICT ON UPDATE CASCADE,\n" +
                            "    jumlah INTEGER(5)\n" +
                            "); CREATE TABLE IF NOT EXISTS laptop(\n" +
                            "    id INT(10) PRIMARY KEY REFERENCES barang(id) ON DELETE RESTRICT ON UPDATE CASCADE,\n" +
                            "    CPU VARCHAR(100),\n" +
                            "    gpu VARCHAR(100),\n" +
                            "    ram INT(5),\n" +
                            "    STORAGE INT(5)\n" +
                            "); CREATE TABLE IF NOT EXISTS monitor(\n" +
                            "    id INT(10) PRIMARY KEY REFERENCES barang(id) ON DELETE RESTRICT ON UPDATE CASCADE,\n" +
                            "    tipe_panel VARCHAR(100),\n" +
                            "    resolusi VARCHAR(100),\n" +
                            "    ukuran_layar INT(5),\n" +
                            "    refresh_rate INT(5)\n" +
                            "); CREATE TABLE IF NOT EXISTS printer(\n" +
                            "    id INT(10) PRIMARY KEY REFERENCES barang(id) ON DELETE RESTRICT ON UPDATE CASCADE,\n" +
                            "    jenis_printer VARCHAR(100),\n" +
                            "    print_rate INTEGER(5),\n" +
                            "    scan BOOLEAN\n" +
                            ");";
                break;
            }
        }
        String sqls[] = sqlCreate.split(";");
        for (String sql : sqls) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.execute();
        }
    }
}
