package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

/**
 * @author tile
 */
public class LogoutAction extends Action {
    
    public ActionForward execute(ActionMapping mapping,
          ActionForm form,
          HttpServletRequest request,
          HttpServletResponse response) {
        
    	// simply invalidate the session to logout
        HttpSession session = request.getSession(true);
        session.invalidate();

        ActionMessages actionMessages = new ActionMessages();
        actionMessages.add(ActionMessages.GLOBAL_MESSAGE,
                new ActionMessage("logout.ok"));
        saveMessages(request,actionMessages);

        // no caching for this page
        //HttpHelper.noCache(response);
        
        return mapping.findForward("success");
    }

}
