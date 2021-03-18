package test.java

import domain.Reaction
import domain.ReactionEstimator
import domain.Reactor
import domain.Speaker
import main.java.model.*
import org.junit.Test

class DomainTest {

    private val speaker: Speaker = Speaker("C3PO")
    private val reactor1: Reactor = Reactor()
    private val reactor2: Reactor = Reactor()
    private val defMessage = Message("title", "message", speaker)
    val defReaction = Reaction(0)

    @Test
    fun `check if the published message matches the default message`() {
        val pubMessage = speaker.publishMessage("title", "message")

        assert(defMessage == pubMessage)
    }

    @Test
    fun `check if reactOn in Reactor returns a default reaction`() {
        val reaction = reactor1.reactOn(defMessage)

        assert(reaction == defReaction)
    }

    @Test
    fun `check if the sum of two reactions return the right result`() {
        val expectedReaction = Reaction(8)
        val initReaction = Reaction(3)
        initReaction += Reaction(5)

        assert(expectedReaction == initReaction)
    }

    @Test
    fun `check if reactOnMessageAccordingRule in Reactor returns the right result`() {
        val expectedReaction = Reaction(9)
        val gotReaction = reactor1.reactOnMessageAccordingRule(defMessage) {
            if (it.title == "title") {
                Reaction(9)

            }
            else Reaction(0)
        }

        assert(expectedReaction == gotReaction)
    }

    /*
    Возможно, ее сообщение привлекло бы больше внимания, если бы было известно, что люди были
    третьими по уровню интеллекта существами на планете Земля,
    а не (как полагало большинство независимых обозревателей) вторыми.
     */

    @Test
    fun `check if the text is possible`() {
        val reactionRule : Reactor.(Message) -> Reaction = {
            val reaction = Reaction()

            if (knowledge.any { it.fact == FactNames.SmartnessOfHumans }) reaction.attention += 10
            else reaction.attention += 5

            reaction
        }
        /* reaction if reactors don't know about the right rating" */
        val reaction1 = ReactionEstimator.estimateReactionOn(defMessage, listOf(reactor1, reactor2), reactionRule)

        /* reaction if reactors know about the right rating" */
        val nReactor1 = Reactor()
        val nReactor2 = Reactor()
        nReactor1.knowledge.add(Knowledge(FactNames.SmartnessOfHumans, "2"))
        nReactor2.knowledge.add(Knowledge(FactNames.SmartnessOfHumans, "2"))

        val reaction2 = ReactionEstimator.estimateReactionOn(defMessage, listOf(nReactor1, nReactor2), reactionRule)

        assert(reaction2.attention > reaction1.attention)

    }
}