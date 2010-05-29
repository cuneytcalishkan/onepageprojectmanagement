package controller.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class IdForm extends ActionForm {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	
	public ActionErrors validate(ActionMapping arg0, HttpServletRequest arg1) {
        ActionErrors errors = new ActionErrors();

        if (id==null || id == 0)
			errors.add("id", new ActionMessage("project.empty"));
        
        return errors;
	}
    
    /**
     * @return Returns the id.
     */
    public Long getId() {
        return id;
    }
    
    /**
     * @param id The id to set.
     */
    public void setId(Long id) {
        this.id = id;
    }
}
