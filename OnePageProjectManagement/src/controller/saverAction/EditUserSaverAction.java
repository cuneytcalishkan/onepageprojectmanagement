package controller.saverAction;

import model.Puser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.hibernate.Session;
import org.hibernate.Transaction;

import controller.HibernateUtil;
import controller.form.UserForm;

/**
 * @author tile
 */
public class EditUserSaverAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession(true);
		UserForm userForm = (UserForm) form;
		Puser user = (Puser) session.getAttribute("user");
		if (user == null
				|| (!user.getRole().equals("manager") && !(user.getId() == userForm
						.getId()))) {
			throw new RuntimeException(
					"You are not authorized to execute this action.");
		}
		Session hibernateSession = HibernateUtil.getSession();
		Transaction ta = hibernateSession.beginTransaction();
		Long id = userForm.getId();
		Puser pUser;
		if (id != null && id != 0)
			pUser = (Puser) hibernateSession.get(Puser.class, id);
		else
			pUser = new Puser();
		pUser.setUserName(userForm.getUserName());
		pUser.setNameSurname(userForm.getNameSurname());
		pUser.setPassword(userForm.getPassword());
		if(user.getRole().equals("manager"))
				pUser.setRole(userForm.getRole());
		else
			session.setAttribute("user", pUser);
		hibernateSession.saveOrUpdate(pUser);
		ta.commit();
		hibernateSession.close();
		ActionMessages actionMessages = new ActionMessages();
        actionMessages.add(ActionMessages.GLOBAL_MESSAGE,
                new ActionMessage("user.added",pUser.getNameSurname()));
        saveMessages(request,actionMessages);
		return mapping.findForward("success");
	}

}
