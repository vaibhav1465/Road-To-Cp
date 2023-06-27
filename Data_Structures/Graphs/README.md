Graphs
This repository provides a collection of graph algorithms and data structures implemented in Java. Graphs are fundamental data structures used to model relationships between entities. This library offers a variety of functionalities for working with graphs, including graph creation, traversal, shortest path calculation, and more.

A graph can be visualized as a set of points (vertices) connected by lines (edges). The vertices represent the entities, while the edges represent the relationships or connections between them. Graphs can be either directed or undirected, depending on whether the edges have a specific direction or not.

Features
Support for directed and undirected graphs.
Creation and manipulation of graphs, including adding and removing vertices and edges.
Traversal algorithms for exploring graphs, such as depth-first search (DFS) and breadth-first search (BFS).
Algorithms for finding the shortest path between two vertices, using Dijkstra's algorithm.
Algorithms for finding minimum spanning trees, such as Prim's algorithm.

Terminology
Here are some key terms used when discussing graphs:

Vertex (Node): A fundamental unit of a graph. It represents an entity or an object. Vertices are often labeled with unique identifiers or values.

Edge: A connection between two vertices. It represents the relationship or connection between the entities represented by the vertices. Edges can be directed (one-way) or undirected (two-way).

Weight: An optional value associated with an edge, indicating the cost, distance, or any other relevant metric associated with traversing that edge.

Degree: The number of edges incident to a vertex. In a directed graph, the degree is further divided into in-degree (number of incoming edges) and out-degree (number of outgoing edges).

Path: A sequence of vertices connected by edges. It represents a route or a series of connections from one vertex to another.

Cycle: A path that starts and ends at the same vertex, forming a closed loop.

Connected Graph: A graph where there is a path between every pair of vertices. In other words, there are no isolated vertices.

Disconnected Graph: A graph that consists of two or more connected components, where there is no path between vertices in different components.

Directed Acyclic Graph (DAG): A directed graph that contains no cycles.

Graph Algorithms
Graph algorithms are a set of techniques used to analyze and manipulate graphs. Here are some commonly used graph algorithms:

Depth-First Search (DFS): Traverses a graph by exploring as far as possible along each branch before backtracking. It is often used to explore or search a graph, find connected components, detect cycles, and more.