package be.layla.laptop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

import java.math.BigDecimal;


@Entity
public class Laptop {

    @Id
    private Integer id;
    private String brandName;
    private String modelName;
    private String color;
    private double screenSize;
    private int hardDis;
    private String modelCpu;
    private int ram;
    private String operating;
    private String feature;
    private String graphic;
    private BigDecimal price;
    @Lob
    private String description;
    private String imageFileName;

    public Laptop() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public double getHardDis() {
        return hardDis;
    }

    public void setHardDis(int hardDis) {
        this.hardDis= hardDis;
    }

    public String getModelCpu() {
        return modelCpu;
    }

    public void setModelCpu(String modelCpu) {
        this.modelCpu = modelCpu;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getOperating() {
        return operating;
    }

    public void setOperating(String operating) {
        this.operating = operating;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public String getGraphic() {
        return graphic;
    }

    public void setGraphic(String graphic) {
        this.graphic = graphic;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }
}
