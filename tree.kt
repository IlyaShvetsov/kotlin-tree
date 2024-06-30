
interface Tree<V, out C : Tree<V, C>> {
    val value: V?
    val children: Collection<C>
    fun get(index: Int): C
}

interface MutableTree<V, C : MutableTree<V, C>>: Tree<V, C> {
    override val children: MutableCollection<C>
    fun add(child: C)
}

class MutableTreeImpl<V>(
    override val value: V?,
    override val children: MutableList<MutableTreeImpl<V>> = mutableListOf()
) : MutableTree<V, MutableTreeImpl<V>> {

    override fun get(index: Int): MutableTreeImpl<V> = children[index]

    override fun add(child: MutableTreeImpl<V>) { children.add(child) }
}
