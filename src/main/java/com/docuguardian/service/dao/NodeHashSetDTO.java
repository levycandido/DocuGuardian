package com.docuguardian.service.dao;

import lombok.Data;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
@Data
public class NodeHashSetDTO {
    private String item;
    private Set<NodeHashSetDTO> children = new HashSet<>();
    Boolean isParent = Boolean.FALSE;

    NodeHashSetDTO(String value) {
        this.item = value;
        this.children = new HashSet<>();
    }

    public NodeHashSetDTO() {

    }

    public void addNode(NodeHashSetDTO node) {
        children.add(node);
    }

    public NodeHashSetDTO(String name, Set<NodeHashSetDTO> child) {
        this.item = name;
        this.children = child;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Set<NodeHashSetDTO> getChildren() {
        return children;
    }

    public void setChildren(Set<NodeHashSetDTO> children) {
        this.children = children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NodeHashSetDTO that = (NodeHashSetDTO) o;
        return Objects.equals(item, that.item) && Objects.equals(children, that.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item, children);
    }



}
