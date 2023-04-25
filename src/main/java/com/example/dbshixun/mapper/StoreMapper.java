package com.example.dbshixun.mapper;

import com.example.dbshixun.pojo.Store;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StoreMapper {
    List<Store>stores();
    Store getStore(int id);
    void deleteStore(int id);
    void updateStore(Store store);
    void addStore(Store store);
}
