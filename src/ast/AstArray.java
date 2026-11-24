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
		System.out.print("====================== arrayTypedef -> ARRAY ID EQ type LBRACK RBRACK SEMICOLON\n");
	}

	public void printMe()
	{
		System.out.format("AST NODE ARRAY TYPEDEF( %s )\n", name);
		elementType.printMe();

		AstGraphviz.getInstance().logNode(serialNumber, String.format("ARRAY\nTYPEDEF\n(%s)", name));
		AstGraphviz.getInstance().logEdge(serialNumber, elementType.serialNumber);
	}
}
