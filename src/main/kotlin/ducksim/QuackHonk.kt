package ducksim

class QuackHonk : QuackBehavior {

    override val state: State
        get() = State.QUACKING

    override fun getQuack(): String {
        return "Honk!"
    }
}