package com.example.mypraticeapplication.room.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.mypraticeapplication.model.getmasterData.GetMasterApiData;
import com.example.mypraticeapplication.room.DbConfig;

import java.util.List;

@Dao
public interface MasterDataDao {
    @Insert
    void insert(GetMasterApiData user);

    @Update
    void update(GetMasterApiData user);

    @Delete
    void delete(GetMasterApiData user);

    @Query("Select sd.displayText from master_data_table AS sd WHERE KeyName = :keyName  ORDER BY SrNo DESC")
    List<String>  getDataByKeyName(String keyName);

    @Query("Select * from master_data_table")
    List<GetMasterApiData>  getMasterDataList();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<GetMasterApiData> masterList);
}
