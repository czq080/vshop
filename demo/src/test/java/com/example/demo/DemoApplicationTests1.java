package com.example.demo;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.UUID;

public class DemoApplicationTests1 {

    private static MurmurHash murmurHash = new MurmurHash();

    /**
     * 待添加入Hash环的服务器列表
     */
    private static String[] servers = {"doctor11", "doctor12", "doctor13",
            "doctor14", "doctor15"};
    private TreeMap<Long, String> nodes;

    private void initialize(String[] shards) {
        nodes = new TreeMap<>();
        for (int i = 0; i != shards.length; ++i) {
            final String shardInfo = shards[i];
            for (int n = 0; n < 160 * 1; n++) {
                nodes.put(murmurHash.hash(shardInfo + "*" + 1 + n), shardInfo);
            }
        }
    }

    /**
     * 使用FNV1_32_HASH算法计算服务器的Hash值,这里不使用重写hashCode的方法，最终效果没区别
     */
    private long getHash(String key) {
        return murmurHash.hash(key);
    }

    /**
     * 得到应当路由到的结点
     */
    private String getServer(String key) {
        SortedMap<Long, String> tail = nodes.tailMap(getHash(key));
        if (tail.isEmpty()) {
            return nodes.get(nodes.firstKey());
        }
        return tail.get(tail.firstKey());
    }


    @Test
    public void contextLoads() {
        initialize(servers);
        String[] nodes1 = new String[100];
        for (int i = 0; i < 100; i++) {
            nodes1[i] = UUID.randomUUID().toString().replace("-", "");
            System.out.println("添加节点>>>" + nodes1[i]);
        }
        for (int i = 0; i < nodes1.length; i++) {
            System.out.print("[" + nodes1[i] + "]的hash值为" + murmurHash.hash(nodes1[i]));
            System.out.println(", 被路由到结点[" + getServer(nodes1[i]) + "]");
        }
    }


    public static class MurmurHash {
        /**
         * Hashes bytes in an array.
         *
         * @param data The bytes to hash.
         * @param seed The seed for the hash.
         * @return The 32 bit hash of the bytes in question.
         */
        public static int hash(byte[] data, int seed) {
            return hash(ByteBuffer.wrap(data), seed);
        }

        /**
         * Hashes bytes in part of an array.
         *
         * @param data   The data to hash.
         * @param offset Where to start munging.
         * @param length How many bytes to process.
         * @param seed   The seed to start with.
         * @return The 32-bit hash of the data in question.
         */
        public static int hash(byte[] data, int offset, int length, int seed) {
            return hash(ByteBuffer.wrap(data, offset, length), seed);
        }

        /**
         * Hashes the bytes in a buffer from the current position to the limit.
         *
         * @param buf  The bytes to hash.
         * @param seed The seed for the hash.
         * @return The 32 bit murmur hash of the bytes in the buffer.
         */
        public static int hash(ByteBuffer buf, int seed) {
            // save byte order for later restoration
            ByteOrder byteOrder = buf.order();
            buf.order(ByteOrder.LITTLE_ENDIAN);

            int m = 0x5bd1e995;
            int r = 24;

            int h = seed ^ buf.remaining();

            int k;
            while (buf.remaining() >= 4) {
                k = buf.getInt();

                k *= m;
                k ^= k >>> r;
                k *= m;

                h *= m;
                h ^= k;
            }

            if (buf.remaining() > 0) {
                ByteBuffer finish = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
                // for big-endian version, use this first:
                // finish.position(4-buf.remaining());
                finish.put(buf).rewind();
                h ^= finish.getInt();
                h *= m;
            }

            h ^= h >>> 13;
            h *= m;
            h ^= h >>> 15;

            buf.order(byteOrder);
            return h;
        }

        public static long hash64A(byte[] data, int seed) {
            return hash64A(ByteBuffer.wrap(data), seed);
        }

        public static long hash64A(byte[] data, int offset, int length, int seed) {
            return hash64A(ByteBuffer.wrap(data, offset, length), seed);
        }

        public static long hash64A(ByteBuffer buf, int seed) {
            ByteOrder byteOrder = buf.order();
            buf.order(ByteOrder.LITTLE_ENDIAN);

            long m = 0xc6a4a7935bd1e995L;
            int r = 47;

            long h = seed ^ (buf.remaining() * m);

            long k;
            while (buf.remaining() >= 8) {
                k = buf.getLong();

                k *= m;
                k ^= k >>> r;
                k *= m;

                h ^= k;
                h *= m;
            }

            if (buf.remaining() > 0) {
                ByteBuffer finish = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN);
                // for big-endian version, do this first:
                // finish.position(8-buf.remaining());
                finish.put(buf).rewind();
                h ^= finish.getLong();
                h *= m;
            }

            h ^= h >>> r;
            h *= m;
            h ^= h >>> r;

            buf.order(byteOrder);
            return h;
        }

        public long hash(byte[] key) {
            return hash64A(key, 0x1234ABCD);
        }

        public long hash(String key) {
            return hash(encode(key));
        }

        private byte[] encode(String data) {
            try {
                return data.getBytes("utf-8");
            } catch (UnsupportedEncodingException e) {
                throw new IllegalArgumentException(e);
            }
        }
    }

}
