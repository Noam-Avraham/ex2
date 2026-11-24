package ast;

public class AstStmtVarDec extends AstStmt
{
	public AstVarDec dec;

	public AstStmtVarDec(AstVarDec dec, int line)
	{
		serialNumber = AstNodeSerialNumber.getFresh();
		this.dec = dec;
		this.line = line;
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
