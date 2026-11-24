package ast;

public class AstCallExp extends AstExp
{
	public AstVar receiver;   // nullable — null means a bare call like foo(), not obj.foo()
	public String funcName;
	public AstArgList args;   // nullable — null means zero arguments

	public AstCallExp(AstVar receiver, String funcName, AstArgList args)
	{
		serialNumber = AstNodeSerialNumber.getFresh();
		this.receiver = receiver;
		this.funcName = funcName;
		this.args = args;
	}

	public void printMe()
	{
		System.out.format("AST NODE CALL EXP( %s )\n", funcName);

		if (receiver != null) receiver.printMe();
		if (args != null) args.printMe();

		AstGraphviz.getInstance().logNode(serialNumber, String.format("CALL\n(%s)", funcName));
		if (receiver != null) AstGraphviz.getInstance().logEdge(serialNumber, receiver.serialNumber);
		if (args != null) AstGraphviz.getInstance().logEdge(serialNumber, args.serialNumber);
	}
}
