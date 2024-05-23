package com.docuguardian.service.util;

import com.docuguardian.service.dao.NodeArrayListDTO;

import java.util.HashSet;
import java.util.Set;

public class TraversalSearchArrayList {
    public static void recursiveCheck(NodeArrayListDTO root, Set<String> products) {
        if (root == null) return;
        /*
          Checking if the product already exists on the set.
          if products.add(x) return false means the set contain the product
          and no checking is necessary
         */
        if (!products.add(root.getItem()) || root.getIsParent()) return;

        if (root.getChildren().isEmpty()) return;
        for (NodeArrayListDTO child : root.getChildren()) {
            if (child == null) continue;
            recursiveCheck(child, products);
        }

    }

    public void process(NodeArrayListDTO root) {
        Set<String> products = new HashSet<>();
        recursiveCheck(root, products);
    }
}
