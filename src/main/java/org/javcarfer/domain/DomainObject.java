package org.javcarfer.domain;

import javax.persistence.*;

/** Represents a persistent object that will be used in a DB.
 * @author Javier Carmona
 * @version 1.0
 * @since 1.0
 */
@Entity
@Access(AccessType.PROPERTY)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class DomainObject{
    public DomainObject() {
        super();
    }

    // Identification ---------------------------------------------------------

    private Integer  id;
    private Integer  version;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "IdGenerator")
    @TableGenerator(table = "SEQUENCES", name = "IdGenerator")
    public Integer  getId() {
        return id;
    }

    public void setId(Integer  id) {
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
            result = (this.getId() == (Integer) other);
        else if (!this.getClass().isInstance(other))
            result = false;
        else
            result = (this.getId() == ((DomainObject) other).getId());

        return result;
    }

}