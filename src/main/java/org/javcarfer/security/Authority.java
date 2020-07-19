package org.javcarfer.security;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.Collection;

/** Represents the user account authority and its possible values.
 * @author Javier Carmona
 * @version 1.0
 * @since 1.0
 */
//TODO Check possibility of get authorities from DB
@Embeddable
@Access(AccessType.PROPERTY)
public class Authority implements GrantedAuthority {

    // Constructors -----------------------------------------------------------

    private static final long serialVersionUID = 1L;

    public Authority() {
        super();
    }

    // Values -----------------------------------------------------------------

    public static final String ADMIN = "ADMIN";
    public static final String USER = "USER";

    // Attributes -------------------------------------------------------------

    private String authority;

    @NotBlank
    @Pattern(regexp = "^" + ADMIN + "|" + USER+"$")
    @Override
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public static Collection<Authority> listAuthorities() {
        Collection<Authority> result;
        Authority authority;

        result = new ArrayList<Authority>();

        authority = new Authority();
        authority.setAuthority(ADMIN);
        result.add(authority);

        authority = new Authority();
        authority.setAuthority(USER);
        result.add(authority);

        return result;
    }

    // Equality ---------------------------------------------------------------

    @Override
    public int hashCode() {
        return this.getAuthority().hashCode();
    }

    @Override
    public boolean equals(Object other) {
        boolean result;

        if (this == other)
            result = true;
        else if (other == null)
            result = false;
        else if (!this.getClass().isInstance(other))
            result = false;
        else
            result = (this.getAuthority().equals(((Authority) other).getAuthority()));

        return result;
    }

}