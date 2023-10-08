package models


class GraphNode(var `val`: Int) {
    var neighbors: ArrayList<GraphNode?> = ArrayList()
}