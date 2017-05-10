package com.n0tnull.realmcrashandroido;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import io.realm.Realm;
import io.realm.Realm.Transaction;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class FirstTestRealmObject
    extends RealmObject
{

  enum FieldName
  {
    myPrimaryKey,
    anotherField
  }

  public static void saveTestObject(@NonNull final String myPrimaryKey, @Nullable final String anotherField)
  {
    if (TextUtils.isEmpty(myPrimaryKey))
    {
      return;
    }

    final Realm realmInstance = Realm.getDefaultInstance();
    realmInstance.executeTransaction(new Transaction()
    {
      @Override
      public void execute(Realm realm)
      {
        final FirstTestRealmObject testRealmObject = new FirstTestRealmObject();
        testRealmObject.setMyPrimaryKey(myPrimaryKey);
        testRealmObject.setAnotherField(anotherField);
        realm.insertOrUpdate(testRealmObject);
      }
    });
    realmInstance.close();
  }

  public static boolean isTestObjectPresent(@Nullable final String primaryKey)
  {
    if (TextUtils.isEmpty(primaryKey))
    {
      return false;
    }

    final Realm realmInstance = Realm.getDefaultInstance();
    final long count = realmInstance.where(FirstTestRealmObject.class)
        .equalTo(FieldName.myPrimaryKey.name(), primaryKey)
        .count();
    realmInstance.close();

    return count > 0;
  }

  @Required
  @PrimaryKey
  private String myPrimaryKey;

  private String anotherField;

  public String getMyPrimaryKey()
  {
    return myPrimaryKey;
  }

  public void setMyPrimaryKey(String myPrimaryKey)
  {
    this.myPrimaryKey = myPrimaryKey;
  }

  public String getAnotherField()
  {
    return anotherField;
  }

  public void setAnotherField(String anotherField)
  {
    this.anotherField = anotherField;
  }
}
