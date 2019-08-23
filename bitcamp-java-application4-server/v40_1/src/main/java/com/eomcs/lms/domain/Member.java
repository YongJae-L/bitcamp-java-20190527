package com.eomcs.lms.domain;

import java.io.Serializable;
import java.sql.Date;

public class Member implements Serializable {

  private static final long serialVersionUID = 1L;

  private int no;
  private String name;
  private String email;
  private String password;
  private String photo;
  private String tel;
  private Date resisteredDate;

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String pw) {
    this.password = pw;
  }

  public String getPhoto() {
    return photo;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public Date getResisteredDate() {
    return resisteredDate;
  }

  public void setResisteredDate(Date resisteredDate) {
    this.resisteredDate = resisteredDate;
  }

}
