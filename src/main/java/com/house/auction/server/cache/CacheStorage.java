package com.house.auction.server.cache;

public interface CacheStorage {
    void store(CacheItem cacheItem);
    CacheItem get(String key);
    void destroy(String key);
}
