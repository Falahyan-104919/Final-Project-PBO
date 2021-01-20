package finalproject;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Laptop extends Barang{
    private StringProperty cpu, gpu;
    private IntegerProperty ram, storage;

    public Laptop(int id, String nama_barang, String brand, int harga, String cpu, String gpu, int ram, int storage) {
        super(id, nama_barang, brand, harga);
        this.cpu = new SimpleStringProperty(cpu);
        this.gpu = new SimpleStringProperty(gpu);
        this.ram = new SimpleIntegerProperty(ram);
        this.storage = new SimpleIntegerProperty(storage);
    }

    public String getCpu() {
        return cpu.get();
    }

    public void setCpu(String cpu) {
        this.cpu.set(cpu);
    }

    public String getGpu() {
        return gpu.get();
    }

    public void setGpu(String gpu) {
        this.gpu.set(gpu);
    }

    public int getRam() {
        return ram.get();
    }

    public void setRam(int ram) {
        this.ram.set(ram);
    }

    public int getStorage() {
        return storage.get();
    }

    public void setStorage(int storage) {
        this.storage.set(storage);
    }
    
    public StringProperty CpuProperty() {
        return cpu;
    }

    public StringProperty GpuProperty() {
        return gpu;
    }

    public IntegerProperty RamProperty() {
        return ram;
    }

    public IntegerProperty StorageProperty() {
        return storage;
    }
    
    @Override
    public String shortSpec(){
        String spec = "";
        spec += getCpu() + ", ";
        spec += getGpu() + ", ";
        spec += getRam() + "/";
        spec += getStorage() + " GB";
        return spec;
    }
}
