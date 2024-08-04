package com.example.mypraticeapplication.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.mypraticeapplication.model.getUserProfileData.GetUserProfileData;
import com.example.mypraticeapplication.model.getmasterData.GetMasterApiData;
import com.example.mypraticeapplication.room.dao.MasterDataDao;

@Database(entities = {GetMasterApiData.class}, version = 2, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract MasterDataDao getMasterData();

    private static volatile AppDatabase INSTANCE;

    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    AppDatabase.class, DbConfig.ROOM_DB_NAME)
                            //.addMigrations(AppDatabase.MIGRATION_1_2)  // Add your migration(s)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
