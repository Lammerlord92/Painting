package org.javcarfer.domain;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;

/** Represents a paint, reflex information about the paint and company for an easy location.
 * @author Javier Carmona
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(name = "paints")
@Access(AccessType.PROPERTY)
@NamedQuery(name = "Paint.findAll",query="SELECT p FROM Paint p")
public class Paint extends DomainObject implements Serializable {
    private static final long serialVersionUID=1L;
    // Constructors -----------------------------------------------------------
    public Paint() {
        super();
    }

    public Paint(String name, String brand, String code) {
        super();
        this.name = name;
        this.brand = brand;
        this.code = code;
    }

    public Paint(String name, String brand, String code, String range) {
        super();
        this.name = name;
        this.brand = brand;
        this.code = code;
        this.brandRange=range;
    }

    // Attributes -------------------------------------------------------------
    @NotNull
    private String name;
    private String brand;
    private String brandRange;
    private String code;

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

    public String getBrandRange() { return brandRange; }

    public void setBrandRange(String range) { this.brandRange = range; }

    public String getCode() { return code; }

    public void setCode(String code) { this.code = code; }
}
