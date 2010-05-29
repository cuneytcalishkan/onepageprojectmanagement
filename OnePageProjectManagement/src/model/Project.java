package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import controller.Utilizer;

import exception.AddElementException;
import exception.RemoveElementException;

@Entity
@Table(name = "PROJECT")
public class Project {

	private long id;
	private int sliceAmount;
	private String name;
	private Date startDate;
	private Date finishDate;
	private Puser leader;
	private String objective;
	private List<Summary> summaries;
	private List<Cost> costs;
	private List<Objective> objectives;
	private List<Puser> users;

	public Project() {
		super();
	}

	public Project(String name, Date startDate, Date finishDate, Puser leader,
			String objective) {
		super();
		this.name = name;
		this.startDate = startDate;
		this.finishDate = finishDate;
		this.leader = leader;
		this.objective = objective;
	}

	public Project(long id, String name, Date startDate, Date finishDate,
			Puser leader, String objective) {
		super();
		this.id = id;
		this.name = name;
		this.startDate = startDate;
		this.finishDate = finishDate;
		this.leader = leader;
		this.objective = objective;
	}

	@Transient
	public String getStartDateAsString() {
		return Utilizer.getDateAsString(startDate);
	}

	@Transient
	public String getFinishDateAsString() {
		return Utilizer.getDateAsString(finishDate);
	}

	@Transient
	public int getSliceQuantity() {

		int stY, fnY, stM, fnM, result;
		Calendar stCal = new GregorianCalendar();
		stCal.setTime(startDate);
		stY = stCal.get(Calendar.YEAR);
		stM = stCal.get(Calendar.MONTH) + 1;
		Calendar fnCal = new GregorianCalendar();
		fnCal.setTime(finishDate);
		fnY = fnCal.get(Calendar.YEAR);
		fnM = fnCal.get(Calendar.MONTH) + 1;

		result = (fnY - stY) * 12;
		result += fnM - stM;
		return ++result;

	}

	public void addUser(Puser usr) throws AddElementException {
		if (this.users == null)
			setUsers(new ArrayList<Puser>());
		if (!this.users.add(usr))
			throw new AddElementException("Specified user cannot be added!");
	}

	public void removeUser(Puser usr) throws RemoveElementException {
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

	@OneToMany(mappedBy = "project")
	public List<Summary> getSummaries() {
		return summaries;
	}

	public void setSummaries(List<Summary> summaries) {
		this.summaries = summaries;
	}

	@OneToMany(mappedBy = "project")
	public List<Cost> getCosts() {
		return costs;
	}

	public void setCosts(List<Cost> costs) {
		this.costs = costs;
	}

	@OneToMany(mappedBy = "project")
	public List<Objective> getObjectives() {
		return objectives;
	}

	public void setObjectives(List<Objective> objectives) {
		this.objectives = objectives;
	}

	@ManyToMany(targetEntity = Puser.class, cascade = { CascadeType.PERSIST,
			CascadeType.MERGE })
	@JoinTable(name = "WORKSON", joinColumns = @JoinColumn(name = "PROJECT_ID"), inverseJoinColumns = @JoinColumn(name = "USER_ID"))
	public List<Puser> getUsers() {
		return users;
	}

	public void setUsers(List<Puser> users) {
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

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "LEADERID")
	public Puser getLeader() {
		return leader;
	}

	public void setLeader(Puser leader) {
		this.leader = leader;
	}

	public String getObjective() {
		return objective;
	}

	public void setObjective(String objective) {
		this.objective = objective;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getSliceAmount() {
		return sliceAmount;
	}

	public void setSliceAmount(int sliceAmount) {
		this.sliceAmount = sliceAmount;
	}

}
