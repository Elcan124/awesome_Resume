/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.sql.Date;

public class EmploymentHistory {

    private Integer id ;
    private String header;
    private Date beginDate;
    private Date endDate;
    private String jobDescripton;
    private User user ;
public EmploymentHistory(){

}

    public EmploymentHistory(Integer id, String header, Date beginDate, Date endDate, String jobDescripton, User user) {
        this.id = id;
        this.header = header;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.jobDescripton = jobDescripton;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getJobDescripton() {
        return jobDescripton;
    }

    public void setJobDescripton(String jobDescripton) {
        this.jobDescripton = jobDescripton;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "EmploymentHistory{" +
                "id=" + id +
                ", header='" + header + '\'' +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", jobDescripton='" + jobDescripton + '\'' +
                ", user=" + user +
                '}';
    }
}
