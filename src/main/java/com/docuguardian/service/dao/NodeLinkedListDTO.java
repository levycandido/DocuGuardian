package com.docuguardian.service.dao;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
@Data
public class NodeLinkedListDTO {
    private String item;
    private List<NodeLinkedListDTO> children = new LinkedList<>();
    Boolean isParent = Boolean.FALSE;

    public void setChildren(List<NodeLinkedListDTO> children) {
        this.children = children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NodeLinkedListDTO that = (NodeLinkedListDTO) o;
        return Objects.equals(item, that.item) && Objects.equals(children, that.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item, children);
    }
}
