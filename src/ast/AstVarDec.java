package ast;

public class AstVarDec extends AstDec
{
	public AstType type;
	public String name;
	public AstExp init;   // nullable — no initializer, exp initializer, or newExp initializer

	public AstVarDec(AstType type, String name, AstExp init)
	{
		serialNumber = AstNodeSerialNumber.getFresh();
		this.type = type;
		this.name = name;
		this.init = init;
	}

	public void printMe()
	{
		System.out.format("AST NODE VAR DEC( %s )\n", name);

		type.printMe();
		if (init != null) init.printMe();

		AstGraphviz.getInstance().logNode(serialNumber, String.format("VAR\nDEC\n(%s)", name));
		AstGraphviz.getInstance().logEdge(serialNumber, type.serialNumber);
		if (init != null) AstGraphviz.getInstance().logEdge(serialNumber, init.serialNumber);
	}
}
