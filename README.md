# Final Project Mata Kuliah Pemrograman Berbasis Objek
Anggota Kelompok:
- 1917051020 Nopri Wiratama Friliansa
- 1917051045 Muhammad Bintang Firdaus
- 1917051049 Falahyan


# Invoice System
>Sistem dapat digunakan untuk perekaman Invoice transaksi penjualan barang elektronik yang terdiri dari Laptop,Monitor,Printer.Setiap Invoice dapat memiliki 1 atau lebih Item

Libraries and Tools of this project:

- mysql-connector-java-5.1.xx.jar
- sqlite-jdbc-3.xx.jar
- scene builder
- sqlite studio
- mysql server (xampp recomended)
- netbean editor
- VS Code installed plugin
  - Markdown All in one
  - Markdown preview
  - Live Server
 

# Desain
To view the diagrams below install mermaid-diagram plugin at https://github.com/Redisrupt/mermaid-diagrams

# Class Diagram

classDiagram
    
    Invoice "1"--o"*"  Barang : has
    Barang <|-- Laptop
    Barang <|-- Monitor
    Barang <|-- Printer
    
    class Invoice{
    -int id
    -String customer
    -String waktu
    -ArrayList <Barang> items
    -ArrayList <Integer> jumlah
        +int getId()
        +void setId(int id)
        +String getCustomer()
        +void setCustomer(String customer)
        +String getWaktu()
        +void setWaktu(String waktu)
        +ArrayList <Barang> getItems()
        +void setItems(ArrayList <Barang> items)
        +ArrayList <Integer> getJumlah()
        +void setJumlah(ArrayList <Integer> jumlah)
        +int Jumlah_item()
        +int Total_beli()

    }
    class Barang{
        <<Abstract>>
        -int id
        -String nama_barang
        -String brand
        -int harga
        +int getId()
        +void setId(int id)
        +String getNama_Barang()
        +void setNama_Barang(String nama)
        +String getBrand()
        +void setBrand(String brand)
        +int setHarga()
        +void getHarga(int harga)
        +int IDProperty()
        +String NamaProperty()
        +String BrandProperty()
        +int HargaProperty()
        +String shortSpec()


    }
    class Laptop{
      -String cpu
      -String gpu
      -int ram
      -int storage
      +String getCpu()
      +void setCpu(String cpu)
      +String getGpu()
      +void setGpu(String gpu)
      +int getRam()
      +void setRam(int ram)
      +int getStorage()
      +void setStorage(int storage)
      +String CpuProperty()
      +String GpuProperty()
      +Integer RamProperty()
      +Integer StorageProperty()
      +String shortSpec()
    }
    class Monitor{
      -String tipe_panel
      -String resolusi
      -int ukuran_layar
      -int refresh_rate
      +String getTipe_panel()
      +void setTipe_panel(String tipe_panel)
      +String getResolusi()
      +void setResolusi(String resolusi)
      +int getUkuran_layar()
      +void setUkuran_layar(int ukuran_layar)
      +int getRefresh_rate()
      +void setRefresh_rate(int refresh_rate)
      +String shortSpec()
    }
     
    class Printer{
      -String jenis_printer
      -Boolean scan
      -int print_rate
      +String getJenis_printer()
      +void setJenis_printer(String jenis_printer)
      +int getPrint_rate()
      +void setPrint_rate(int print_rate)
      +boolean getScan()
      +void setScan(boolean scan)
      +String shortSpec()
    }
    
# ER Diagram
erDiagram

          Barang ||--|| Laptop : is
          Barang ||--|| Monitor : is
          Barang ||--|| Printer : is
          Barang }|--|| Invoice : has
          class Invoice{
            -int id
            -String customer
            -String waktu
            -ArrayList <Barang> items
            -ArrayList <Integer> jumlah
          }
          class Barang{
            -int id
            -String nama_barang
            -String brand
            -int harga  
          }
          class Laptop{
            -String cpu
            -String gpu
            -int ram
            -int storage
          }
          class Monitor{
            -String tipe_panel
            -String resolusi
            -int ukuran_layar
            -int refresh_rate
          }
          class Printer{
            -String jenis_printer
            -Boolean scan
            -int print_rate
          }
