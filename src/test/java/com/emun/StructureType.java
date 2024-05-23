package com.emun;

public enum StructureType {
    ARRAYLIST("ArrayList"),
    LINKEDLIST("LinkedList"),
    HASHTABLE("HashTable");

    public final String description;

    StructureType(String label) {
        this.description = label;
    }
}
