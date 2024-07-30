package bstmap;

import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable, V> implements Map61B<K, V>{
    BSTNode root;
    int size = 0;

    private class BSTNode{
        K key;
        V value;
        BSTNode right;
        BSTNode left;
        BSTNode(K key, V value)
        {
            this.key = key;
            this.value = value;
        }
    }

    @Override
    public void clear()
    {
        size = 0;
        root = null;
    }

    @Override
    public boolean containsKey(K key)
    {
        return containsKey(key, root);
    }

    private boolean containsKey(K key, BSTNode node)
    {
        if (node == null)
        {
            return false;
        }
        else if (node.key.compareTo(key) < 0)
        {
            return containsKey(key, node.right);
        }
        else if (node.key.compareTo(key) > 0)
        {
            return containsKey(key, node.left);
        }
        return true;
    }

    @Override
    public V get(K key)
    {
        return get(key, root);
    }

    private V get(K key, BSTNode node)
    {
        if (node == null)
        {
            return null;
        }
        else if (node.key.compareTo(key) < 0)
        {
            return get(key, node.right);
        }
        else if (node.key.compareTo(key) > 0)
        {
            return get(key, node.left);
        }
        return node.value;
    }


    @Override
    public int size()
    {
        return size;
    }

    @Override
    public void put(K key, V value)
    {
        root = put(key, value, root);
    }
    private BSTNode put(K key, V value, BSTNode node)
    {
        if (node == null) {
            size++;
            return new BSTNode(key, value);
        } else if (node.key.compareTo(key) < 0) {
            node.right = put(key, value, node.right);
        } else if (node.key.compareTo(key) > 0) {
            node.left = put(key, value, node.left);
        }
        return node;
    }
    @Override
    public Set<K> keySet()
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key, V value)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException();
    }
}
