package com.docuguardian.service.dao;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class NodeArrayListDTO {
    private String item;
    private List<NodeArrayListDTO> children = new ArrayList<>();
    Boolean isParent = Boolean.FALSE;
}
