package ast;

public class AstStmtWhile extends AstStmt
{
	public AstExp cond;
	public AstStmtList body;

	/*******************/
	/*  CONSTRUCTOR(S) */
	/*******************/
	public AstStmtWhile(AstExp cond, AstStmtList body)
	{
		serialNumber = AstNodeSerialNumber.getFresh();
		this.cond = cond;
		this.body = body;
	}

	public void printMe()
	{
		System.out.print("AST NODE WHILE STMT\n");

		cond.printMe();
		body.printMe();

		AstGraphviz.getInstance().logNode(serialNumber, "WHILE\n");
		AstGraphviz.getInstance().logEdge(serialNumber, cond.serialNumber);
		AstGraphviz.getInstance().logEdge(serialNumber, body.serialNumber);
	}
}