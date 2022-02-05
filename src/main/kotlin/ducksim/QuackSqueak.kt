package ducksim

class QuackSqueak : QuackBehavior {

    override val state: State
        get() = State.QUACKING

    override fun getQuack(): String {
        return "Squeak!"
    }
}