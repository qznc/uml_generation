import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * General options
 *
 * @opt operations
 * @opt attributes
 * @opt types
 * @opt visibility
 * @opt constructors
 * @opt qualify
 *
 * @hidden
 */
class UMLOptions {}

/**
 * A term as it occurs within simple untyped lambda calculus.
 *
 * @assoc - - - LambdaVisitor
 * @composed - display 0..1 VisibleEntity
 * @opt nodefillcolor "#ddddff"
 */
class LambdaTerm {
	public abstract void accept(LambdaVisitor v);

	public void registerObserver(LambdaTermObserver o) {}
	public void unregisterObserver(LambdaTermObserver o) {}
	public void notifyExchange() {}
	public void notifyDisappears() {}
	public void notifyNameChange() {}

	/**
	 * Performs a single beta-reduction on the lambda term.
	 *
	 * @return   itself if no reduction was performed,
	 *           another <code>LambdaTerm</code> if the node is to be exchanged, or
	 *           <code>null</code> if some reduction happened deeper in the term.
	 */
	public LambdaTerm oneBetaReduction() { return this; }

	/*
	 * Tries to apply itself unto the argument.
	 *
	 * @return   itself application was not possible, or
	 *           another <code>LambdaTerm</code> to be substituted for.
	 */
	public LambdaTerm apply(LambdaTerm rhs) { return this; }
}

/**
 * A term with a name.
 *
 * @opt nodefillcolor "#ddddff"
 */
abstract class NamedLambdaTerm extends LambdaTerm {
	String name;
}

/**
 * A lambda abstraction represents a function.
 *
 * For example, as a function it can be applied to an argument,
 * another <code>LambdaTerm</code> object.
 *
 * @composed - body - LambdaTerm
 * @opt nodefillcolor "#ddddff"
 */
class Abstraction extends NamedLambdaTerm {
	private LambdaTerm body;

	public void accept(LambdaVisitor v) {}
	public LambdaTerm oneBetaReduction() {}
	public LambdaTerm apply(LambdaTerm rhs) {}
}

/**
 * A lambda application contains two terms, left and right.
 *
 * Via beta-reduction it can apply the left term unto the right.
 *
 * @composed - left - LambdaTerm
 * @composed - right - LambdaTerm
 * @opt nodefillcolor "#ddddff"
 */
class Application extends LambdaTerm {
	public LambdaTerm oneBetaReduction() {}
	public void accept(LambdaVisitor v) {}
}

/**
 * A lambda variable can be exchanged for other terms.
 *
 * It is considered "bound", if it has a parent abstraction with the same name.
 * The inverse "unbound" variables are also called "free" variables.
 *
 * @opt nodefillcolor "#ddddff"
 */
class Variable extends NamedLambdaTerm {
	public void accept(LambdaVisitor v) {}
}

/* VISITOR STUFF */

/**
 * @opt nodefillcolor "#ddddff"
 */
interface LambdaVisitor {
	void visitAbstraction(Abstraction a);
	void visitApplication(Application a);
	void visitVariable(Variable v);
}

/**
 * @opt nodefillcolor "#ddddff"
 */
class AlphaConversion implements LambdaVisitor {
	public AlphaConversion(String before, String after) {}
	public void visitAbstraction(Abstraction a) {}
	public void visitApplication(Application a) {}
	public void visitVariable(Variable v) {}
}

/**
 * Collects all abstraction and variable names within a lambda term.
 * @opt nodefillcolor "#ddddff"
 */
class NameCollector implements LambdaVisitor {
	public void visitAbstraction(Abstraction a) {}
	public void visitApplication(Application a) {}
	public void visitVariable(Variable v) {}
}

/**
 * @assoc - - - LambdaTerm
 * @opt nodefillcolor "#ddddff"
 */
interface LambdaTermObserver {
	void exchangedFor(LambdaTerm t, LambdaTerm replacement);
	void disappeared(LambdaTerm t);
	void nameChanged(LambdaTerm t, String before);
}

/** VIEW **/

/**
 * @composed - entities * VisibleEntity
 * @opt nodefillcolor "#ccffff"
 */
class EvaluationView extends AndroidView {
	private List<VisibleEntity> entities;
}

/**
 * @opt nodefillcolor "#ccffff"
 */
class MenuView extends AndroidView { }

/**
 * @opt nodefillcolor "#ccffff"
 */
class SettingsView extends AndroidView { }

/**
 * Represents an entity which is visible on the screen.
 *
 * @opt nodefillcolor "#ccffff"
 */
abstract class VisibleEntity implements LambdaTermObserver {
	public void exchangedFor(LambdaTerm t, LambdaTerm replacement);
	public void disappeared(LambdaTerm t);
	public void nameChanged(LambdaTerm t, String before);
}

/**
 * @opt nodefillcolor "#ccffff"
 */
class Alligator extends VisibleEntity { }

/**
 * @opt nodefillcolor "#ccffff"
 */
class Egg extends VisibleEntity { }

/**
 * @opt nodefillcolor "#ccffff"
 */
class OldAlligator extends VisibleEntity { }

/** CONTROLLER **/

/**
 * @composed - - 1 EventSource
 * @composed - displays 1 LambdaTerm
 * @opt nodefillcolor "#ffffcc"
 */
class Controller {
}

/**
 * Represents a way how events occur, which change the game state.
 *
 * @opt nodefillcolor "#ffffcc"
 */
abstract class EventSource {
}

/**
 * @opt nodefillcolor "#ffffcc"
 * @composed - - 1 AndroidTextInput
 */
class Keyboard extends EventSource {
}

/**
 * @opt nodefillcolor "#ffffcc"
 */
class GameEvents extends EventSource implements LambdaTermObserver {
	public void exchangedFor(LambdaTerm t, LambdaTerm replacement);
	public void disappeared(LambdaTerm t);
	public void nameChanged(LambdaTerm t, String before);
}

/**
 * @opt nodefillcolor "#ffffcc"
 * @composed - - 1 AndroidTouches
 */
class TouchPad extends EventSource {
}

/** EXTERNAL STUFF **/

/**
 * @opt nodefillcolor "#ffffff"
 */
abstract class AndroidView { }

/**
 * @opt nodefillcolor "#ffffff"
 */
abstract class AndroidTextInput { }

/**
 * @opt nodefillcolor "#ffffff"
 */
abstract class AndroidTouches { }
