package osl2;

import osl2.datastructures.*;
import osl2.datastructures.nodey.VGraphNode;
import osl2.datastructures.nodey.VLinkedList;

/**
 * The class for the demoprogramm.
 */
public class Democlass {
  private VArray<Integer> integerArray;
  private VArray<VArray> inlineArray;
  private VMap<String, Integer> integerMap;
  private VLinkedList integerList;
  private VLinkedList stringList;
  private VGraph<String> stringGraph;
  private VGraph<Integer> integerGraph;
  private VTree<String> stringTree;

  /**
   * Creates the new Demoprogramm.
   */
  public Democlass() {
    play();
  }

  /**
   * Plays the demo.
   */
  private void play() {
    setIntegerArray();
    setInlineArray();
    setIntegerMap();
    setIntegerList();
    setStringList();
    setIntegerGraph();
    setStringGraph();
  }

  /**
   * For the IntegerArray playing.
   */
  private void setIntegerArray() {
    integerArray = new VArray<Integer>(5, "IntegerArray");
    for (int i = 0; i < integerArray.size(); i++) {
      integerArray.setValue(i, i * 2);
    }
    integerArray.setValue(3, integerArray.getValue(3) * 3);
    //ArrayIndexOutOfBoundsError.
    integerArray.setValue(6, 5);
  }

  /**
   * For the InlineArray playing.
   */
  private void setInlineArray() {
    inlineArray = new VArray<VArray>(2, "InlineArray");
    inlineArray.setValue(0, integerArray);
    inlineArray.setValue(1, inlineArray);
  }

  /**
   * For the IntegerMapPlaying.
   */
  private void setIntegerMap() {
    integerMap = new VMap("IntegerMap");
    integerMap.put("A", 5);
    integerMap.put("B", 6);
    integerMap.put("AB", integerMap.get("A") + integerMap.get("B"));
    integerMap.remove("B");
    integerMap.put("A", 8);
  }

  /**
   * For the IntegerList playing.
   */
  private void setIntegerList() {
    integerList = new VDoublyLinkedList<Integer>("IntegerList");
    integerList.add(1);
    integerList.add(2);
    integerList.add(3);
    integerList.set(2, 4);
    integerList.remove((Integer) 3);

    if (!integerList.contains(3)) {
      integerList.add(integerList.get(4));
    }

  }

  /**
   * For the StringList playing.
   */
  private void setStringList() {
    stringList = new VSinglyLinkedList<String>("StringList");
    stringList.add("A");
    stringList.add("B");
    stringList.add("C");
    integerList.set(2, "D");
    if ("D".equals(integerList.get(2))) integerList.remove("C");
    if (!integerList.contains("D")) {
      integerList.add(integerList.get(4));
    }
  }

  /**
   * For the StringGraph playing.
   */
  private void setStringGraph() {
    stringGraph = new VDirectedGraph<String>("StringGraph");
    VGraphNode nodeA = stringGraph.addNode();
    nodeA.setValue("A");
    VGraphNode nodeB = stringGraph.addNode();
    nodeB.setValue("B");
    stringGraph.addEdge(nodeA, nodeB);
    stringGraph.addEdge(nodeA, nodeB);
    stringGraph.removeNode(nodeA);
    stringGraph.addEdge(nodeB, stringGraph.addNode());
    if (stringGraph.containsNode(nodeB)) {
      VGraphNode nodeC = stringGraph.addNode();
      nodeC.setValue("C");
      stringGraph.addEdge(nodeC, nodeA);
    }
    //Error: Can't be removed.
    stringGraph.removeNode(nodeA);
  }

  /**
   * For the IntegerGraphplaying.
   */
  private void setIntegerGraph() {
    integerGraph = new VUndirectedGraph<Integer>("IntegerGraph");
    VGraphNode node1 = integerGraph.addNode();
    node1.setValue(1);
    VGraphNode node2 = integerGraph.addNode();
    node2.setValue(2);
    integerGraph.addEdge(node1, node2);
    integerGraph.addEdge(node2, integerGraph.addNode());
    if (integerGraph.containsNode(node2)) {
      VGraphNode node4 = integerGraph.addNode();
      node4.setValue(4);
      integerGraph.addEdge(node4, node2);
    }
    integerGraph.addEdge(node2, node1);
    integerGraph.removeEdge(node2, node1);
  }


}