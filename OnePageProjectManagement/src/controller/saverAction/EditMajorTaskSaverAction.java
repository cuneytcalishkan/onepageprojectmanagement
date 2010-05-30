package controller.saverAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MajorTask;
import model.Objective;
import model.Puser;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.hibernate.Session;
import org.hibernate.Transaction;

import controller.HibernateUtil;
import controller.form.MajorTaskForm;
import exception.AddElementException;

public class EditMajorTaskSaverAction extends Action{

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession(true);
		MajorTaskForm majorTaskForm = (MajorTaskForm) form;
		Puser user = (Puser) session.getAttribute("user");
		if (user == null || (!user.getRole().equals("project manager"))) {
			throw new RuntimeException(
					"You are not authorized to execute this action.");
		}
		Session hibernateSession = HibernateUtil.getSession();
		Transaction ta = hibernateSession.beginTransaction();
		Long id = majorTaskForm.getId();
		MajorTask majorTask;
		if (id != null && id != 0)
			majorTask = (MajorTask) hibernateSession.get(MajorTask.class, id);
		else
			majorTask = new MajorTask();
		
		majorTask.setName(majorTaskForm.getName());
		String[] objectives = majorTaskForm.getObjectivesList();
		for(int i = 0; i< objectives.length; i++){
			Objective obj = (Objective) hibernateSession.get(Objective.class, Long.parseLong(objectives[i]));
			majorTask.addObjective(obj);
			try {
				obj.addMajorTask(majorTask);
			} catch (AddElementException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			hibernateSession.saveOrUpdate(obj);
		}
		
		hibernateSession.saveOrUpdate(majorTask);
		ta.commit();
		hibernateSession.close();
		ActionMessages actionMessages = new ActionMessages();
        actionMessages.add(ActionMessages.GLOBAL_MESSAGE,
                new ActionMessage("majorTask.added",majorTask.getName()));
        saveMessages(request,actionMessages);
		return new ActionForward("/OnePageProject.do?id="+majorTaskForm.getProjectId());
	}
	
}
