package ast;

public class AstTypeInt extends AstType
{
	public AstTypeInt()
	{
		serialNumber = AstNodeSerialNumber.getFresh();
	}

	public void printMe()
	{
		System.out.print("AST NODE TYPE INT\n");
		AstGraphviz.getInstance().logNode(serialNumber, "TYPE\nINT");
	}
}
