package com.example.demo;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.*;

public class DemoApplicationTests {

    private static MurmurHash murmurHash = new MurmurHash();

    /**
     * 待添加入Hash环的服务器列表
     */
    private static String[] servers = {"doctor11", "doctor12", "doctor13",
            "doctor14", "doctor15"};

    /**
     * 真实结点列表,考虑到服务器上线、下线的场景，即添加、删除的场景会比较频繁，这里使用LinkedList会更好
     */
    private static List<String> realNodes = new LinkedList<>();

    /**
     * 虚拟节点，key表示虚拟节点的hash值，value表示虚拟节点的名称
     */
    private static SortedMap<Integer, String> virtualNodes =
            new TreeMap<>();

    /**
     * 虚拟节点的数目，这里写死，为了演示需要，一个真实结点对应5个虚拟节点
     */
    private static final int VIRTUAL_NODES = 160;

    static {
        // 先把原始的服务器添加到真实结点列表中
        for (int i = 0; i < servers.length; i++)
            realNodes.add(servers[i]);

        // 再添加虚拟节点，遍历LinkedList使用foreach循环效率会比较高
        for (String str : realNodes) {
            Integer weight = null;
            if(str.equals("doctor11")){
                weight = 100;
            }else
                weight = 50;
            for (int i = 0; i < VIRTUAL_NODES * weight; i++) {
                String virtualNodeName = "DOCTORID-" + str + "&&DOCTORVN" + String.valueOf(i);
                int hash = getHash(virtualNodeName);
//                System.out.println("虚拟节点[" + virtualNodeName + "]被添加, hash值为" + hash);
                virtualNodes.put(hash, virtualNodeName);
            }
        }
        System.out.println();
    }

    /**
     * 使用FNV1_32_HASH算法计算服务器的Hash值,这里不使用重写hashCode的方法，最终效果没区别
     */
    private static int getHash(String str) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0; i < str.length(); i++)
            hash = (hash ^ str.charAt(i)) * p;
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;

        // 如果算出来的值为负数则取其绝对值
        if (hash < 0)
            hash = Math.abs(hash);
        return hash;
    }

    /**
     * 得到应当路由到的结点
     */
    private static String getServer(String key) {
        //得到该key的hash值
        int hash = getHash(key);
        // 得到大于该Hash值的所有Map
        SortedMap<Integer, String> subMap = virtualNodes.tailMap(hash);
        String virtualNode;
        if (subMap.isEmpty()) {
            //如果没有比该key的hash值大的，则从第一个node开始
            Integer i = virtualNodes.firstKey();
            //返回对应的服务器
            virtualNode = virtualNodes.get(i);
        } else {
            //第一个Key就是顺时针过去离node最近的那个结点
            Integer i = subMap.firstKey();
            //返回对应的服务器
            virtualNode = subMap.get(i);
        }
        //virtualNode虚拟节点名称要截取一下
        if (virtualNode != null && !"".equals(virtualNode)) {
            return virtualNode.substring(0, virtualNode.indexOf("&&"));
        }
        return null;
    }


    @Test
    public void contextLoads() {
        String[] nodes1 = new String[100];
        for (int i = 0; i < 100; i++) {
            nodes1[i] = UUID.randomUUID().toString().replace("-", "");
            System.out.println("添加节点>>>" + nodes1[i]);
        }
        for (int i = 0; i < nodes1.length; i++) {
            System.out.print("[" + nodes1[i] + "]的hash值为" + getHash(nodes1[i]));
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
                return data.getBytes("UTF_8");
            } catch (UnsupportedEncodingException e) {
                throw new IllegalArgumentException(e);
            }
        }
    }

}
