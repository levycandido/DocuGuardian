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
    long endTime;

    @Test
    void loadAndProcessWithParentsNoChild() {
        System.out.println("loadAndProcessWithParentsNoChild");
        NodeLinkedListDTO root = getNodeLinkedList();
        root.setChildren(loadRecods(1000));
        processData(root);
    }

    @Test
    void loadAndProcessWithParentsAndChild() {
        System.out.println("loadAndProcessWithParentsAndChild");
        NodeLinkedListDTO root = getNodeLinkedList();
        root.setChildren(loadRecodsWithChild(1000));
        processData(root);
    }

    private List<NodeLinkedListDTO> loadRecods(int size) {
        List<NodeLinkedListDTO> nodeLinkedLists = new LinkedList<>();
        for (int i = 1; i < size; i++) {
            NodeLinkedListDTO child = getNodeLinkedList();
            nodeLinkedLists.add(child);
        }
        return nodeLinkedLists;
    }

    private List<NodeLinkedListDTO> loadRecodsWithChild(int size) {
        List<NodeLinkedListDTO> nodeLinkedLists = new LinkedList<>();
        for (int i = 1; i < size; i++) {
            NodeLinkedListDTO child = getNodeLinkedList();
            child.setChildren(loadRecods(1000));
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
        traversalSearchLinkedList.loadAndProcess(root);
        Util.finishTheTime(startTime, StructureType.LINKEDLIST);
    }
}