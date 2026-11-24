package ast;

public class AstStmtReturn extends AstStmt
{
	public AstExp exp;   // nullable — null means bare "return;"

	public AstStmtReturn(AstExp exp, int line)
	{
		serialNumber = AstNodeSerialNumber.getFresh();
		this.exp = exp;
		this.line = line;

		if (exp == null)
			System.out.print("====================== stmt -> RETURN SEMICOLON\n");
		else
			System.out.print("====================== stmt -> RETURN exp SEMICOLON\n");
	}

	public void printMe()
	{
		System.out.print("AST NODE RETURN STMT\n");
		if (exp != null) exp.printMe();

		AstGraphviz.getInstance().logNode(serialNumber, "RETURN");
		if (exp != null) AstGraphviz.getInstance().logEdge(serialNumber, exp.serialNumber);
	}
}
