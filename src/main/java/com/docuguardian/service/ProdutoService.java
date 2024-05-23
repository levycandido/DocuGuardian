package com.docuguardian.service;

import com.docuguardian.service.dao.NodeHashSetDTO;
import com.docuguardian.service.util.TraversalSearchHashSet;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ProdutoService {

    public Set<String> getComponents(NodeHashSetDTO nodeHashSetDTO) {

            TraversalSearchHashSet traversalSearchHashSet = new TraversalSearchHashSet();
            return traversalSearchHashSet.process(nodeHashSetDTO);
    }







}
