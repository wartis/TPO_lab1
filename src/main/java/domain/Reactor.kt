package domain

import main.java.model.Knowledge
import main.java.model.Message
import main.java.model.MessageReactable

open class Reactor (
    val knowledge : MutableList<Knowledge> = ArrayList()
) : MessageReactable {

    /*default reaction*/
    override fun reactOn(message: Message): Reaction {
        return Reaction(0)
    }

    override fun reactOnMessageAccordingRule(message: Message, reactRule: Reactor.(Message) -> Reaction): Reaction {
        return reactRule(message)
    }
}