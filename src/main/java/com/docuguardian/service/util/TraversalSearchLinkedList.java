package com.docuguardian.service.util;

import com.docuguardian.service.dao.NodeLinkedListDTO;

import java.util.HashSet;
import java.util.Set;

public class TraversalSearchLinkedList {
    public static void recursiveCheck(NodeLinkedListDTO root, Set<String> products) {
        if (root == null) return;
        /*
          Checking if the product already exists on the set.
          if products.add(x) return false means the set contain the product
          and no checking is necessary
         */
        if (!products.add(root.getItem())) return;

        if (root.getChildren().isEmpty()) return;
        for (NodeLinkedListDTO child : root.getChildren()) {
            if (child == null) continue;
            recursiveCheck(child, products);
        }

    }

    public void process(NodeLinkedListDTO root) {
        Set<String> products = new HashSet<>();
        recursiveCheck(root, products);
    }
}
