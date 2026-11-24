package ast;

public class AstClassDec extends AstDec
{
	public String name;
	public String parentName;   // nullable — null means no EXTENDS
	public AstCfieldList fields;

	public AstClassDec(String name, AstCfieldList fields)
	{
		serialNumber = AstNodeSerialNumber.getFresh();
		this.name = name;
		this.parentName = null;
		this.fields = fields;
		System.out.print("====================== classDec -> CLASS ID LBRACE cfieldList RBRACE\n");
	}

	public AstClassDec(String name, String parentName, AstCfieldList fields)
	{
		serialNumber = AstNodeSerialNumber.getFresh();
		this.name = name;
		this.parentName = parentName;
		this.fields = fields;
		System.out.print("====================== classDec -> CLASS ID EXTENDS ID LBRACE cfieldList RBRACE\n");
	}

	public void printMe()
	{
		System.out.format("AST NODE CLASS DEC( %s )\n", name);

		fields.printMe();

		AstGraphviz.getInstance().logNode(serialNumber, String.format("CLASS\nDEC\n(%s)", name));
		AstGraphviz.getInstance().logEdge(serialNumber, fields.serialNumber);
	}
}
