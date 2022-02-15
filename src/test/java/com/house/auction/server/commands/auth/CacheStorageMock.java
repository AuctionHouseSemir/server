package com.house.auction.server.commands.auth;

import com.house.auction.server.cache.CacheItem;
import com.house.auction.server.cache.CacheStorage;

public class CacheStorageMock implements CacheStorage {
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
