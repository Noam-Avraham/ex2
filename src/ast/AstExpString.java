package ast;

public class AstExpString extends AstExp
{
	public String value;

	public AstExpString(String value, int line)
	{
		serialNumber = AstNodeSerialNumber.getFresh();
		this.value = value;
		this.line = line;
		System.out.format("====================== exp -> STRING( %s )\n", value);
	}

	public void printMe()
	{
		System.out.format("AST NODE STRING( %s )\n", value);
		AstGraphviz.getInstance().logNode(serialNumber, String.format("STRING\n(%s)", value));
	}
}
