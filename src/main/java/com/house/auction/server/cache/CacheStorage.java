package com.house.auction.server.cache;

public interface CacheStorage {
    void store(String key, String value);
    CacheItem get(String key);
    void destroy(String key);
}