# Design Class Diagram for JavaFX and Database
    
  classDiagram
  
    DataModel <-- UIController
    UIController <.. formCust : Form Control 
    DBHelper <-- DataModel
    Invoice --o DataModel
     Invoice --o  Barang : has
    Barang <|-- Laptop
    Barang <|-- Monitor
    Barang <|-- Printer
 
    class UIController{
        initialize()
        handleButtonAddL1()
        handleButtonAddL2()
        handleButtonAddL3()
        handleButtonAddL4()
        handleButtonAddL5()
        handleButtonAddM1()
        handleButtonAddM2()
        handleButtonAddM3()
        handleButtonAddM4()
        handleButtonAddM5()
        handleButtonAddP1()
        handleButtonAddP2()
        handleButtonAddP3()
        handleButtonAddP4()
        handleButtonAddP5()
        handleButtonGoMenu()
        handleButtonMakeOrder()
        handleButtonResetList()
        handleReloadButtonList()
        handleButtonInvoiceExit()
        handleButtonInvoicePay()

    }

    class DataModel{
        Connection conn
        tambahBarang()
        tambahInvoice()
        tambahItem()
        getListIDBarang()
        getListJmlBarang()
        nextLaptopID()
        nextMonitorID()
        nextPrinterID()
        nextInvoiceID()
    }
    
    class DBHelper{
        getConnection()
        getConnection(String Driver)
        createTable()
    }

    
    class Invoice{
        -IntegerProperty id
        -StringProperty customer
        -StringProperty waktu
        -ArrayList <Barang> items
        -ArrayList <Integer> jumlah
        +int getId()
        +void setId(int id)
        +String getCustomer()
        +void setCustomer(String customer)
        +String getWaktu()
        +void setWaktu(String waktu)
        +ArrayList <Barang> getItems()
        +void setItems(ArrayList <Barang> items)
        +ArrayList <Integer> getJumlah()
        +void setJumlah(ArrayList <Integer> jumlah)
        +int Jumlah_item()
        +int Total_beli()

    }
    class Barang{
        <<Abstract>>
        -IntegerProperty id
        -StringProperty nama_barang
        -StringProperty brand
        -IntegerProperty harga
        +int getId()
        +void setId(int id)
        +String getNama_Barang()
        +void setNama_Barang(String nama)
        +String getBrand()
        +void setBrand(String brand)
        +int setHarga()
        +void getHarga(int harga)
        +IntegerProperty IDProperty()
        +StringProperty NamaProperty()
        +StringProperty BrandProperty()
        +IntegerProperty HargaProperty()
        +String shortSpec()
    }

    class Laptop{
      -StringProperty cpu
      -StringProperty gpu
      -IntegerProperty ram
      -IntegerProperty storage
      +String getCpu()
      +void setCpu(String cpu)
      +String getGpu()
      +void setGpu(String gpu)
      +int getRam()
      +void setRam(int ram)
      +int getStorage()
      +void setStorage(int storage)
      +StringProperty CpuProperty()
      +StringProperty GpuProperty()
      +IntegerProperty RamProperty()
      +IntegerProperty StorageProperty()
      +String shortSpec()
    }

    class Monitor{
      -StringProperty tipe_panel
      -StringProperty resolusi
      -IntegerProperty ukuran_layar
      -IntegerProperty refresh_rate
      +String getTipe_panel()
      +void setTipe_panel(String tipe_panel)
      +String getResolusi()
      +void setResolusi(String resolusi)
      +int getUkuran_layar()
      +void setUkuran_layar(int ukuran_layar)
      +int getRefresh_rate()
      +void setRefresh_rate(int refresh_rate)
      +String shortSpec()
    }
    
    class Printer{
      -StringProperty jenis_printer
      -BooleanProperty scan
      -IntegerProperty print_rate
      +String getJenis_printer()
      +void setJenis_printer(String jenis_printer)
      +int getPrint_rate()
      +void setPrint_rate(int print_rate)
      +boolean getScan()
      +void setScan(boolean scan)
      +String shortSpec()
    }  
          
            
