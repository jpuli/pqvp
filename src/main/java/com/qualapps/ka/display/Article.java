package com.qualapps.ka.display;

import com.qualapps.ka.common.PqvpException;
import com.qualapps.ka.data.ArticleData;
import com.qualapps.ka.data.UserProfileData;
import com.qualapps.ka.service.UserProfileService;
import org.ocpsoft.prettytime.PrettyTime;
import org.thymeleaf.util.DateUtils;
import org.thymeleaf.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Article {
  private long id;
  private String title;
  private String summary;
  private String content;
  private Date changed;
  private String creator;
  private String category;
  private List<String> tags;
  private String status;

  public Article(ArticleData articleData, UserProfileService userProfileService) {
    this.setId(articleData.getArtId());
    this.setTitle(articleData.getArtTile());
    this.setChanged(articleData.getChngDate());
    this.setTags(articleData.getArtTags());
    this.setStatus(articleData.getArtStatus());
    long userProfileId = Long.parseLong(articleData.getArtCreator());
    try {
      UserProfileData user = userProfileService.getUserById(userProfileId);
      this.setCreator(user.getUsrName());
    } catch (PqvpException e) {
      e.printStackTrace();
      this.setCreator("admin");
    }
    int maxForSummary = (300 > articleData.getArtContent().length()) ? articleData.getArtContent().length() : 300;
    this.setSummary(articleData.getArtContent().substring(0, maxForSummary) + "...");
    this.setContent(articleData.getArtContent());
    //this.setCategory(StringUtils.capitalize(pqvpdao.getCategory(articleData.getCatId()).getCatName()));
  }

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

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
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

  public String getCreator() {
    return creator;
  }

  public void setCreator(String creator) {
    this.creator = creator;
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

  public void setTags(String tagsString) {
    List<String> tags  = new ArrayList<>();
    for (String tag : tagsString.split(",") ) {
      if (!StringUtils.isEmptyOrWhitespace(tag)) {
        tags.add(tag.trim());
      }
    }
    this.tags = tags;
  }

  public String getStatus() {
    return StringUtils.capitalize(status.toLowerCase());
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
