package ast;

public class AstStmtIf extends AstStmt
{
	public AstExp cond;
	public AstStmtList body;
	public AstStmtList elseBody;   // null = no else branch

	/*******************/
	/*  CONSTRUCTOR(S) */
	/*******************/
	public AstStmtIf(AstExp cond, AstStmtList body, AstStmtList elseBody)
	{
		serialNumber = AstNodeSerialNumber.getFresh();
		this.cond = cond;
		this.body = body;
		this.elseBody = elseBody;
	}

	public void printMe()
	{
		System.out.print("AST NODE IF STMT\n");

		cond.printMe();
		body.printMe();
		if (elseBody != null) elseBody.printMe();

		AstGraphviz.getInstance().logNode(serialNumber, "IF\n");
		AstGraphviz.getInstance().logEdge(serialNumber, cond.serialNumber);
		AstGraphviz.getInstance().logEdge(serialNumber, body.serialNumber);
		if (elseBody != null) AstGraphviz.getInstance().logEdge(serialNumber, elseBody.serialNumber);
	}
}