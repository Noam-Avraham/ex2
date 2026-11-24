package ast;

public class AstTypeString extends AstType
{
	public AstTypeString(int line)
	{
		serialNumber = AstNodeSerialNumber.getFresh();
		this.line = line;
		System.out.print("====================== type -> TYPE_STRING\n");
	}

	public void printMe()
	{
		System.out.print("AST NODE TYPE STRING\n");
		AstGraphviz.getInstance().logNode(serialNumber, "TYPE\nSTRING");
	}
}
