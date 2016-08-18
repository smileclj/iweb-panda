package com.panda.iweb.test.guava;

import com.google.common.base.CaseFormat;
import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.base.Splitter;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;
import com.google.common.collect.*;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.google.common.hash.Hashing;
import com.google.common.io.Files;
import com.google.common.util.concurrent.*;
import com.panda.iweb.entity.Course;
import com.panda.iweb.test.guava.base.GuavaEntity;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

/**
 * Created by huixiangdou on 2016/8/5.
 */
public class GuavaTest {
    /**
     * 基本工具类
     */

    //optional
    @Test
    public void optional() {
        Optional<Integer> o = Optional.of(5);
        System.out.println(o.get());
    }

    //objects
    @Test
    public void objects() {
        GuavaEntity entity = new GuavaEntity(1, "1");
        System.out.println(Objects.hashCode(entity));
        System.out.println(java.util.Objects.hashCode(entity));
        System.out.println(entity.hashCode());
    }

    /**
     * 缓存
     */
    @Test
    public void cache() {
        Cache<String, String> cache = CacheBuilder.newBuilder()
                .maximumSize(10)
//                .expireAfterAccess(5,TimeUnit.SECONDS)
                .removalListener(new RemovalListener<String, String>() {
                    @Override
                    public void onRemoval(RemovalNotification<String, String> removalNotification) {
                        //只会在手动调用清除的时候才会触发回调，过期策略到而清除的是不会的
                        System.out.println(String.format("key:%s has removed", removalNotification.getKey()));
                    }
                }).build();
        cache.put("a", "1");
        System.out.println(cache.getIfPresent("a"));
        cache.invalidate("a"); //移出key:a
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(cache.getIfPresent("a"));
    }

    /**
     * ReteLimiter
     * <p>
     * 如果是控制并发数，可以用
     * </p>
     *
     * @param
     */
    @Test
    public void rateLimiter() {
        RateLimiter rateLimiter = RateLimiter.create(1);
        for (int i = 0; i < 10; i++) {
            long start = System.currentTimeMillis();
            System.out.println(rateLimiter.acquire());
            long end = System.currentTimeMillis();
        }
    }

    /**
     * 集合 Multiset   允许重复，但不保证有序
     */
    @Test
    public void collection_multiset() {
        Multiset<String> multiset = HashMultiset.create();
        multiset.add("a");
        multiset.add("b");
        multiset.add("b");

        System.out.println(multiset.count("a"));
        System.out.println(multiset.count("b"));

        for (String s : multiset) {
            System.out.print(s + " | ");
        }

        System.out.println();

        Iterator<String> it = multiset.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " | ");
        }

        System.out.println();
    }

    /**
     * 集合 Multimap
     */
    @Test
    public void collection_multimap() {
        Multimap<String, String> multimap = HashMultimap.create();
        multimap.put("a", "1");
        List<String> list = new ArrayList<>();
        list.add("2");
        list.add("3");
        multimap.putAll("b", list);

        System.out.println(multimap.size());
        System.out.println(multimap.keys());

        for (Map.Entry<String, String> entry : multimap.entries()) {
            System.out.print(entry.getKey() + ":" + entry.getValue());
        }
    }

    /**
     * 集合 BiMap
     */
    @Test
    public void collection_bimap() {
        //要求value的唯一性，但可以通过forcePut来覆盖
        BiMap<String, Integer> biMap = HashBiMap.create();
        biMap.put("a", 1);
        biMap.put("b", 2);
        biMap.forcePut("c", 2);
        BiMap<Integer, String> inverseMap = biMap.inverse();
        for (Map.Entry<Integer, String> entry : inverseMap.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    /**
     * 并发
     * ListenableFuture
     *
     * @param args
     */
    @Test
    public void ListenableFuture() {
        ListeningExecutorService pool = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));
        ListenableFuture listenableFuture = pool.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("lala");
                return 1;
            }
        });
        Futures.addCallback(listenableFuture, new FutureCallback() {
            @Override
            public void onSuccess(Object result) {
                System.out.println("success");
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println("fail");
            }
        });
    }

    @Test
    public void joiner() {
        System.out.println(Joiner.on("|").skipNulls().join("1", "2", null, 4, new Course()));
    }

    @Test
    public void splitter1() {
        String[] ss = ",a,,b,".split(",");
        for (String s : ss) {
            System.out.println("值:" + s);
        }
    }

    @Test
    public void splitter2() {
        String pass = "1234567887654321";
        System.out.println(Joiner.on(",").join(Splitter.fixedLength(4).trimResults().omitEmptyStrings().splitToList(pass)));
    }

    @Test
    public void CaseFormat() {
        System.out.println(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "a_b"));
    }

    /**
     * 判断随机落点的时候可以用这个使代码更简洁
     */
    @Test
    public void range() {
        System.out.println(Range.closed(1, 2).contains(2));
    }

    @Test
    public void io() {
        String path = Course.class.getResource("/test.txt").getPath();
        System.out.println(path);
        File file = new File(path);
        try {
            BufferedReader reader = Files.newReader(file, Charset.forName("utf-8"));
            System.out.println(reader.readLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void hashing() {
        System.out.println(Hashing.md5().hashString("123456", Charset.forName("utf-8")));


        // 0-3
        System.out.println(Hashing.consistentHash(1l, 4));
        System.out.println(Hashing.consistentHash(2l, 4));
        System.out.println(Hashing.consistentHash(3l, 4));
        System.out.println(Hashing.consistentHash(4l, 4));
        System.out.println(Hashing.consistentHash(5l, 4));
        System.out.println(Hashing.consistentHash(6l, 4));
        System.out.println(Hashing.consistentHash(1l, 4));
    }

    @Test
    public void eventbus() {
        class EventListener {
            @Subscribe
            public void listen(String msg) {
                System.out.println("接收消息:" + msg);
            }
        }

        EventBus eventBus = new EventBus("test"); //topic test
        eventBus.register(new EventListener());
        eventBus.post("2");
    }

    public static void main(String[] args) {

    }
}
