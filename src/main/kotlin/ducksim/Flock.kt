package ducksim

class Flock(val children: List<Duck>) : Duck() {

    override val defaultQuackBehavior: QuackBehavior
        get() = QuackNoise()

    override val joinDSWC = object : DuckMenuItem {
        override fun invoke() {
            children.forEach() {
                it.joinDSWC()
            }
            doJoinDSWC()
        }
    }

    override val quitDSWC = object : DuckMenuItem {
        override fun invoke() {
            children.forEach() {
                it.quitDSWC()
            }
            doQuitDSWC()
        }
    }

    override val capture = object : DuckMenuItem {
        override fun invoke() {
            children.forEach() {
                it.doCapture()
            }
            doCapture()
        }
    }

    override val release = object : DuckMenuItem {
        override fun invoke() {
            children.forEach() {
                it.doRelease()
            }
            doRelease()
        }
    }

    override fun display(): String {
        var displayText: String = "Flock"
        children.forEach() {
            displayText += ":" + it.display().first()
        }
        return displayText
    }
}