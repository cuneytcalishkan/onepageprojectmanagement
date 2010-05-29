package controller;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MajorTask;
import model.Objective;
import model.Project;
import model.SubjectiveTask;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Session;

import controller.form.IdForm;

public class OnePageProjectAction extends Action {
    
	@SuppressWarnings("unchecked")
	public ActionForward execute(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) {
    	/*HttpSession session = request.getSession(true);
    	Puser user = (Puser) session.getAttribute("user");*/
    	IdForm idForm = (IdForm) form;
        Long id = idForm.getId();
    	
    	Session ses = HibernateUtil.getSession();
        Project project = (Project) ses.get(Project.class, id);
        request.setAttribute("project", project);
        
        List<Objective> objectives = project.getObjectives();
        Set<MajorTask> mTasks = new HashSet<MajorTask>();
        Set<SubjectiveTask> sTasks = new HashSet<SubjectiveTask>();
        Iterator<Objective> it = objectives.iterator();
        while(it.hasNext()){
        	Objective obj = it.next();
        	mTasks.addAll(obj.getMajorTasks());
        	sTasks.addAll(obj.getSubjectiveTasks());
        }
        request.setAttribute("mTasks", mTasks);
        request.setAttribute("sTasks", sTasks);
    	
		return (mapping.findForward("success"));
	}

}
