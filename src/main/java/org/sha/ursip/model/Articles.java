package org.sha.ursip.model;


public class Articles {

  private long id;
  private String name;
  private long typeid;

  public Articles() {
  }

  public Articles(long id, String name, long typeid) {
    this.id = id;
    this.name = name;
    this.typeid = typeid;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public long getTypeid() {
    return typeid;
  }

  public void setTypeid(long typeid) {
    this.typeid = typeid;
  }

}
