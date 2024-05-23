package performance;

import com.docuguardian.service.dao.NodeLinkedListDTO;
import com.docuguardian.service.util.TraversalSearchLinkedList;
import com.emun.StructureType;
import com.util.Util;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

class TraversalSearchLinkedListTest {
    TraversalSearchLinkedList traversalSearchLinkedList = new TraversalSearchLinkedList();
    long startTime;

    @Test
    void loadAndProcessWithParentsNoChild() {
        System.out.println("loadAndProcessWithParentsNoChild");
        NodeLinkedListDTO root = getNodeLinkedList();
        root.setChildren(loadRecods());
        processData(root);
    }

    @Test
    void loadAndProcessWithParentsAndChild() {
        System.out.println("loadAndProcessWithParentsAndChild");
        NodeLinkedListDTO root = getNodeLinkedList();
        root.setChildren(loadRecodsWithChild());
        processData(root);
    }

    private List<NodeLinkedListDTO> loadRecods() {
        List<NodeLinkedListDTO> nodeLinkedLists = new LinkedList<>();
        for (int i = 1; i < 1000; i++) {
            NodeLinkedListDTO child = getNodeLinkedList();
            nodeLinkedLists.add(child);
        }
        return nodeLinkedLists;
    }

    private List<NodeLinkedListDTO> loadRecodsWithChild() {
        List<NodeLinkedListDTO> nodeLinkedLists = new LinkedList<>();
        for (int i = 1; i < 1000; i++) {
            NodeLinkedListDTO child = getNodeLinkedList();
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

  private NodeLinkedListDTO getNodeLinkedList() {
        NodeLinkedListDTO nodeLinkedList = new NodeLinkedListDTO();
        nodeLinkedList.setItem(Util.randomStringCreator());
        return nodeLinkedList;
    }

    private void processData(NodeLinkedListDTO root) {
        initTheTime();
        traversalSearchLinkedList.process(root);
        Util.finishTheTime(startTime, StructureType.LINKEDLIST);
    }
}