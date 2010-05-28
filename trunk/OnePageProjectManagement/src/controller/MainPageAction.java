package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Project;
import model.Puser;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Session;

public class MainPageAction extends Action {
    
	@SuppressWarnings("unchecked")
	public ActionForward execute(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) {
    	HttpSession session = request.getSession(true);
    	Puser user = (Puser) session.getAttribute("user");
    	
    	Session ses = HibernateUtil.getSession();
        
    	List<Project> projects;
    	if(user.getRole().equals("manager")){
    		projects = ses.createQuery("from Project").list();
    	}
    	else{
    		projects = user.getProjects();
    	}
    	
    	request.setAttribute("projects", projects);
		return (mapping.findForward("success"));
	}

}