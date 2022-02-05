package ducksim

import java.awt.Color

class GooseDuck(private val goose: Goose) : Duck(FlyWithWings(), QuackHonk()) {

    override val color: Color = Color.BLUE
    override var quackText: String = goose.honkText
    override fun display() = goose.name
}