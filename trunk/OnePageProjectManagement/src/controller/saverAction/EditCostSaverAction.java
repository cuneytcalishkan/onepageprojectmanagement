package controller.saverAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cost;
import model.Project;
import model.Puser;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Session;
import org.hibernate.Transaction;

import controller.HibernateUtil;
import controller.form.CostForm;
import exception.AddElementException;

public class EditCostSaverAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession(true);
		CostForm costForm = (CostForm) form;
		Puser user = (Puser) session.getAttribute("user");
		if (user == null || (!user.getRole().equals("project manager"))) {
			throw new RuntimeException(
					"You are not authorized to execute this action.");
		}
		Session hibernateSession = HibernateUtil.getSession();
		Transaction ta = hibernateSession.beginTransaction();
		Long id = costForm.getId();
		Cost cost;
		if (id != null && id != 0)
			cost = (Cost) hibernateSession.get(Cost.class, id);
		else
			cost = new Cost();

		Project project = (Project) hibernateSession.get(Project.class,
				costForm.getProjectId());

		cost.setColor(costForm.getColor());
		cost.setBudget(costForm.getBudget());
		cost.setExpense(costForm.getExpense());
		cost.setName(costForm.getName());
		cost.setProject(project);
		try {
			project.addCost(cost);
		} catch (AddElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		hibernateSession.saveOrUpdate(project);
		hibernateSession.saveOrUpdate(cost);
		ta.commit();
		hibernateSession.close();
		return mapping.findForward("success");
	}

}
