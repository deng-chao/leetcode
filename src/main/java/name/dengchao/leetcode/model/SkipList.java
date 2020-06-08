package name.dengchao.leetcode.model;

import java.security.SecureRandom;

public class SkipList<T extends Comparable<T>> {

    private volatile int maxLevel;

    private Node<T> head;
    private Node<T> tail;

    public SkipList(int maxLevel) {
        this.maxLevel = maxLevel;
        this.head = new Node<>(null, maxLevel);
        this.tail = new Node<>(null, maxLevel);
        head.next = tail;
        Node<T> cursor = head;
        while (cursor.level > 0) {
            cursor.down = new Node(null, cursor.level - 1);
            cursor.next = tail;
            cursor = cursor.down;
        }
        // 将最下层的down置为空
        cursor.down = null;
    }


    class Node<V extends Comparable<V>> {

        Node(V value, int level) {
            this.value = value;
            this.level = level;
        }

        V value;
        int level;
        Node up, down, prev, next;

        @Override
        public String toString() {
            return "level: " + level + ", value: " + value;
        }
    }

    private void setHead(T e) {
        Node<T> cursor = head;
        while (cursor != null && cursor.level > 0) {
            cursor.value = e;
            cursor = cursor.down;
        }
    }

    public boolean add(T e) {
        if (e == null) {
            return false;
        }
        if (head.value == null) {
            setHead(e);
            return true;
        }
        if (head.value.compareTo(e) > 0) {
            T swap = head.value;
            setHead(e);
            return add(swap);
        }
        Node<T> cursor = head;
        int level = randomLevel(maxLevel);
        while (cursor.level > level) {
            cursor = cursor.down;
        }
        Node<T> tmp = null;
        while (cursor != null && cursor.level > 0) {
            while (cursor.value.compareTo(e) > 0 && cursor.next.value != null) {
                cursor = cursor.next;
            }
            Node<T> newNode = new Node<>(e, cursor.level);
            newNode.next = cursor.next;
            cursor.next = newNode;
            newNode.up = tmp;
            if (tmp != null) {
                tmp.down = newNode;
            }
            tmp = newNode;
            cursor = cursor.down;
        }
        return true;
    }

    private static SecureRandom random = new SecureRandom();

    static int randomLevel(int maxLevel) {
        int level = 1;
        double possibility = Math.pow(0.5, level);
        while (level < maxLevel) {
            if (random.nextDouble() > possibility) {
                break;
            }
            level++;
        }
        return level;
    }

    @Override
    public String toString() {
        Node<T> cursor = head;
        StringBuilder stb = new StringBuilder();
        while (cursor != null && cursor.level > 0) {
            Node<T> rowCursor = cursor;
            while (rowCursor.next != null) {
                stb.append(rowCursor.value).append(",");
                rowCursor = rowCursor.next;
            }
            stb.append(System.lineSeparator());
            cursor = cursor.down;
        }
        return stb.toString();
    }
}
