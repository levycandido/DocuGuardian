package com.docuguardian.service.util;

import com.docuguardian.service.dao.NodeHashSetDTO;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class TraversalSearchHashSet {
    public static void recursiveCheck(NodeHashSetDTO root, Set<String> products) {
        if (root == null) return;
        /*
          Checking if the product already exists on the set.
          if products.add(x) return false means the set contain the product
          and no checking is necessary
         */
        if (!products.add(root.getItem())) return;

        if (root.getChildren().isEmpty()) return;

        for (NodeHashSetDTO child : root.getChildren()) {
            if (child == null) continue;
            recursiveCheck(child, products);
        }
    }

    public Set<String> process(NodeHashSetDTO root) {
        Set<String> products = new HashSet<>();
        recursiveCheck(root, products);
        return products;
    }
}
