package ast;

public class AstFuncDec extends AstDec
{
	public AstType returnType;
	public String name;
	public AstParamList params;   // nullable — null means zero parameters
	public AstStmtList body;

	public AstFuncDec(AstType returnType, String name, AstParamList params, AstStmtList body)
	{
		serialNumber = AstNodeSerialNumber.getFresh();
		this.returnType = returnType;
		this.name = name;
		this.params = params;
		this.body = body;

		if (params == null)
			System.out.print("====================== funcDec -> type ID LPAREN RPAREN LBRACE stmts RBRACE\n");
		else
			System.out.print("====================== funcDec -> type ID LPAREN paramList RPAREN LBRACE stmts RBRACE\n");
	}

	public void printMe()
	{
		System.out.format("AST NODE FUNC DEC( %s )\n", name);

		returnType.printMe();
		if (params != null) params.printMe();
		body.printMe();

		AstGraphviz.getInstance().logNode(serialNumber, String.format("FUNC\nDEC\n(%s)", name));
		AstGraphviz.getInstance().logEdge(serialNumber, returnType.serialNumber);
		if (params != null) AstGraphviz.getInstance().logEdge(serialNumber, params.serialNumber);
		AstGraphviz.getInstance().logEdge(serialNumber, body.serialNumber);
	}
}
