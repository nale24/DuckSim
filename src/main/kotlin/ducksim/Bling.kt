package ducksim

import java.awt.Color

abstract class Bling
    (val duck: Duck) : Duck() {
    init {
        flyBehavior = duck.flyBehavior
        quackBehavior = duck.quackBehavior
    }

    override val color: Color
        get() = duck.color

    override fun display(): String {
        return duck.display() + ":"
    }

}