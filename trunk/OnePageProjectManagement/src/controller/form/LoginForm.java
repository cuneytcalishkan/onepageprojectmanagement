package controller.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class LoginForm extends ActionForm {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
    private String password;
    
        
    /**
     * @return Returns the password.
     */
    public String getPassword() {
        return password;
    }
    
    /**
     * @param password The password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * @return Returns the username.
     */
    public String getUsername() {
        return username;
    }
    
    /**
     * @param username The username to set.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    public void reset(ActionMapping arg0, HttpServletRequest arg1) {
        username = null;
        password = null;
    }
}
