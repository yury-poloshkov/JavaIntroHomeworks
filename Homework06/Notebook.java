package Homework06;

/**
 * Notebook
 * Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. 
 * Реализовать в java.
 */

public class Notebook {

    private String model;
    private Producer producer;
    private HDtype hd;
    private int hdCapacity;
    private int ramCapacity;
    private String graphics;
    private String processor;
    private OpSystem os;
    private Color color;
    private Storage stock;
    private String stockplace;
    private float price;

    public Notebook(String producer, String hdType, int hdCapacity, 
        int ramCapacity, String graphics, String processor, String os, String color,
        String stock, String stockplace, float price){
        
        this.model = producer + "-" + processor + "-" + ramCapacity + "-" + hdCapacity;
        this.producer = Producer.valueOf(producer);
        this.hd = HDtype.valueOf(hdType);
        this.hdCapacity = hdCapacity;
        this.ramCapacity = ramCapacity;
        this.graphics = graphics;
        this.processor = processor;
        this.os = OpSystem.valueOf(os);
        this.color = Color.valueOf(color);
        this.stock = Storage.valueOf(stock);
        this.stockplace = stockplace; 
        this.price = price;        
    }

    public String getModel() {
        return model;
    }
    public String getProducer() {
        return this.producer.toString();
    }
    public String getHd(){
        return this.hd.toString();
    }
    public String getColor() {
        return this.color.toString();
    }
    public String getOs() {
        return this.os.toString();
    }
    public String getProcessor(){
        return processor;
    }
    public String getGraphics() {
        return graphics;
    }
    public String getStockplace() {
        return this.stock + ": " + this.stockplace;
    }
    public int getHdCapacity() {
        return hdCapacity;
    }
    public int getRamCapacity() {
        return ramCapacity;
    }
    public float getPrice() {
        return price;
    }
    public String getHardware() {
        return this.processor + "/" + 
                this.ramCapacity + "/" + this.hd + 
                this.hdCapacity + "/" + this.graphics;
    }    
    public void setOs(String os) {
        try {this.os = OpSystem.valueOf(os);
            if (!os.equals("None")){
                System.out.printf("На ноутбук %s инсталирована %s.\n", this.model, this.os);
            }else{
                System.out.printf("Операционная система с ноутбука  %s деинсталирована!\n", this.model);
            }
        } catch (Exception e) {
            System.out.printf("Лицензии на ОС: %s закончились, инсталляция невозможна.\n", os);   
        }
    }

    public void setStock(String stock) {
        this.stock = Storage.valueOf(stock);
        System.out.printf("Ноутбук %s перемещен на склад: %s", this.model, this.stock);
    }
    public void setStockplace(String stockplace) {
        this.stockplace = stockplace;
        System.out.printf("Ноутбук %s перемещен @%s на %s", this.model, this.stock, this.stockplace);
    }

    public void setPrice(float price) {
        this.price = price;
        System.out.printf("Переоценка товара: установлена цена %.2f на ноутбук %s\n", this.price, this.model);
    }

    @Override
    public String toString() {
        return this.model + ":" + getHardware() + "/" + this.os + "/" + this.color; 
                
    }
    
    public enum Color{
        BLACK, GREY, RED, PINK, WHITE
    }
    public enum OpSystem{
        MacOS, MsWindows, Linux, FreeBSD, DOS, None
    }
    public enum Producer{
        Apple, HP, ASUS, Lenovo, DELL, Sumsung, Sony
    }
    public enum HDtype{
        SSD, HDD
    }
    public enum Storage{
        ShowRoom, ShowRoomStock, CentralStock, RemoteStock      
    }
}