package com.n0tnull.realmcrashandroido;

import java.util.Date;

import com.n0tnull.realmcrashandroido.SecondRealmTestObject.FieldName;
import io.realm.DynamicRealm;
import io.realm.RealmMigration;
import io.realm.RealmSchema;

public final class TestRealmMigration
    implements RealmMigration
{

  private static final long SCHEMA_VERSION_WITH_SECOND_REALM_TEST_OBJECT_ADDED = 2;

  public static final long CURRENT_SCHEMA_VERSION = SCHEMA_VERSION_WITH_SECOND_REALM_TEST_OBJECT_ADDED;

  @Override
  public void migrate(DynamicRealm realm, long oldVersion, long newVersion)
  {
    final RealmSchema realmSchema = realm.getSchema();
    if (oldVersion < SCHEMA_VERSION_WITH_SECOND_REALM_TEST_OBJECT_ADDED)
    {
      realmSchema.create(SecondRealmTestObject.class.getSimpleName())
          .addField(FieldName.field1.name(), String.class)
          .addPrimaryKey(FieldName.field1.name())
          .addField(FieldName.field2.name(), long.class)
          .addField(FieldName.field5.name(), String.class)
          .addField(FieldName.field6.name(), Date.class)
          .addField(FieldName.field7.name(), String.class)
          .addField(FieldName.field3.name(), boolean.class)
          .addField(FieldName.field4.name(), boolean.class);
    }
  }
}
