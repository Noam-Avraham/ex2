package ast;
import java.util.ArrayList;
import java.util.List;

public class AstCfieldList extends AstNode
{
	public List<AstDec> fields = new ArrayList<AstDec>();

	public AstCfieldList(AstDec first)
	{
		serialNumber = AstNodeSerialNumber.getFresh();
		fields.add(first);
	}

	public AstCfieldList addCfield(AstDec d)
	{
		fields.add(d);
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
