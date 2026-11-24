package ast;

public class AstTypeId extends AstType
{
	public String name;

	public AstTypeId(String name, int line)
	{
		serialNumber = AstNodeSerialNumber.getFresh();
		this.name = name;
		this.line = line;
		System.out.format("====================== type -> ID( %s )\n", name);
	}

	public void printMe()
	{
		System.out.format("AST NODE TYPE ID( %s )\n", name);
		AstGraphviz.getInstance().logNode(serialNumber, String.format("TYPE\nID\n(%s)", name));
	}
}
