package ast;

public class AstStmtVarDec extends AstStmt
{
	public AstVarDec dec;

	public AstStmtVarDec(AstVarDec dec)
	{
		serialNumber = AstNodeSerialNumber.getFresh();
		this.dec = dec;
		System.out.print("====================== stmt -> varDec\n");
	}

	public void printMe()
	{
		System.out.print("AST NODE VAR DEC STMT\n");
		dec.printMe();

		AstGraphviz.getInstance().logNode(serialNumber, "VAR DEC\nSTMT");
		AstGraphviz.getInstance().logEdge(serialNumber, dec.serialNumber);
	}
}
