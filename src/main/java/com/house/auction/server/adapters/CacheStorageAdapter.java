package com.house.auction.server.adapters;

import com.house.auction.server.cache.CacheItem;
import com.house.auction.server.cache.CacheStorage;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class CacheStorageAdapter implements CacheStorage {
    private final ConcurrentHashMap<String, String> storage;

    public CacheStorageAdapter() {
        this.storage = new ConcurrentHashMap<>();
    }

    @Override
    public void store(String key, String value) {
        this.storage.put(key, value);
    }

    @Override
    public CacheItem get(String key) {
        String value = storage.get(key);
        if (value == null) return null;

        CacheItem cacheItem = new CacheItem();
        cacheItem.setKey(key);
        cacheItem.setValue(value);

        return cacheItem;
    }

    @Override
    public void destroy(String key) {
        storage.remove(key);
    }
}
