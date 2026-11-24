package ast;

public class AstGeneralExp extends AstExp
{
	public AstType type;
	public AstExp sizeExp;   // null = "new type" (object), not-null = "new type[size]" (array)

	public AstGeneralExp(AstType type)
	{
		serialNumber = AstNodeSerialNumber.getFresh();
		this.type = type;
		this.sizeExp = null;
		System.out.print("====================== newExp -> NEW type\n");
	}

	public AstGeneralExp(AstType type, AstExp sizeExp)
	{
		serialNumber = AstNodeSerialNumber.getFresh();
		this.type = type;
		this.sizeExp = sizeExp;
		System.out.print("====================== newExp -> NEW type LBRACK exp RBRACK\n");
	}

	public void printMe()
	{
		System.out.print("AST NODE NEW EXP\n");
		type.printMe();
		if (sizeExp != null) sizeExp.printMe();

		AstGraphviz.getInstance().logNode(serialNumber, "NEW");
		AstGraphviz.getInstance().logEdge(serialNumber, type.serialNumber);
		if (sizeExp != null) AstGraphviz.getInstance().logEdge(serialNumber, sizeExp.serialNumber);
	}
}
