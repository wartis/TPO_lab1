package main.java.model

import domain.Reaction
import domain.Reactor

interface MessageReactable{
    fun reactOn(message: Message) : Reaction
    fun reactOnMessageAccordingRule(message: Message, reactRule: Reactor.(Message) -> Reaction) : Reaction
}
