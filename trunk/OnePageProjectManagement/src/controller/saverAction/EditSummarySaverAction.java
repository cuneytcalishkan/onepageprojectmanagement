package controller.saverAction;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Project;
import model.Puser;
import model.Summary;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.hibernate.Session;
import org.hibernate.Transaction;

import controller.HibernateUtil;
import controller.form.SummaryForm;

/**
 * @author tile
 */
public class EditSummarySaverAction extends Action {
    
    public ActionForward execute(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) {

        HttpSession session = request.getSession(true);
        SummaryForm summaryForm = (SummaryForm) form;
    	Puser user = (Puser) session.getAttribute("user");

        Session hibernateSession = HibernateUtil.getSession();
    	Transaction ta = hibernateSession.beginTransaction();
    	Project pr = (Project) hibernateSession.get(Project.class, summaryForm.getProjectId());
        
        if( user == null || pr == null || (user.getId() != pr.getLeader().getId() ))  {
        	throw new RuntimeException("You are not unauthorized to execute this action.");
        }
    	
        Summary summary = new Summary();
        summary.setDescription(summaryForm.getDescription());
        summary.setSummaryDate(new Date());
        summary.setProject(pr);
    	
        hibernateSession.saveOrUpdate(summary);
        ta.commit();
        hibernateSession.close();
        ActionMessages actionMessages = new ActionMessages();
        actionMessages.add(ActionMessages.GLOBAL_MESSAGE,
                new ActionMessage("summary.added",summary.getDescription()));
        saveMessages(request,actionMessages);
        return new ActionForward("/OnePageProject.do?id="+summaryForm.getProjectId());
    }
    
}
