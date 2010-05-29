package controller.editAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Project;
import model.Puser;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;
import org.hibernate.Session;
import org.hibernate.Transaction;

import controller.HibernateUtil;
import controller.form.SummaryForm;

/**
 * @author tile
 */
public class EditSummaryAction extends DispatchAction {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		SummaryForm summaryForm = (SummaryForm) form;
		Puser user = (Puser) session.getAttribute("user");

		Transaction ta = null;
		Session hibernateSession = HibernateUtil.getSession();
		try {
			ta = hibernateSession.beginTransaction();
			Project pr = (Project) hibernateSession.get(Project.class,
					summaryForm.getProjectId());
			if (user == null || pr == null
					|| (user.getId() != pr.getLeader().getId())) {
				throw new RuntimeException(
						"You are not authorized to execute this action.");
			}

			/*
			 * Summary pUser = (Puser) hibernateSession.get(Puser.class,
			 * summaryForm.getId());
			 * summaryForm.setUserName(pUser.getUserName());
			 */

			ta.commit();
			hibernateSession.close();
			return mapping.getInputForward();
		} catch (Exception e) {
			if (ta != null) {
				ta.rollback();
				hibernateSession.close();
			}
			ActionMessages actionMessages = new ActionMessages();
			actionMessages.add(ActionMessages.GLOBAL_MESSAGE,
					new ActionMessage("exception"));
			saveMessages(request, actionMessages);
			return mapping.findForward("failure");
		}

	}

}
