package performance;

import com.docuguardian.service.dao.NodeHashSetDTO;
import com.docuguardian.service.util.TraversalSearchHashSet;
import com.emun.StructureType;
import com.util.Util;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

class TraversalSearchHashSetTest {
    TraversalSearchHashSet traversalSearchHashTable = new TraversalSearchHashSet();
    long startTime;
    long endTime;

    @Test
    void loadAndProcessWithParentsNoChild() {
        System.out.println("loadAndProcessWithParentsNoChild");
        NodeHashSetDTO root = getNodeHashTable();
        root.setChildren(loadRecods(1000));
        processData(root);
    }

    @Test
    void loadAndProcessWithParentsWithChild() {
        System.out.println("loadAndProcessWithParentsAndChild");
        NodeHashSetDTO root = getNodeHashTable();
        root.setChildren(loadRecodsWithChild(1000));
        processData(root);
    }

    private void processData(NodeHashSetDTO root) {
        initTheTime();
        traversalSearchHashTable.process(root);
        Util.finishTheTime(startTime, StructureType.HASHTABLE);
    }

    private Set<NodeHashSetDTO> loadRecods(int size) {
        Set<NodeHashSetDTO> child = new HashSet<>();
        for (int i = 1; i < size; i++) {
            NodeHashSetDTO nodeHashTable = getNodeHashTable();
            child.add(nodeHashTable);
        }
        return child;
    }

    private Set<NodeHashSetDTO> loadRecodsWithChild(int size) {
        Set<NodeHashSetDTO> child = new HashSet<>();
        for (int i = 1; i < size; i++) {
            NodeHashSetDTO nodeHashTable = getNodeHashTable();
            nodeHashTable.setChildren(loadRecods(1000));
            nodeHashTable.getChildren()
                    .forEach(nodeArrayListDTO -> nodeArrayListDTO.setIsParent(Boolean.TRUE));
            child.add(nodeHashTable);
        }
        return child;
    }

    private void initTheTime(){
        startTime = System.nanoTime();
    }

    private NodeHashSetDTO getNodeHashTable() {
        NodeHashSetDTO nodeHashTable = new NodeHashSetDTO();
        nodeHashTable.setItem(Util.randomStringCreator());
        return nodeHashTable;
    }
}