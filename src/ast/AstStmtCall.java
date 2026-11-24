package ast;

public class AstStmtCall extends AstStmt
{
	public AstCallExp call;

	public AstStmtCall(AstCallExp call, int line)
	{
		serialNumber = AstNodeSerialNumber.getFresh();
		this.call = call;
		this.line = line;
		System.out.print("====================== stmt -> callExp SEMICOLON\n");
	}

	public void printMe()
	{
		System.out.print("AST NODE CALL STMT\n");
		call.printMe();

		AstGraphviz.getInstance().logNode(serialNumber, "CALL\nSTMT");
		AstGraphviz.getInstance().logEdge(serialNumber, call.serialNumber);
	}
}
