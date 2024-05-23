
# 📋 Step-by-Step Guide for Code Challenge Response

## 🚀 Introduction

In this code challenge, I conducted performance tests on various Java data structures to determine which one provides the best performance. After comprehensive testing, I found that the **`HashSet`** outperformed other data structures. Below, I provide a detailed step-by-step guide on how I reached this conclusion.

---

## 📝 Step 1: Define the Problem

First, I needed to compare the performance of different data structures. The data structures evaluated were:

- **`ArrayList`**
- **`LinkedList`**
- **`HashSet`**

---

## 🔧 Step 2: Set Up the Testing Environment

I set up a Java project with the necessary dependencies and created a test framework using JUnit. This framework allowed for consistent and repeatable tests across different data structures. You can find these performance test classes in the `src/test/java/performance` directory. For instance:

```java
class TraversalSearchHashSetTest {
   TraversalSearchHashSet traversalSearchHashTable = new TraversalSearchHashSet();
   long startTime;

   @Test
   void loadAndProcessWithParentsNoChild() {
       System.out.println("loadAndProcessWithParentsNoChild");
       NodeHashSetDTO root = getNodeHashTable();
       root.setChildren(loadRecords());
       processData(root);
   }

   @Test
   void loadAndProcessWithParentsWithChild() {
       System.out.println("loadAndProcessWithParentsAndChild");
       NodeHashSetDTO root = getNodeHashTable();
       root.setChildren(loadRecordsWithChild());
       processData(root);
   }

   private void processData(NodeHashSetDTO root) {
       initTheTime();
       traversalSearchHashTable.process(root);
       Util.finishTheTime(startTime, StructureType.HASHTABLE);
   }

   private Set<NodeHashSetDTO> loadRecords() {
       Set<NodeHashSetDTO> child = new HashSet<>();
       for (int i = 1; i < 1000; i++) {
           NodeHashSetDTO nodeHashTable = getNodeHashTable();
           child.add(nodeHashTable);
       }
       return child;
   }

   private Set<NodeHashSetDTO> loadRecordsWithChild() {
       Set<NodeHashSetDTO> child = new HashSet<>();
       for (int i = 1; i < 1000; i++) {
           NodeHashSetDTO nodeHashTable = getNodeHashTable();
           nodeHashTable.setChildren(loadRecords());
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
```

---

## 🏃‍♂️ Step 3: Execute the Tests

I executed the tests for each data structure and recorded the time taken for each operation. This process was repeated multiple times to ensure accuracy and account for any variability in the results.

---

## 🏋️ Step 4: Consider the Heaviest Scenario

Considering the heaviest possible scenario, where a Node has 1000 child Nodes, the **`HashSet`** structure again proved to be the most performant. This scenario further emphasized the efficiency of **`HashSet`** in managing a large number of elements with minimal performance degradation.

---

## 📊 Step 5: Analyze the Results

After running the tests, I compared the results. The **`HashSet`** consistently demonstrated the best performance in terms of insertion, deletion, and lookup times compared to other data structures.

---

## 🏆 Conclusion

Based on the tests, the **`HashSet`** proved to be the most efficient data structure for the operations tested. Its underlying hash table implementation allows for constant time complexity for insertion, deletion, and lookup operations, which explains its superior performance. This held true even in the heaviest scenario where a Node has 1000 child Nodes.

---

You can find the complete code on GitHub at [this link](https://github.com/levycandido/docuguardian/tree/master).

Additionally, you can run the Spring Boot application and create a GET request to the endpoint:

```
http://localhost:8080/v1/product/components
```

---

Feel free to replace the placeholder text such as `[Recipient's Name]` and `[Your Name]` with the appropriate details.

---

Espero que isso ajude a tornar o README mais atraente e fácil de seguir!
