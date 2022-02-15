package com.house.auction.server.adapters;

import com.house.auction.server.cache.CacheItem;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CacheStorageAdapterTests {
    private CacheStorageAdapter cacheStorageAdapter;

    @Before
    public void setup() {
        cacheStorageAdapter = new CacheStorageAdapter();
    }

    @Test
    public void storeAndGet() {
        cacheStorageAdapter.store("item_key", "item_value");

        CacheItem cacheItem = cacheStorageAdapter.get("item_key");
        Assert.assertNotNull(cacheItem);
        Assert.assertEquals("item_key", cacheItem.getKey());
        Assert.assertEquals("item_value", cacheItem.getValue());
    }

    @Test
    public void destroy() {
        cacheStorageAdapter.store("item_key", "item_value");

        cacheStorageAdapter.destroy("item_key");

        CacheItem cacheItem = cacheStorageAdapter.get("item_key");
        Assert.assertNull(cacheItem);
    }

    @Test
    public void get_KeyNotExists_ReturnsNull() {
        CacheItem cacheItem = cacheStorageAdapter.get("no_key");
        Assert.assertNull(cacheItem);
    }
}
