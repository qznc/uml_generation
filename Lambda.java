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
	public void accept(LambdaVisitor v) {}
}

/**
 * Represents a Lambda Application
 *
 * @composed - left - LambdaTerm
 * @composed - right - LambdaTerm
 * @opt nodefillcolor "#ddddff"
 */
class Application extends LambdaTerm {
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
class BetaReduction implements LambdaVisitor {
	public void visitAbstraction(Abstraction a) {}
	public void visitApplication(Application a) {}
	public void visitVariable(Variable v) {}
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
	void appears(LambdaTerm t);
	void disappears(LambdaTerm t);
	void nameChange(LambdaTerm t);
}

/** VIEW **/

/**
 * @composed - entities * VisibleEntity
 * @opt nodefillcolor "#ccffff"
 */
class AndroidView {
	private List<VisibleEntity> entities;

	public void appears(LambdaTerm t);
	public void disappears(LambdaTerm t);
	public void nameChange(LambdaTerm t);
}

/**
 * Represents an entity which is visible on the screen.
 *
 * @opt nodefillcolor "#ccffff"
 */
abstract class VisibleEntity implements LambdaTermObserver {
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
	public void appears(LambdaTerm t);
	public void disappears(LambdaTerm t);
	public void nameChange(LambdaTerm t);
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
}

/**
 * @opt nodefillcolor "#ffffcc"
 */
class TouchPad extends EventSource {
}
