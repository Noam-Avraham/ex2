package ast;

public class AstTypeString extends AstType
{
	public AstTypeString()
	{
		serialNumber = AstNodeSerialNumber.getFresh();
	}

	public void printMe()
	{
		System.out.print("AST NODE TYPE STRING\n");
		AstGraphviz.getInstance().logNode(serialNumber, "TYPE\nSTRING");
	}
}
