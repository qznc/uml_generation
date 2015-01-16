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
 * @hidden
 */
class UMLOptions {}

/**
 * @assoc - - - LambdaVisitor
 */
abstract class LambdaTerm {
	abstract void accept(LambdaVisitor v);
}

abstract class NamedLambdaTerm extends LambdaTerm {
	String name;
}

/**
 * @composed - body - LambdaTerm
 */
class Abstraction extends NamedLambdaTerm {
	public void accept(LambdaVisitor v) {}
}

/**
 * @composed - left - LambdaTerm
 * @composed - right - LambdaTerm
 */
class Application extends LambdaTerm {
	public void accept(LambdaVisitor v) {}
}

class Variable extends NamedLambdaTerm {
	public void accept(LambdaVisitor v) {}
}

/* VISITOR STUFF */

interface LambdaVisitor {
	void visitAbstraction(Abstraction a);
	void visitApplication(Application a);
	void visitVariable(Variable v);
}

class BetaReduction implements LambdaVisitor {
	public void visitAbstraction(Abstraction a) {}
	public void visitApplication(Application a) {}
	public void visitVariable(Variable v) {}
}

class AlphaConversion implements LambdaVisitor {
	public void visitAbstraction(Abstraction a) {}
	public void visitApplication(Application a) {}
	public void visitVariable(Variable v) {}
}
