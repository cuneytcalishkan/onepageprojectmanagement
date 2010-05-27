package controller;

import java.text.DateFormat;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Project;
import model.Puser;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.hibernate.Session;
import org.hibernate.Transaction;

import controller.form.ProjectForm;

/**
 * @author tile
 */
public class EditProjectSaverAction extends DispatchAction {
    
    public ActionForward execute(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) {

        HttpSession session = request.getSession(true);
        String role = (String) session.getAttribute("role");
        if( ! role.equals("ProjectManager"))  {
        	throw new RuntimeException("You are not unauthorized to execute this action.");
        }

        ProjectForm projectForm = (ProjectForm) form;

        
        Session hibernateSession = HibernateUtil.getSession();
    	Transaction ta = hibernateSession.beginTransaction();
    	Long id = projectForm.getId();
    	Project project;
		if(id != null || id != 0)
			project = (Project) hibernateSession.get(Project.class, id);
		else
			project = new Project();
			/*project = new Project(projectForm.getName(), projectForm.getStartDate(),
					projectForm.getFinishDate(), null, projectForm.getObjective());//TODO leaderin gidiþatý
        */
		project.setName(projectForm.getName());
		project.setObjective(projectForm.getObjective());
		Puser leader = (Puser) hibernateSession.get(Puser.class, projectForm.getId());
		project.setLeader(leader);
		try {
			project.setStartDate(DateFormat.getDateInstance().parse(projectForm.getStartDate()));
			project.setFinishDate(DateFormat.getDateInstance().parse(projectForm.getFinishDate()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        hibernateSession.saveOrUpdate(project);
        /*wd.addWeatherDiary(p);
        hibernateSession.update(wd);*/
        ta.commit();
        hibernateSession.close();
        return mapping.findForward("success");
    }
    
}
