package org.javcarfer.domain;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "paints")
@NamedQuery(name = "Paint.findAll",query="SELECT p FROM Paint p")
public class Paint implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer version;
    @NotNull
    private String name;
    private String brand;
    private String code;

    public Paint() {
    }

    public Paint(String name, String brand, String code) {
        this.name = name;
        this.brand = brand;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getVersion() { return version; }

    public void setVersion(int version) { this.version = version; }
}
