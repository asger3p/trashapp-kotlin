package dk.itu.trashapp

class Item(what: String?, where: String?) {
    var what: String? = null
    var where: String? = null

    init {
        this.what = what
        this.where = where
    }

    override fun toString(): String {
        return oneLine("", " should be placed in: ")
    }

    fun oneLine(pre: String, post: String): String {
        return pre + what + post + where
    }
}
