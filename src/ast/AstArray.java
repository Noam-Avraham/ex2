package ast;

public class AstArray extends AstDec
{
	public String name;
	public AstType elementType;

	public AstArray(String name, AstType elementType)
	{
		serialNumber = AstNodeSerialNumber.getFresh();
		this.name = name;
		this.elementType = elementType;
	}

	public void printMe()
	{
		System.out.format("AST NODE ARRAY TYPEDEF( %s )\n", name);
		elementType.printMe();

		AstGraphviz.getInstance().logNode(serialNumber, String.format("ARRAY\nTYPEDEF\n(%s)", name));
		AstGraphviz.getInstance().logEdge(serialNumber, elementType.serialNumber);
	}
}
