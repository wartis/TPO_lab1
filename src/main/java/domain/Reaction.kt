package domain

class Reaction(attention: Int = 0 /* some other fields */) {

    var attention: Int = attention
        set(value) {
            field = when {
                value > 100 -> 100
                value < 0 -> 0
                else -> value
            }
        }

    override fun equals(other: Any?): Boolean {
        if(other == null || other !is Reaction) {
            return false
        }
        return attention == other.attention
    }

    operator fun plusAssign(reaction: Reaction) {
        this.attention += reaction.attention
    }
}