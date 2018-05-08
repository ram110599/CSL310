/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author abhi
 */
@Entity
@Table(name = "team_member")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TeamMember.findAll", query = "SELECT t FROM TeamMember t")
    , @NamedQuery(name = "TeamMember.findByMemberId", query = "SELECT t FROM TeamMember t WHERE t.memberId = :memberId")
    , @NamedQuery(name = "TeamMember.findBySalary", query = "SELECT t FROM TeamMember t WHERE t.salary = :salary")
    , @NamedQuery(name = "TeamMember.findByHireDate", query = "SELECT t FROM TeamMember t WHERE t.hireDate = :hireDate")
    , @NamedQuery(name = "TeamMember.findByRole", query = "SELECT t FROM TeamMember t WHERE t.role = :role")
    , @NamedQuery(name = "TeamMember.findByRemarks", query = "SELECT t FROM TeamMember t WHERE t.remarks = :remarks")
    , @NamedQuery(name = "TeamMember.query3", query = "SELECT AVG(tm.salary) FROM TeamMember tm WHERE tm.role = 'Player' and tm.personId.personId IN (SELECT p.personId FROM Person p WHERE p.contactId.contactId IN (SELECT c.contactId from Contact c where c.state = :name))")
    , @NamedQuery(name = "TeamMember.findAllByRolewise", query = "SELECT COUNT(t.personId), t.role FROM TeamMember t WHERE t.teamId = (SELECT tm.teamId FROM Team tm where tm.name = :name)  GROUP BY t.role")})
public class TeamMember implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "member_id")
    private Integer memberId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "salary")
    private Double salary;
    @Basic(optional = false)
    @Column(name = "hire_date")
    @Temporal(TemporalType.DATE)
    private Date hireDate;
    @Column(name = "role")
    private String role;
    @Column(name = "remarks")
    private String remarks;
    @JoinColumn(name = "team_id", referencedColumnName = "team_id")
    @ManyToOne
    private Team teamId;
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    @ManyToOne
    private Person personId;

    public TeamMember() {
    }

    public TeamMember(Integer memberId) {
        this.memberId = memberId;
    }

    public TeamMember(Integer memberId, Date hireDate) {
        this.memberId = memberId;
        this.hireDate = hireDate;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Team getTeamId() {
        return teamId;
    }

    public void setTeamId(Team teamId) {
        this.teamId = teamId;
    }

    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (memberId != null ? memberId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TeamMember)) {
            return false;
        }
        TeamMember other = (TeamMember) object;
        if ((this.memberId == null && other.memberId != null) || (this.memberId != null && !this.memberId.equals(other.memberId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lab.TeamMember[ memberId=" + memberId + " ]";
    }
    
}
