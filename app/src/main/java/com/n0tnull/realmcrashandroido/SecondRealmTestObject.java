package com.n0tnull.realmcrashandroido;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class SecondRealmTestObject
    extends RealmObject
{

  public enum FieldName
  {
    field1,
    field2,
    field3,
    field4,
    field5,
    field6,
    field7
  }

  @Required
  @PrimaryKey
  private String field1;

  private long field2;

  private boolean field3;

  private boolean field4;

  private String field5;

  private Date field6;

  private String field7;
  
  public String getField1()
  {
    return field1;
  }

  public void setField1(String field1)
  {
    this.field1 = field1;
  }

  public long getField2()
  {
    return field2;
  }

  public void setField2(long field2)
  {
    this.field2 = field2;
  }

  public boolean isField3()
  {
    return field3;
  }

  public void setField3(boolean field3)
  {
    this.field3 = field3;
  }

  public boolean isField4()
  {
    return field4;
  }

  public void setField4(boolean field4)
  {
    this.field4 = field4;
  }

  public String getField5()
  {
    return field5;
  }

  public void setField5(String field5)
  {
    this.field5 = field5;
  }

  public Date getField6()
  {
    return field6;
  }

  public void setField6(Date field6)
  {
    this.field6 = field6;
  }

  public String getField7()
  {
    return field7;
  }

  public void setField7(String field7)
  {
    this.field7 = field7;
  }
}
