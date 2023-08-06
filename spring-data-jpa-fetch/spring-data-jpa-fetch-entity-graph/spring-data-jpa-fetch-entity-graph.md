# Entity Graph
## Source
* [Hibernate Tip: Create an EntityGraph with multiple SubGraphs](https://www.youtube.com/watch?v=TGdL9_9BxU8)
## Introduction 
An EntityGraph provides an excellent way to avoid n+1 select issues by initializing the required, lazily fetched associations. The definition of the graph is independent of your query and defines which associations Hibernate shall initialize before returning your query results.

The annotation are set in the entity class over the class keyword.
## Components
    * @NamedEntityGraph
    * @NamedAttributeNode
    * @NamedSubgraph