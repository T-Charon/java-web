package com.blb.springboot.entity;


public class LGoods {

  private long id;
  private String name;
  private String type;
  private String weight;


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


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  public String getWeight() {
    return weight;
  }

  public void setWeight(String weight) {
    this.weight = weight;
  }

}
