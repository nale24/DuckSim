package ducksim

interface QuackBehavior {

    val state: State

    fun getQuack(): String

}