package ast;

public class AstParam extends AstNode
{
	public AstType type;
	public String name;

	public AstParam(AstType type, String name, int line)
	{
		serialNumber = AstNodeSerialNumber.getFresh();
		this.type = type;
		this.name = name;
		this.line = line;
		System.out.print("====================== param -> type ID\n");
	}

	public void printMe()
	{
		System.out.format("AST NODE PARAM( %s )\n", name);
		type.printMe();
		AstGraphviz.getInstance().logNode(serialNumber, String.format("PARAM\n(%s)", name));
		AstGraphviz.getInstance().logEdge(serialNumber, type.serialNumber);
	}
}
