package ast;

public class AstExpNil extends AstExp
{
	public AstExpNil(int line)
	{
		serialNumber = AstNodeSerialNumber.getFresh();
		this.line = line;
		System.out.print("====================== exp -> NIL\n");
	}

	public void printMe()
	{
		System.out.print("AST NODE NIL\n");
		AstGraphviz.getInstance().logNode(serialNumber, "NIL");
	}
}
