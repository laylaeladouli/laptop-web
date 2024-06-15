package be.layla.laptop.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Collection;


@Entity
public class Laptop {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    private String title;
    @NotBlank
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
    private double price;
    private String imgUrl;
    private String linkWeb;
    @Lob
    private String description;


    @OneToMany(mappedBy = "laptop")
    private Collection<Customerorder> customerorders;

    public Collection<Customerorder> getCustomerorders() {
        return customerorders;
    }

    public void setCustomerorders(Collection<Customerorder> customerorders) {
        this.customerorders = customerorders;
    }

    public Laptop() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public int getHardDis() {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getLinkWeb() {
        return linkWeb;
    }

    public void setLinkWeb(String linkWeb) {
        this.linkWeb = linkWeb;
    }


    public Integer getOrderCount() {
        return customerorders != null ? customerorders.size() : 0;
    }


}
