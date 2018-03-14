package com.qualapps.ka.display;

import org.ocpsoft.prettytime.PrettyTime;
import org.thymeleaf.util.DateUtils;

import java.util.Date;
import java.util.List;

public class Article {
  private long id;
  private String title;
  private String summary;
  private Date changed;
  private String changeUser;
  private String category;
  private List<String> tags;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }

  public Date getChanged() {
    return changed;
  }

  public String getRelativeChanged() {
    PrettyTime p = new PrettyTime();
    return p.format(changed);
  }

  public void setChanged(Date changed) {
    this.changed = changed;
  }

  public String getChangeUser() {
    return changeUser;
  }

  public void setChangeUser(String changeUser) {
    this.changeUser = changeUser;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public List<String> getTags() {
    return tags;
  }

  public void setTags(List<String> tags) {
    this.tags = tags;
  }
}
