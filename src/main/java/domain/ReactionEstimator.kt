package domain

import main.java.model.Message

object ReactionEstimator {
    fun estimateReactionOn(message: Message, reactors: List<Reactor>, reactionRule : Reactor.(Message) -> Reaction) : Reaction {
        val resReaction = Reaction()

        reactors.forEach {
            resReaction += it.reactOnMessageAccordingRule(message, reactionRule)
        }

        return resReaction
    }
}