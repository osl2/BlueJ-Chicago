# BlueJ-Chicago Documents
Um den Visualizer zu nutzen importiert man einfach die Jar als Bibliothek. Von da aus kann man die Datenstrukturen VArray, VMap, VDoublyLinkedList, VSinglyLinkedList, VDirectedGraph, VUndirectedGraph und VTree nutzen.

**Für alle Datenstrukturen:**
- setName(String name):<br> Setzt den Namen der Datenstruktur
- getName()returns String:<br> Gibt den Namen der Datenstruktur zurück.
- getDatastructureType() return String:<br> Gibt den Typ der Datenstruktur zurück.
- size() returns int:<br> Gibt die Größe der Datenstruktur zurück.
- removeAll() returns boolean:<br> Entfernt alle Elemente aus der Datenstruktur. 
- isEmpty() returns boolean:<br> Gibt zurück ob die Datenstruktur leer ist oder nicht.

**VArray<T>:**
- Array<T>(int size):<br>  Erstellt ein Array mit Größe size.
- VArray<T>(int size, String name):<br> Erstellt ein Array mit Größe size mit dem Namen name.
- setValue(int index, T value):<br> Sets an Index index den Wert value.
- getValue(int index) returns T:<br> Gibt den Wert an der Stelle des Indizes zurück.
- contains(T value)returns boolean:<br> Gibt true zurück, falls der Wert value im Array enthalten ist. Ansonsten false.
- contains(Collection<T> values) returns boolean:<br> Gibt true zurück, falls die Werte values im Array enthalten sind. Ansonsten false.

**VSinglyLinkedList<T> / VDoublyLinkedList<T>:**
- VSinglyLinkedList <T>():<br> Erstellt eine neue einfach verkettete Liste.
- VDoublyLinkedList <T>():<br> Erstellt eine neue doppelt verkettete Liste.
-VSinglyLinkedList <T>(String name):<br> Erstellt eine neue einfach verkettete Liste mit dem Namen name.
- VDoublyLinkedList <T>(String name):<br> Erstellt eine neue doppelt verkettete Liste mit dem Namen name.
- Restliche Methoden siehe:<br> [java.util.List](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/List.html)

**VMap<K, V>:**
- VMap<K, V>():<br> Erstellt eine neue VMap.
- VMap<K, V>(String name):<br> Erstellt eine neue VMap mit dem Namen name.
- Restliche Methoden:<br> [java.util.Map](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Map.html)

**VGraphNode<T>:**
- setValues(T value):<br> Setzt den Value des Knotens.

**VDirectedGraph<T> / VUndirectedGraph<T>:**
- VDirectedGraph<T>():<br> Erstellt einen neuen gerichteten Graphen.
- VUndirectedGraph<T>():<br> Erstellt einen neuen ungerichteten Graphen.
- VDirectedGraph<T>(String name):<br> Erstellt einen neuen gerichteten Graphen mit dem Namen name.
- VUndirectedGraph<T>(String name):<br> Erstellt einen neuen ungerichteten Graphen mit dem Namen name.
- addNode() returns VGraphNode<T>:<br> addNode erstellt einen Knoten im Graphen. Diese kann dann bearbeitet werden. Mittels setValue(T value). Nur so erstellte Knoten können im Graphen benutzt werden.
- addEdge(VGraphNode<T>  start, VGraphNode<T> end) returns boolean:<br> Fügt eine Kante von start zu end hinzu. Gibt true bei Erfolg zurück ansonsten false.
- removeNode(VGraphNode<T>  node)returns boolean:<br> Entfernt einen Knoten aus dem Graphen. Gibt true bei Erfolg zurück ansonsten false.
- removeEdge(VGraphNode<T>  start, VGraphNode<T> end) returns boolean:<br> Entfernt eine Kante aus dem Graphen. Gibt true bei Erfolg zurück ansonsten false.
- getEdges(VGraphNode<T> node)returns Collection<VEdge>:<br> Gibt eine Collection an Kanten zu einem Knoten zurück.
- getAdjacents(VGraphNode<T> node)returns Collection<VGraphNode>:<br> Gibt alle benachbarten Knoten zu einem Knoten an.
- containsNode(VGraphNode<T> node) returns boolean:<br> Gibt true aus, falls der Knoten im Graphen ist, ansonsten false.
- containsEdge(VGraphNode<T> node, VGraphNode<T> node) returns boolean:<br> Gibt true aus, falls die Kante im Graphen ist, ansonsten false.

**VTree<T>:** (Nutzt auch VGraphNodes)
- VTree<T>():<br> Erstellt einen neuen Baum.
- VTree<T>(String name):<br> Erstellt einen neuen Baum mit dem Namen name.
- addNode() returns VGraphNode<T>:<br> addNode erstellt einen Knoten im Tree. Diese kann dann bearbeitet werden. Mittels setValue(T value). Nur so erstellte Knoten können im Baum benutzt werden.
- addChild(VGraphNode<T>:  child, VGraphNode<T> parent) returns boolean:<br> Fügt einen Childknoten zu einem Parentknoten hinzu. 
- removeLeaf(VGraphNode node)returns boolean:<br> Entfernt einen Knoten, falls er ein Blatt ist. Gibt true bei Erfolg zurück ansonsten false.
- getChildren(VGraphNode parent)returns collection<VGraphNode>:<br> Gibt alle Childknoten eines Parentknoten zurück.
- getParent(VGraphNode child)returns VGraphNode:<br> Gibt den Parentknoten eines Childknoten zurück.
- getHeight()returns int:<br> Gibt die Höhe des Baumes zurück. Also die Länge des längsten Pfades von Wurzel bis Blatt.
- swap(VGraphNode child, VGraphNode parent)returns boolean:<br> Tauscht Childknoten mit Parentknoten. Gibt true bei Erfolg zurück ansonsten false.
- contains(VGraphNode node)returns boolean:<br> Gibt true aus, wenn ein Knoten im Baum ist. Ansonsten false.
- contains(Collection<VGraphNode> node) returns boolean:<br> Gibt true aus, wenn die Menge an Knoten im Baum ist. Ansonsten galse.
- getRootNode()returns VGraphNode:<br> Gibt die Wurzel des Baumes zurück.
