/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hashmaps;

import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class HashMapimp<K, V> {

    ArrayList<MapNode<K, V>> buckets;
    int size;
    int numbuckets;

    public HashMapimp() {
        numbuckets = 12;
        buckets = new ArrayList<>();
        for (int i = 0; i < numbuckets; i++) {
            buckets.add(null);
        }
    }

    private int getBucketIndex(K key) {
        int hashcode = key.hashCode();
        return hashcode % numbuckets;
    }

    public void insert(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = buckets.get(bucketIndex);
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
            }
            head = head.next;
        }
        head = buckets.get(bucketIndex);
        MapNode<K, V> newElementNode = new MapNode<>(key, value);
        size++;
        newElementNode.next = head;
        buckets.set(bucketIndex, newElementNode);
        double loadfactor = (1.0 * size) / numbuckets;
        if (loadfactor > 0.7) {
            rehash();
        }
    }

    private void rehash() {
        System.out.println("Reahashing: Bucket = " + numbuckets + " Size = " + size);
        ArrayList<MapNode<K, V>> temp = buckets;
        buckets = new ArrayList<>();
        for (int i = 0; i < 2 * numbuckets; i++) {
            buckets.add(null);
        }
        size = 0;
        numbuckets = numbuckets * 2;
        for (int i = 0; i < temp.size(); i++) {
            MapNode<K, V> head = temp.get(i);
            while (head != null) {
                K key = head.key;
                V value = head.value;
                insert(key, value);
                head = head.next;
            }
        }
    }

    public int size() {
        return size;
    }

    public V getvalue(K key) {
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = buckets.get(bucketIndex);
        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public V removeKey(K key) {
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = buckets.get(bucketIndex);
        MapNode<K, V> prev = null;
        while (head != null) {
            if (head.key.equals(key)) {
                size--;
                if (prev != null) {
                    prev.next = head.next;
                    return head.value;
                } else {
                    buckets.set(bucketIndex, head.next);
                }
            }
            prev = head;
            head = head.next;
        }
        return null;
    }

    public double loadfactor() {
        return (1.0 * size) / numbuckets;
    }
}
