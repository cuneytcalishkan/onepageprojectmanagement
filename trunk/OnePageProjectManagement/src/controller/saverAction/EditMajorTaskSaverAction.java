package controller.saverAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MajorTask;
import model.Puser;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.hibernate.Session;
import org.hibernate.Transaction;

import controller.HibernateUtil;
import controller.form.MajorTaskForm;

public class EditMajorTaskSaverAction extends DispatchAction{

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
		
		hibernateSession.saveOrUpdate(majorTask);
		ta.commit();
		hibernateSession.close();
		return mapping.findForward("success");
	}
	
}
