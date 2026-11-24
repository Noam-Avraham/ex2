package ast;

public class AstTypeVoid extends AstType
{
	public AstTypeVoid(int line)
	{
		serialNumber = AstNodeSerialNumber.getFresh();
		this.line = line;
		System.out.print("====================== type -> TYPE_VOID\n");
	}

	public void printMe()
	{
		System.out.print("AST NODE TYPE VOID\n");
		AstGraphviz.getInstance().logNode(serialNumber, "TYPE\nVOID");
	}
}
