package ast;

public class AstStmtReturn extends AstStmt
{
	public AstExp exp;   // nullable — null means bare "return;"

	public AstStmtReturn(AstExp exp)
	{
		serialNumber = AstNodeSerialNumber.getFresh();
		this.exp = exp;
	}

	public void printMe()
	{
		System.out.print("AST NODE RETURN STMT\n");
		if (exp != null) exp.printMe();

		AstGraphviz.getInstance().logNode(serialNumber, "RETURN");
		if (exp != null) AstGraphviz.getInstance().logEdge(serialNumber, exp.serialNumber);
	}
}
