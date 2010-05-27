package controller.form;

import org.apache.struts.action.ActionForm;

public class IdForm extends ActionForm {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
    
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
