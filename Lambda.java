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
 * Represents a Lambda term
 *
 * @assoc - - - LambdaVisitor
 * @composed - display 0..1 VisibleEntity
 * @opt nodefillcolor "#ddddff"
 */
class LambdaTerm {
	public abstract void accept(LambdaVisitor v);

	public void registerObserver(LambdaTermObserver o) {}
	public void unregisterObserver(LambdaTermObserver o) {}
	public void notifyAppears() {}
	public void notifyDisappears() {}
	public void notifyColorChange() {}

	/**
	 * Performs a single beta-reduction on the lambda term.
	 *
	 * @returns   itself if no reduction was performed,
	 *            another LambdaTerm if the node is to be exchanged, or
	 *            null if some reduction happened deeper in the term.
	 */
	public LambdaTerm oneBetaReduction() { return this; }

	/*
	 * Tries to apply itself unto the argument.
	 *
	 * @ returns   itself application was not possible, or
	 *             another term to be substituted for.
	 */
	public LambdaTerm apply(LambdaTerm rhs) { return this; }
}

/**
 * Represents a Lambda term with a name
 *
 * @opt nodefillcolor "#ddddff"
 */
abstract class NamedLambdaTerm extends LambdaTerm {
	String name;
}

/**
 * Represents a Lambda Abstraction
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
 * Represents a Lambda Application
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
 * Represents a Lambda Variable
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
	void nameChanged(LambdaTerm t, string before);
}

/** VIEW **/

/**
 * @composed - entities * VisibleEntity
 * @opt nodefillcolor "#ccffff"
 */
class AndroidView {
	private List<VisibleEntity> entities;
}

/**
 * Represents an entity which is visible on the screen.
 *
 * @opt nodefillcolor "#ccffff"
 */
abstract class VisibleEntity implements LambdaTermObserver {
	public void exchangedFor(LambdaTerm t, LambdaTerm replacement);
	public void disappeared(LambdaTerm t);
	public void nameChanged(LambdaTerm t, string before);
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
 */
class Keyboard extends EventSource {
}

/**
 * @opt nodefillcolor "#ffffcc"
 */
class GameEvents extends EventSource implements LambdaTermObserver {
	public void exchangedFor(LambdaTerm t, LambdaTerm replacement);
	public void disappeared(LambdaTerm t);
	public void nameChanged(LambdaTerm t, string before);
}

/**
 * @opt nodefillcolor "#ffffcc"
 */
class TouchPad extends EventSource {
}
