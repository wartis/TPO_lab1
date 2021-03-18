package main.java

import java.util.*

//class Graph(
//    private val verticesNumber: Int,
//
//) {
//    val visited:   Array<Boolean> = Array(verticesNumber) {false}
//    val relations: Array<LinkedList<Int>> = Array(verticesNumber) {
//        LinkedList<Int>()
//    }
//
//
//    fun addEdge(src: Int, dest: Int) {
//        relations[src].add(dest)
//    }
//
//    fun dfs(vertex: Int) {
//        clearVisitedVertices()
//        DFS(vertex)
//    }
//
//    private fun DFS(vertex: Int) {
//        visited[vertex] = true
//        val ite = relations[vertex].listIterator()
//        while (ite.hasNext()) {
//            val next: Int = ite.next()
//            if (!visited[next])
//                dfs(next)
//        }
//    }
//
//    private fun clearVisitedVertices() {
//        visited.fill(false)
//    }
//}