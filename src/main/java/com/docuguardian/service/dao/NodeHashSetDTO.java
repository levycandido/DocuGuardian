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
