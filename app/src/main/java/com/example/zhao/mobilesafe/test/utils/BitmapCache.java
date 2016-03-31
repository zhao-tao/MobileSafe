package com.example.zhao.mobilesafe.test.utils;

import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.toolbox.ImageLoader.ImageCache;

/**
 * BitmapCache实现volley中的ImageCache，用在Volley的ImageLoader中
 * <p/>
 * Created by zhao on 2016/3/31.
 */
public class BitmapCache implements ImageCache {

    private final LruCache<String, Bitmap> mCache;

    public BitmapCache() {
        int maxSize = 10 * 1024 * 1024;
        mCache = new LruCache<String, Bitmap>(maxSize) {
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes() * value.getHeight();
            }
        };
    }

    /**
     * 根据url获取图片
     *
     * @param url
     * @return
     */
    @Override
    public Bitmap getBitmap(String url) {
        return mCache.get(url);
    }

    /**
     * 给mCache里根据url对应的bitmap存入缓存
     *
     * @param url
     * @param bitmap
     */
    @Override
    public void putBitmap(String url, Bitmap bitmap) {
        mCache.put(url, bitmap);
    }
}
