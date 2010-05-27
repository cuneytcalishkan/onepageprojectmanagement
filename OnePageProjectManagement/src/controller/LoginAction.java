package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import controller.form.LoginForm;


/**
 * @author tile
 */
public class LoginAction extends Action {
    
    public ActionForward execute(ActionMapping mapping,
          ActionForm form,
          HttpServletRequest request,
          HttpServletResponse response) {
        
        LoginForm loginForm = (LoginForm) form;
        String username = loginForm.getUsername();
        String password = loginForm.getPassword();
        
        if(username == null && password == null) {
            // no login info, go to login.jsp
            return mapping.getInputForward();
        }
        
        if("admin".equals(username) && "secret".equals(password)) {
            HttpSession session = request.getSession(true);
            session.setAttribute("isAdminUser", new Boolean(true));
            
            ActionMessages actionMessages = new ActionMessages();
            actionMessages.add(ActionMessages.GLOBAL_MESSAGE,
            new ActionMessage("login.ok"));
            saveMessages(request,actionMessages);
            
            return mapping.findForward("success");
        } else {
            ActionMessages actionMessages = new ActionErrors();
            actionMessages.add(ActionMessages.GLOBAL_MESSAGE,
            new ActionMessage("login.failed"));
            saveErrors(request,actionMessages);
            
            // password is resetted
            loginForm.setPassword(null);
            
            // get input="/login.jsp" from struts-config.xml
            return mapping.getInputForward();
        }
    }

}