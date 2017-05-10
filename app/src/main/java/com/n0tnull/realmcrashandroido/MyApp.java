package com.n0tnull.realmcrashandroido;

import java.io.File;

import android.app.Application;
import android.os.Build;
import android.os.Build.VERSION_CODES;
import android.util.Log;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.log.RealmLog;
import io.realm.log.RealmLogger;

public class MyApp
    extends Application
{

  @Override
  public void onCreate()
  {
    super.onCreate();

    final String userDataDirectoryPath;
    final File externalFilesDir = getExternalFilesDir(null);
    if (externalFilesDir == null || Build.VERSION.SDK_INT < VERSION_CODES.LOLLIPOP_MR1)
    {
      userDataDirectoryPath = getFilesDir().getAbsolutePath();
    }
    else
    {
      userDataDirectoryPath = externalFilesDir.getAbsolutePath();
    }

    Log.d(MyApp.class.getName(), "RealmLog We are going to save Realm files here : " + userDataDirectoryPath);

    Realm.init(this);
    RealmLog.setLevel(Log.VERBOSE);
    RealmLog.add(new RealmLogger()
    {
      @Override
      public void log(int level, String tag, Throwable throwable, String message)
      {
        Log.w(tag, "RealmLog message=" + message, throwable);
      }
    });
    final RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
        .directory(new File(userDataDirectoryPath))
        .schemaVersion(TestRealmMigration.CURRENT_SCHEMA_VERSION)
        .migration(new TestRealmMigration())
        .build();
    Realm.setDefaultConfiguration(realmConfiguration);
  }

}
