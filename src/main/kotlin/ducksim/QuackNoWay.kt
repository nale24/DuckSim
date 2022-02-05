package ducksim

class QuackNoWay : QuackBehavior {

    override val state: State = State.SWIMMING

    override fun getQuack(): String {
        return ""
    }
}