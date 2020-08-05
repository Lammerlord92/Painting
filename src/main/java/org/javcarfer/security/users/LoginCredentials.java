package org.javcarfer.security.users;

import javax.validation.constraints.Size;

/** Object for use in the login view. Used for getting the JWT.
 * @author Javier Carmona
 * @version 1.0
 * @since 1.0
 */
public class LoginCredentials {

    // Constructors -----------------------------------------------------------

    public LoginCredentials() {
        super();
    }

    // Attributes -------------------------------------------------------------

    private String username;
    private String password;

    @Size(min = 5, max = 32)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Size(min = 5, max = 32)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
