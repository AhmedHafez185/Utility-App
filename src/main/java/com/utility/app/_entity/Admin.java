package com.utility.app._entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Table(name = "ADMIN")
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "adm_no")
    private Integer admNo;
    @Basic(optional = false)
    @Column(name = "adm_name")
    private String admName;
    @Basic(optional = false)
    @Column(name = "adm_code")
    private String admCode;
    @Basic(optional = false)
    @Column(name = "adm_role_type")
    private String admRoleType;
    @Basic(optional = false)
    @Column(name = "adm_password")
    private String admPassword;
    @Column(name = "adm_pic")
    private String admPic;
    @Basic(optional = false)
    @Column(name = "in_active")
    private short inActive;
    @Basic(optional = false)
    @Column(name = "create_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createOn;
    @Column(name = "inactiv_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date inactivDate;

    public Integer getAdmNo() {
        return admNo;
    }

    public void setAdmNo(Integer admNo) {
        this.admNo = admNo;
    }

    public String getAdmName() {
        return admName;
    }

    public void setAdmName(String admName) {
        this.admName = admName;
    }

    public String getAdmCode() {
        return admCode;
    }

    public void setAdmCode(String admCode) {
        this.admCode = admCode;
    }

    public String getAdmRoleType() {
        return admRoleType;
    }

    public void setAdmRoleType(String admRoleType) {
        this.admRoleType = admRoleType;
    }

    public String getAdmPassword() {
        return admPassword;
    }

    public void setAdmPassword(String admPassword) {
        this.admPassword = admPassword;
    }

    public String getAdmPic() {
        return admPic;
    }

    public void setAdmPic(String admPic) {
        this.admPic = admPic;
    }

    public short getInActive() {
        return inActive;
    }

    public void setInActive(short inActive) {
        this.inActive = inActive;
    }

    public Date getCreateOn() {
        return createOn;
    }

    public void setCreateOn(Date createOn) {
        this.createOn = createOn;
    }

    public Date getInactivDate() {
        return inactivDate;
    }

    public void setInactivDate(Date inactivDate) {
        this.inactivDate = inactivDate;
    }
}
