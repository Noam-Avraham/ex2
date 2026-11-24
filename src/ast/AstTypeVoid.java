package ast;

public class AstTypeVoid extends AstType
{
	public AstTypeVoid()
	{
		serialNumber = AstNodeSerialNumber.getFresh();
	}

	public void printMe()
	{
		System.out.print("AST NODE TYPE VOID\n");
		AstGraphviz.getInstance().logNode(serialNumber, "TYPE\nVOID");
	}
}
