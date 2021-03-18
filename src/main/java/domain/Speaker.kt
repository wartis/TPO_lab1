package domain

import main.java.model.Message

open class Speaker(val name: String) {
    fun publishMessage(title: String, text: String) : Message {
        return Message(title = title, text = text, author = this)
    }
}