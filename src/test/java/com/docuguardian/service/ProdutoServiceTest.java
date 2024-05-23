package com.docuguardian.service;


import com.docuguardian.service.dao.NodeHashSetDTO;
import com.docuguardian.service.util.TraversalSearchHashSet;
import com.util.Util;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoServiceTest {

    private TraversalSearchHashSet traversalSearchHashSet;

    @BeforeEach
    public void setUp() {
        traversalSearchHashSet = new TraversalSearchHashSet();
    }

   @Test
    public void testPostorderWithNullRoot() {
        assertDoesNotThrow(() -> traversalSearchHashSet.process(null));
    }

    @Test
    public void testPostorderWithEmptyRoot() {
        NodeHashSetDTO root = new NodeHashSetDTO();
        assertDoesNotThrow(() -> traversalSearchHashSet.process(root));
    }

    @Test
    public void testPostorderWithSingleChild() {
        NodeHashSetDTO root = new NodeHashSetDTO();
        root.setItem(Util.randomStringCreator());
        root.setIsParent(Boolean.TRUE);

        Set<NodeHashSetDTO> nodeHashSetDTOS = new HashSet<>();
        nodeHashSetDTOS.add(new NodeHashSetDTO());
        root.setChildren(nodeHashSetDTOS);

        assertDoesNotThrow(() -> traversalSearchHashSet.process(root));

    }

    @Test
    public void testPostorderWithSingleChildReturnProducts() {
        NodeHashSetDTO root = new NodeHashSetDTO();
        root.setItem(Util.randomStringCreator());
        root.setIsParent(Boolean.TRUE);

        Set<NodeHashSetDTO> nodeHashSetDTOS = new HashSet<>();
        nodeHashSetDTOS.add(new NodeHashSetDTO());
        root.setChildren(nodeHashSetDTOS);

        Set<String> result = traversalSearchHashSet.process(root);
        assertFalse(result.isEmpty());

    }

    @Test
    public void testPostorderWithMultipleChildren() {
        NodeHashSetDTO root = new NodeHashSetDTO();
        root.setIsParent(Boolean.TRUE);

        Set<NodeHashSetDTO> nodeHashSetDTOS = new HashSet<>();
        nodeHashSetDTOS.add(new NodeHashSetDTO());
        nodeHashSetDTOS.add(new NodeHashSetDTO());
        root.setChildren(nodeHashSetDTOS);

        assertDoesNotThrow(() -> traversalSearchHashSet.process(root));
    }

    @Test
    public void testPostorderWithNestedChildren() {

        NodeHashSetDTO child2 = new NodeHashSetDTO();
        child2.setItem(Util.randomStringCreator());
        child2.setIsParent(Boolean.FALSE);

        Set<NodeHashSetDTO> nodeHashSetDTOS2 = new HashSet<>();
        nodeHashSetDTOS2.add(child2);

        NodeHashSetDTO child1 = new NodeHashSetDTO();
        child1.setItem(Util.randomStringCreator());
        child1.setIsParent(Boolean.TRUE);

        child1.setChildren(nodeHashSetDTOS2);

        Set<NodeHashSetDTO> nodeHashSetDTOS1 = new HashSet<>();
        nodeHashSetDTOS1.add(child1);

        NodeHashSetDTO root = new NodeHashSetDTO();
        root.setItem(Util.randomStringCreator());
        root.setChildren(nodeHashSetDTOS1);
        root.setIsParent(Boolean.TRUE);


        assertEquals(traversalSearchHashSet.process(root).size(), 3);
    }

    @Test
    public void testPostorderWithDuplicatedChildren() {

        NodeHashSetDTO child2 = new NodeHashSetDTO();
        child2.setItem(Util.randomStringCreator());
        Set<NodeHashSetDTO> nodeHashSetDTOS2 = new HashSet<>();
        nodeHashSetDTOS2.add(child2);

        NodeHashSetDTO child1 = new NodeHashSetDTO();
        child1.setItem(Util.randomStringCreator());
        child1.setChildren(nodeHashSetDTOS2);

        Set<NodeHashSetDTO> nodeHashSetDTOS = new HashSet<>();
        nodeHashSetDTOS.add(child2);

        NodeHashSetDTO root = new NodeHashSetDTO();
        root.setItem(Util.randomStringCreator());
        root.setChildren(nodeHashSetDTOS);

        assertEquals(traversalSearchHashSet.process(root).size(), 2);
    }
}
