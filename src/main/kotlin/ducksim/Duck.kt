package ducksim

import java.awt.Color
import java.util.*

abstract class Duck(
    val defaultFlyBehavior: FlyBehavior = FlyWithWings(),
    open val defaultQuackBehavior: QuackBehavior = QuackNormal()
) : Observer {

    // values that can be overridden

    open val color: Color = Color.BLACK
    open var quackText: String = defaultQuackBehavior.getQuack()

    // variables that can be changed only by functions in this class

    var state = State.SWIMMING
        private set
    var isFree = true
        private set
    var isOnDSWC = false
        private set
    var flyBehavior: FlyBehavior = defaultFlyBehavior
        protected set
    var quackBehavior: QuackBehavior = defaultQuackBehavior

    // function for setting the state back to its default (swimming)

    fun swim() {
        state = State.SWIMMING
    }

    // functions from the context menu

    open fun fly() {
        state = flyBehavior.state
    }

    open fun quack() {
        state = quackBehavior.state
    }

    open val joinDSWC = object : DuckMenuItem {
        override fun invoke() {
            doJoinDSWC()
        }
    }

    fun doJoinDSWC() {
        DuckFactory.registerObserver(this@Duck)
        isOnDSWC = true
    }

    open val quitDSWC = object : DuckMenuItem {
        override fun invoke() {
            doQuitDSWC()
        }
    }

    fun doQuitDSWC() {
        DuckFactory.removeObserver(this@Duck)
        isOnDSWC = false
    }

    open val capture = object : DuckMenuItem {
        override fun invoke() {
            doCapture()
        }
    }

    fun doCapture() {
        isFree = false
        flyBehavior = FlyNoWay()
        quackBehavior = QuackNoWay()
    }

    open val release = object : DuckMenuItem {
        override fun invoke() {
            doRelease()
        }
    }

    fun doRelease() {
        isFree = true
        flyBehavior = defaultFlyBehavior
        quackBehavior = defaultQuackBehavior
        quackText = quackBehavior.getQuack()
    }


    // abstract display function that must be implemented by concrete classes

    abstract fun display(): String

    /**
     * This method is called whenever the observed object is changed. An
     * application calls an `Observable` object's
     * `notifyObservers` method to have all the object's
     * observers notified of the change.
     *
     * @param   o     the observable object.
     * @param   arg   an argument passed to the `notifyObservers`
     * method.
     */
    override fun update() {
        state = State.WELCOMING
    }
}
