package fr.formation.inti.entities;
// Generated 5 sept. 2019 14:30:50 by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * MatchOfZeDay generated by hbm2java
 */
@Entity
@Table(name = "match_of_ze_day", catalog = "championschallengeproject")
public class MatchOfZeDay implements java.io.Serializable {

	private int idMatchOfTheDay;
	private Integer matchDay;
	private Set<StatsPlayers> statsPlayerses = new HashSet<StatsPlayers>(0);
	private Set<ResultsUsers> resultsUserses = new HashSet<ResultsUsers>(0);

	public MatchOfZeDay() {
	}

	public MatchOfZeDay(int idMatchOfTheDay) {
		this.idMatchOfTheDay = idMatchOfTheDay;
	}

	public MatchOfZeDay(int idMatchOfTheDay, Integer matchDay, Set<StatsPlayers> statsPlayerses,
			Set<ResultsUsers> resultsUserses) {
		this.idMatchOfTheDay = idMatchOfTheDay;
		this.matchDay = matchDay;
		this.statsPlayerses = statsPlayerses;
		this.resultsUserses = resultsUserses;
	}

	@Id

	@Column(name = "id_match_of_the_day", unique = true, nullable = false)
	public int getIdMatchOfTheDay() {
		return this.idMatchOfTheDay;
	}

	public void setIdMatchOfTheDay(int idMatchOfTheDay) {
		this.idMatchOfTheDay = idMatchOfTheDay;
	}

	@Column(name = "matchDay")
	public Integer getMatchDay() {
		return this.matchDay;
	}

	public void setMatchDay(Integer matchDay) {
		this.matchDay = matchDay;
	}


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "matchOfZeDay")
	public Set<StatsPlayers> getStatsPlayerses() {
		return this.statsPlayerses;
	}

	public void setStatsPlayerses(Set<StatsPlayers> statsPlayerses) {
		this.statsPlayerses = statsPlayerses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "matchOfZeDay")
	public Set<ResultsUsers> getResultsUserses() {
		return this.resultsUserses;
	}

	public void setResultsUserses(Set<ResultsUsers> resultsUserses) {
		this.resultsUserses = resultsUserses;
	}

}
