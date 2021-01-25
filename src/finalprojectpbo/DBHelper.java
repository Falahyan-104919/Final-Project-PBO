package finalprojectpbo;

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
    private static Connection conn = null;
 
    public static Connection getConnection(String driver) throws SQLException {
        if(conn == null){
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
                            ") ENGINE=InnoDB DEFAULT CHARSET=latin1;\n" +
                            "INSERT IGNORE INTO `barang` (`id`, `nama_barang`, `brand`, `harga`)\n" +
                            "  VALUES ('1211000', 'Laptop Asus Rog G703GXR', 'Asus', '62999000');\n" +
                            "INSERT IGNORE INTO `barang` (`id`, `nama_barang`, `brand`, `harga`)\n" +
                            "  VALUES ('1211001', 'MSI WP565', 'MSI', '73999000');\n" +
                            "INSERT IGNORE INTO `barang` (`id`, `nama_barang`, `brand`, `harga`)\n" +
                            "  VALUES ('1211002', 'Asus ROG Chimera G703GI', 'Asus', '69999000');\n" +
                            "INSERT IGNORE INTO `barang` (`id`, `nama_barang`, `brand`, `harga`)\n" +
                            "  VALUES ('1211003', 'Acer Predator Helios PH717', 'Acer', '67999000');\n" +
                            "INSERT IGNORE INTO `barang` (`id`, `nama_barang`, `brand`, `harga`)\n" +
                            "  VALUES ('1211004', 'Alienware 17-R4', 'Asus', '34999000');\n" +
                            "INSERT IGNORE INTO `barang` (`id`, `nama_barang`, `brand`, `harga`)\n" +
                            "  VALUES ('1212000', 'Benq Zowie XL2740', 'Benq', '9385000');\n" +
                            "INSERT IGNORE INTO `barang` (`id`, `nama_barang`, `brand`, `harga`)\n" +
                            "  VALUES ('1212001', 'AOC AGON AG271QX', 'AOC', '7599000');\n" +
                            "INSERT IGNORE INTO `barang` (`id`, `nama_barang`, `brand`, `harga`)\n" +
                            "  VALUES ('1212002', 'Acer Predator XB241H', 'Acer', '7370000');\n" +
                            "INSERT IGNORE INTO `barang` (`id`, `nama_barang`, `brand`, `harga`)\n" +
                            "  VALUES ('1212003', 'Dell S2417DG', 'Dell', '7000000');\n" +
                            "INSERT IGNORE INTO `barang` (`id`, `nama_barang`, `brand`, `harga`)\n" +
                            "  VALUES ('1212004', 'MSI Optix MAG24C', 'MSI', '4850000');\n" +
                            "INSERT IGNORE INTO `barang` (`id`, `nama_barang`, `brand`, `harga`)\n" +
                            "  VALUES ('1213000', 'Epson L310', 'Epson', '1730000');\n" +
                            "INSERT IGNORE INTO `barang` (`id`, `nama_barang`, `brand`, `harga`)\n" +
                            "  VALUES ('1213001', 'Canon Pixma MG2570', 'Canon', '675000');\n" +
                            "INSERT IGNORE INTO `barang` (`id`, `nama_barang`, `brand`, `harga`)\n" +
                            "  VALUES ('1213002', 'HP DeskJet 1010', 'HP', '415000');\n" +
                            "INSERT IGNORE INTO `barang` (`id`, `nama_barang`, `brand`, `harga`)\n" +
                            "  VALUES ('1213003', 'HP LaserJet Pro M15A', 'HP', '1245000');\n" +
                            "INSERT IGNORE INTO `barang` (`id`, `nama_barang`, `brand`, `harga`)\n" +
                            "  VALUES ('1213004', 'Canon imageClass LBP6030w', 'Canon', '1479000');\n" +
                            "INSERT IGNORE INTO `laptop` (`id`, `cpu`, `gpu`, `ram`, `storage`) \n" +
                            "  VALUES ('1211000', 'Intel Coffee Lake 9th Hexa Core i7 9750H', 'NVIDIA RTX2080 8GB GDDR6', '64', '2048');\n" +
                            "INSERT IGNORE INTO `laptop` (`id`, `cpu`, `gpu`, `ram`, `storage`) \n" +
                            "  VALUES ('1211001', 'Intel Core i9-8950HK', 'NVIDIA RTX2080 8GB GDDR6', '64', '2048');\n" +
                            "INSERT IGNORE INTO `laptop` (`id`, `cpu`, `gpu`, `ram`, `storage`) \n" +
                            "  VALUES ('1211002', 'Intel Core i9-8950HK', 'NVIDIA RTX2080 8GB GDDR6', '64', '2048');\n" +
                            "INSERT IGNORE INTO `laptop` (`id`, `cpu`, `gpu`, `ram`, `storage`) \n" +
                            "  VALUES ('1211003', 'Intel Core i9-8950HK', 'NVIDIA RTX2080 8GB GDDR6', '64', '2048');\n" +
                            "INSERT IGNORE INTO `laptop` (`id`, `cpu`, `gpu`, `ram`, `storage`) \n" +
                            "  VALUES ('1211004', 'Intel Core i9-8950HK', 'NVIDIA RTX2080 8GB GDDR6', '64', '2048');\n" +
                            "INSERT IGNORE INTO monitor (id, tipe_panel, resolusi, refresh_rate)\n" +
                            "  VALUES (1212000, 'TN', 'Full HD (1920x1080)', 240);\n" +
                            "INSERT IGNORE INTO monitor (id, tipe_panel, resolusi, refresh_rate)\n" +
                            "  VALUES (1212001, 'TN', 'Full HD (2560x1440)', 144);\n" +
                            "INSERT IGNORE INTO monitor (id, tipe_panel, resolusi, refresh_rate)\n" +
                            "  VALUES (1212002, 'TN Film', 'Full HD (1920x1080)', 144);\n" +
                            "INSERT IGNORE INTO monitor (id, tipe_panel, resolusi, refresh_rate)\n" +
                            "  VALUES (1212003, 'TN', 'Full HD (2560x1440)', 240);\n" +
                            "INSERT IGNORE INTO monitor (id, tipe_panel, resolusi, refresh_rate)\n" +
                            "  VALUES (1212004, 'VA', 'Full HD (1920 x 1080)', 144);\n" +
                            "INSERT IGNORE INTO printer (id, jenis_printer, print_rate, scan)\n" +
                            "  VALUES (1213000, 'Printer Inkjet', 33, 0);\n" +
                            "INSERT IGNORE INTO printer (id, jenis_printer, print_rate, scan)\n" +
                            "  VALUES (1213001, 'Printer Inkjet', 8, 1); \n" +
                            "INSERT IGNORE INTO printer (id, jenis_printer, print_rate, scan)\n" +
                            "  VALUES (1213002, 'Printer Inkjet', 7, 1);\n" +
                            "INSERT IGNORE INTO printer (id, jenis_printer, print_rate, scan)\n" +
                            "  VALUES (1213003, 'Laser Monochrome Printer', 20, 0);\n" +
                            "INSERT IGNORE INTO printer (id, jenis_printer, print_rate, scan)\n" +
                            "  VALUES (1213004, ' Laser Monochrome Printer', 19, 0);";
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
                            ");\n" +
                            "INSERT OR IGNORE INTO `barang` (`id`, `nama_barang`, `brand`, `harga`)\n" +
                            "  VALUES ('1211000', 'Laptop Asus Rog G703GXR', 'Asus', '62999000');\n" +
                            "INSERT OR IGNORE INTO `barang` (`id`, `nama_barang`, `brand`, `harga`)\n" +
                            "  VALUES ('1211001', 'MSI WP565', 'MSI', '73999000');\n" +
                            "INSERT OR IGNORE INTO `barang` (`id`, `nama_barang`, `brand`, `harga`)\n" +
                            "  VALUES ('1211002', 'Asus ROG Chimera G703GI', 'Asus', '69999000');\n" +
                            "INSERT OR IGNORE INTO `barang` (`id`, `nama_barang`, `brand`, `harga`)\n" +
                            "  VALUES ('1211003', 'Acer Predator Helios PH717', 'Acer', '67999000');\n" +
                            "INSERT OR IGNORE INTO `barang` (`id`, `nama_barang`, `brand`, `harga`)\n" +
                            "  VALUES ('1211004', 'Alienware 17-R4', 'Asus', '34999000');\n" +
                            "INSERT OR IGNORE INTO `barang` (`id`, `nama_barang`, `brand`, `harga`)\n" +
                            "  VALUES ('1212000', 'Benq Zowie XL2740', 'Benq', '9385000');\n" +
                            "INSERT OR IGNORE INTO `barang` (`id`, `nama_barang`, `brand`, `harga`)\n" +
                            "  VALUES ('1212001', 'AOC AGON AG271QX', 'AOC', '7599000');\n" +
                            "INSERT OR IGNORE INTO `barang` (`id`, `nama_barang`, `brand`, `harga`)\n" +
                            "  VALUES ('1212002', 'Acer Predator XB241H', 'Acer', '7370000');\n" +
                            "INSERT OR IGNORE INTO `barang` (`id`, `nama_barang`, `brand`, `harga`)\n" +
                            "  VALUES ('1212003', 'Dell S2417DG', 'Dell', '7000000');\n" +
                            "INSERT OR IGNORE INTO `barang` (`id`, `nama_barang`, `brand`, `harga`)\n" +
                            "  VALUES ('1212004', 'MSI Optix MAG24C', 'MSI', '4850000');\n" +
                            "INSERT OR IGNORE INTO `barang` (`id`, `nama_barang`, `brand`, `harga`)\n" +
                            "  VALUES ('1213000', 'Epson L310', 'Epson', '1730000');\n" +
                            "INSERT OR IGNORE INTO `barang` (`id`, `nama_barang`, `brand`, `harga`)\n" +
                            "  VALUES ('1213001', 'Canon Pixma MG2570', 'Canon', '675000');\n" +
                            "INSERT OR IGNORE INTO `barang` (`id`, `nama_barang`, `brand`, `harga`)\n" +
                            "  VALUES ('1213002', 'HP DeskJet 1010', 'HP', '415000');\n" +
                            "INSERT OR IGNORE INTO `barang` (`id`, `nama_barang`, `brand`, `harga`)\n" +
                            "  VALUES ('1213003', 'HP LaserJet Pro M15A', 'HP', '1245000');\n" +
                            "INSERT OR IGNORE INTO `barang` (`id`, `nama_barang`, `brand`, `harga`)\n" +
                            "  VALUES ('1213004', 'Canon imageClass LBP6030w', 'Canon', '1479000');\n" +
                            "INSERT OR IGNORE INTO `laptop` (`id`, `cpu`, `gpu`, `ram`, `storage`) \n" +
                            "  VALUES ('1211000', 'Intel Coffee Lake 9th Hexa Core i7 9750H', 'NVIDIA RTX2080 8GB GDDR6', '64', '2048');\n" +
                            "INSERT OR IGNORE INTO `laptop` (`id`, `cpu`, `gpu`, `ram`, `storage`) \n" +
                            "  VALUES ('1211001', 'Intel Core i9-8950HK', 'NVIDIA RTX2080 8GB GDDR6', '64', '2048');\n" +
                            "INSERT OR IGNORE INTO `laptop` (`id`, `cpu`, `gpu`, `ram`, `storage`) \n" +
                            "  VALUES ('1211002', 'Intel Core i9-8950HK', 'NVIDIA RTX2080 8GB GDDR6', '64', '2048');\n" +
                            "INSERT OR IGNORE INTO `laptop` (`id`, `cpu`, `gpu`, `ram`, `storage`) \n" +
                            "  VALUES ('1211003', 'Intel Core i9-8950HK', 'NVIDIA RTX2080 8GB GDDR6', '64', '2048');\n" +
                            "INSERT OR IGNORE INTO `laptop` (`id`, `cpu`, `gpu`, `ram`, `storage`) \n" +
                            "  VALUES ('1211004', 'Intel Core i9-8950HK', 'NVIDIA RTX2080 8GB GDDR6', '64', '2048');\n" +
                            "INSERT OR IGNORE INTO monitor (id, tipe_panel, resolusi, refresh_rate)\n" +
                            "  VALUES (1212000, 'TN', 'Full HD (1920x1080)', 240);\n" +
                            "INSERT OR IGNORE INTO monitor (id, tipe_panel, resolusi, refresh_rate)\n" +
                            "  VALUES (1212001, 'TN', 'Full HD (2560x1440)', 144);\n" +
                            "INSERT OR IGNORE INTO monitor (id, tipe_panel, resolusi, refresh_rate)\n" +
                            "  VALUES (1212002, 'TN Film', 'Full HD (1920x1080)', 144);\n" +
                            "INSERT OR IGNORE INTO monitor (id, tipe_panel, resolusi, refresh_rate)\n" +
                            "  VALUES (1212003, 'TN', 'Full HD (2560x1440)', 240);\n" +
                            "INSERT OR IGNORE INTO monitor (id, tipe_panel, resolusi, refresh_rate)\n" +
                            "  VALUES (1212004, 'VA', 'Full HD (1920 x 1080)', 144);\n" +
                            "INSERT OR IGNORE INTO printer (id, jenis_printer, print_rate, scan)\n" +
                            "  VALUES (1213000, 'Printer Inkjet', 33, 0);\n" +
                            "INSERT OR IGNORE INTO printer (id, jenis_printer, print_rate, scan)\n" +
                            "  VALUES (1213001, 'Printer Inkjet', 8, 1); \n" +
                            "INSERT OR IGNORE INTO printer (id, jenis_printer, print_rate, scan)\n" +
                            "  VALUES (1213002, 'Printer Inkjet', 7, 1);\n" +
                            "INSERT OR IGNORE INTO printer (id, jenis_printer, print_rate, scan)\n" +
                            "  VALUES (1213003, 'Laser Monochrome Printer', 20, 0);\n" +
                            "INSERT OR IGNORE INTO printer (id, jenis_printer, print_rate, scan)\n" +
                            "  VALUES (1213004, ' Laser Monochrome Printer', 19, 0);";
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
