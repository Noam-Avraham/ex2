package ast;

public class AstExpString extends AstExp
{
	public String value;

	public AstExpString(String value)
	{
		serialNumber = AstNodeSerialNumber.getFresh();
		this.value = value;
		System.out.format("====================== exp -> STRING( %s )\n", value);
	}

	public void printMe()
	{
		System.out.format("AST NODE STRING( %s )\n", value);
		AstGraphviz.getInstance().logNode(serialNumber, String.format("STRING\n(%s)", value));
	}
}
