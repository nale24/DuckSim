package ducksim

object DuckFactory : Subject {
    private val observers: MutableSet<Observer> = mutableSetOf<Observer>()

    fun createDuck(duckType: String, starCount: Int, moonCount: Int, crossCount: Int): Duck {
        var currDuck: Duck = when (duckType) {
            "Mallard" -> MallardDuck()
            "Redhead" -> RedheadDuck()
            "Rubber" -> RubberDuck()
            "Decoy" -> DecoyDuck()
            "Goose" -> GooseDuck(Goose())
            else -> MallardDuck()
        }

        repeat(starCount) {
            currDuck = StarBling(currDuck)
        }
        repeat(moonCount) {
            currDuck = MoonBling(currDuck)
        }
        repeat(crossCount) {
            currDuck = CrossBling(currDuck)
        }
        return currDuck
    }

    override fun registerObserver(o: Observer) {
        observers.add(o)
    }

    override fun removeObserver(o: Observer) {
        observers.remove(o)
    }

    override fun notifyObservers() {
        observers.forEach() {
            it.update()
        }
    }
}
