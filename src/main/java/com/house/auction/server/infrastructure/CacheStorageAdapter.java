package com.house.auction.server.infrastructure;

import com.house.auction.server.cache.CacheItem;
import com.house.auction.server.cache.CacheStorage;
import org.springframework.stereotype.Service;

@Service
public class CacheStorageAdapter implements CacheStorage {
    @Override
    public void store(CacheItem cacheItem) {

    }

    @Override
    public CacheItem get(String key) {
        return null;
    }

    @Override
    public void destroy(String key) {

    }
}
