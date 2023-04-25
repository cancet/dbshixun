package com.example.dbshixun.service;

import com.example.dbshixun.mapper.StoreMapper;
import com.example.dbshixun.pojo.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {
    @Autowired
    private StoreMapper storeMapper;
    public List<Store> stores(){
        return storeMapper.stores();
    }
    public Store getStore(int id){
        return storeMapper.getStore(id);
    }
    public void deleteStore(int id){
        storeMapper.deleteStore(id);
    }
    public void updateStore(Store store){
        storeMapper.updateStore(store);
    }
    public void addStore(Store store){
        storeMapper.addStore(store);
    }
}
