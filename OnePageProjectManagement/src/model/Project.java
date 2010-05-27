package model;

import java.util.ArrayList;
import java.util.Date;

import exception.AddElementException;
import exception.RemoveElementException;

public class Project {

	private long id;
	private String name;
	private Date startDate;
	private Date finishDate;
	private String leader;
	private String objective;
	private ArrayList<Summary> summaries;
	private ArrayList<Cost> costs;
	private ArrayList<Objective> objectives;
	private ArrayList<Users> users;

	public Project(long id, String name, Date startDate, Date finishDate,
			String leader, String objective) {
		super();
		this.id = id;
		this.name = name;
		this.startDate = startDate;
		this.finishDate = finishDate;
		this.leader = leader;
		this.objective = objective;
	}

	public void addUser(Users usr) throws AddElementException {
		if (this.users == null)
			setUsers(new ArrayList<Users>());
		if (!this.users.add(usr))
			throw new AddElementException("Specified user cannot be added!");
	}

	public void removeUser(Users usr) throws RemoveElementException {
		if (this.users.size() > 0)
			if (!this.users.remove(usr))
				throw new RemoveElementException(
						"Specified user cannot be removed!");
	}

	public void addObjective(Objective obj) throws AddElementException {
		if (this.objectives == null)
			setObjectives(new ArrayList<Objective>());
		if (!this.objectives.add(obj))
			throw new AddElementException(
					"Specified objective cannot be added!");
	}

	public void removeObjective(Objective obj) throws RemoveElementException {
		if (this.objectives.size() > 0)
			if (!this.objectives.remove(obj))
				throw new RemoveElementException(
						"Specified objective cannot be removed!");
	}

	public void addCost(Cost cs) throws AddElementException {
		if (this.costs == null)
			setCosts(new ArrayList<Cost>());
		if (!this.costs.add(cs))
			throw new AddElementException("Specified cost cannot be added!");
	}

	public void removeCost(Cost cs) throws RemoveElementException {
		if (this.costs.size() > 0)
			if (!this.costs.remove(cs))
				throw new RemoveElementException(
						"Specified cost cannot be removed!");
	}

	public void addSummary(Summary sm) throws AddElementException {
		if (this.summaries == null)
			setSummaries(new ArrayList<Summary>());
		if (!this.summaries.add(sm))
			throw new AddElementException("Specified summary cannot be added!");
	}

	public void removeSummary(Summary sm) throws RemoveElementException {
		if (this.summaries.size() > 0)
			if (!this.summaries.remove(sm))
				throw new RemoveElementException(
						"Specified summary cannot be removed!");
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

	public ArrayList<Users> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<Users> users) {
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
