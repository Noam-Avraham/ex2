package ast;

public class AstTypeInt extends AstType
{
	public AstTypeInt(int line)
	{
		serialNumber = AstNodeSerialNumber.getFresh();
		this.line = line;
		System.out.print("====================== type -> TYPE_INT\n");
	}

	public void printMe()
	{
		System.out.print("AST NODE TYPE INT\n");
		AstGraphviz.getInstance().logNode(serialNumber, "TYPE\nINT");
	}
}
