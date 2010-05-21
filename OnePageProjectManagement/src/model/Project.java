package model;

import java.util.ArrayList;
import java.util.Date;

public class Project {

	private String name;
	private Date startDate;
	private Date finishDate;
	private String leader;
	private String objective;
	private ArrayList<Summary> summaries;
	private ArrayList<Cost> costs;
	private ArrayList<Objective> objectives;
	private ArrayList<User> users;

	public Project(String name, Date startDate, Date finishDate, String leader,
			String objective) {
		super();
		this.name = name;
		this.startDate = startDate;
		this.finishDate = finishDate;
		this.leader = leader;
		this.objective = objective;
	}

	public void addUser(User usr) {
		if (this.users == null)
			setUsers(new ArrayList<User>());
		this.users.add(usr);
	}

	public void removeUser(User usr) {
		if (this.users.size() > 0)
			this.users.remove(usr);
	}

	public void addObjective(Objective obj) {
		if (this.objectives == null)
			setObjectives(new ArrayList<Objective>());
		this.objectives.add(obj);
	}

	public void removeObjective(Objective obj) {
		if (this.objectives.size() > 0)
			this.objectives.remove(obj);
	}

	public void addCost(Cost cs) {
		if (this.costs == null)
			setCosts(new ArrayList<Cost>());
		this.costs.add(cs);
	}

	public void removeCost(Cost cs) {
		if (this.costs.size() > 0)
			this.costs.remove(cs);
	}

	public void addSummary(Summary sm) {
		if (this.summaries == null)
			setSummaries(new ArrayList<Summary>());
		this.summaries.add(sm);
	}

	public void removeSummary(Summary sm) {
		if (this.summaries.size() > 0)
			this.summaries.remove(sm);
	}

	public ArrayList<Summary> getSummaries() {
		return summaries;
	}

	public void setSummaries(ArrayList<Summary> summaries) {
		this.summaries = summaries;
	}

	public ArrayList<Cost> getCosts() {
		return costs;
	}

	public void setCosts(ArrayList<Cost> costs) {
		this.costs = costs;
	}

	public ArrayList<Objective> getObjectives() {
		return objectives;
	}

	public void setObjectives(ArrayList<Objective> objectives) {
		this.objectives = objectives;
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}

	public String getLeader() {
		return leader;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}

	public String getObjective() {
		return objective;
	}

	public void setObjective(String objective) {
		this.objective = objective;
	}

}
