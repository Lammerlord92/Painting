package org.javcarfer.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Access(AccessType.PROPERTY)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class DomainObject{
    public DomainObject() {
        super();
    }

    // Identification ---------------------------------------------------------

    private Long  id;
    private Integer  version;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "IdGenerator")
    @TableGenerator(table = "SEQUENCES", name = "IdGenerator")
    public Long  getId() {
        return id;
    }

    public void setId(Long  id) {
        this.id = id;
    }

    @Version
    public Integer  getVersion() {
        return version;
    }

    public void setVersion(Integer  version) {
        this.version = version;
    }

    // Equality ---------------------------------------------------------------

    @Override
    public boolean equals(Object other) {
        boolean result;

        if (this == other)
            result = true;
        else if (other == null)
            result = false;
        else if (other instanceof Integer)
            result = (this.getId() == (Long) other);
        else if (!this.getClass().isInstance(other))
            result = false;
        else
            result = (this.getId() == ((DomainObject) other).getId());

        return result;
    }

}