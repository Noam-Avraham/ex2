package ast;

public class AstTypeId extends AstType
{
	public String name;

	public AstTypeId(String name)
	{
		serialNumber = AstNodeSerialNumber.getFresh();
		this.name = name;
		System.out.format("====================== type -> ID( %s )\n", name);
	}

	public void printMe()
	{
		System.out.format("AST NODE TYPE ID( %s )\n", name);
		AstGraphviz.getInstance().logNode(serialNumber, String.format("TYPE\nID\n(%s)", name));
	}
}
