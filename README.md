# Final-Project-PBO


classDiagram
    Invoice --o  Barang : has
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
      +StringProperty CpuProperty()
      +StringProperty GpuProperty()
      +IntegerProperty RamProperty()
      +IntegerProperty StorageProperty()
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
    
    test
  
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
    
