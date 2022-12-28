package com.utility.app._dtos;


import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class AdminDTO {
    private Integer admNo;
    @NotBlank(message = "admin name must be entered")
    @Length(min = 5, message = "min admin name length is 5 characters")
    private String admName;
  @NotBlank(message = "1-admCode")
    @Length(min = 5, message = "18-admCode")
    private String admCode;
    //   @Min(value = 1, message = "14-admRoleType")
//    @NotBlank(message = "1-admCode")
    private String admRoleType;
    private String admRoleTypeDsc;
//    @NotBlank(message = "1-password")
//    @Length(min = 8, message = "13-password")
    private String admPassword;
//    @NotBlank(message = "1-confirmPassword")
//    @Length(min = 8, message = "7-confirmPassword")
    private String confirmAdmPassword;
    private String admPic;
    private Short inActive;
    private Date createOn;
    private Date inactivDate;
    private String oldPassword;

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

    public String getAdmRoleTypeDsc() {
        return admRoleTypeDsc;
    }

    public void setAdmRoleTypeDsc(String admRoleTypeDsc) {
        this.admRoleTypeDsc = admRoleTypeDsc;
    }

    public String getAdmPassword() {
        return admPassword;
    }

    public void setAdmPassword(String admPassword) {
        this.admPassword = admPassword;
    }

    public String getConfirmAdmPassword() {
        return confirmAdmPassword;
    }

    public void setConfirmAdmPassword(String confirmAdmPassword) {
        this.confirmAdmPassword = confirmAdmPassword;
    }

    public String getAdmPic() {
        return admPic;
    }

    public void setAdmPic(String admPic) {
        this.admPic = admPic;
    }

    public Short getInActive() {
        return inActive;
    }

    public void setInActive(Short inActive) {
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

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }
}

