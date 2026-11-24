package ast;
import java.util.ArrayList;
import java.util.List;

public class AstCfieldList extends AstNode
{
	public List<AstDec> fields = new ArrayList<AstDec>();

	public AstCfieldList(AstDec first, int line)
	{
		serialNumber = AstNodeSerialNumber.getFresh();
		this.line = line;
		fields.add(first);
		System.out.print("====================== cfieldList -> cField\n");
	}

	public AstCfieldList addCfield(AstDec d)
	{
		fields.add(d);
		System.out.print("====================== cfieldList -> cfieldList cField\n");
		return this;
	}

	public void printMe()
	{
		System.out.print("AST NODE CFIELD LIST\n");
		for (AstDec d : fields) d.printMe();

		AstGraphviz.getInstance().logNode(serialNumber, "CFIELD\nLIST");
		for (AstDec d : fields) AstGraphviz.getInstance().logEdge(serialNumber, d.serialNumber);
	}
}
