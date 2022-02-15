package com.house.auction.server.adapters;

import com.house.auction.server.cache.CacheItem;
import com.house.auction.server.cache.CacheStorage;
import org.springframework.stereotype.Service;

@Service
public class CacheStorageAdapter implements CacheStorage {
    @Override
    public void store(String key, String value) {

    }

    @Override
    public CacheItem get(String key) {
        return null;
    }

    @Override
    public void destroy(String key) {

    }
}
