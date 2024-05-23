package performance;

import com.docuguardian.service.dao.NodeArrayListDTO;
import com.docuguardian.service.util.TraversalSearchArrayList;
import com.emun.StructureType;
import com.util.Util;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

class TraversalSearchArrayListTest {

    TraversalSearchArrayList traversalSearchArrayList = new TraversalSearchArrayList();
    long startTime;

    @Test
    void loadAndProcessWithParentsNoChild() {
        System.out.println("loadAndProcessWithParentsNoChild");
        NodeArrayListDTO root = getNodeArrayList();
        root.setChildren(loadRecods());
        processData(root);
    }

    @Test
    void loadAndProcessWithParentsAndChild() {
        System.out.println("loadAndProcessWithParentsAndChild");
        NodeArrayListDTO root = getNodeArrayList();
        root.setChildren(loadRecodsWithChild());
        processData(root);
    }

    private List<NodeArrayListDTO> loadRecods() {
        List<NodeArrayListDTO> nodeLinkedLists = new LinkedList<>();
        for (int i = 0; i < 1000; i++) {
            NodeArrayListDTO child = getNodeArrayList();
            nodeLinkedLists.add(child);
        }
        return nodeLinkedLists;
    }

    private List<NodeArrayListDTO> loadRecodsWithChild() {
        List<NodeArrayListDTO> nodeLinkedLists = new LinkedList<>();
        for (int i = 0; i < 1000; i++) {
            NodeArrayListDTO child = getNodeArrayList();
            child.setChildren(loadRecods());
            child.getChildren()
                    .forEach(nodeArrayListDTO -> nodeArrayListDTO.setIsParent(Boolean.TRUE));
            nodeLinkedLists.add(child);
        }
        return nodeLinkedLists;
    }

      private void initTheTime() {
        startTime = System.nanoTime();
    }

    private NodeArrayListDTO getNodeArrayList() {
        NodeArrayListDTO nodeArrayList = new NodeArrayListDTO();
        nodeArrayList.setItem(Util.randomStringCreator());
        return nodeArrayList;
    }

    private void processData(NodeArrayListDTO root) {
        initTheTime();
        traversalSearchArrayList.process(root);
        Util.finishTheTime(startTime, StructureType.ARRAYLIST);
    }
}