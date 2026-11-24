package ast;
import java.util.ArrayList;
import java.util.List;

public class AstParamList extends AstNode
{
	public List<AstParam> params = new ArrayList<AstParam>();

	public AstParamList(AstParam first)
	{
		serialNumber = AstNodeSerialNumber.getFresh();
		params.add(first);
	}

	public AstParamList addP(AstParam p)
	{
		params.add(p);
		return this;
	}

	public void printMe()
	{
		System.out.print("AST NODE PARAM LIST\n");
		for (AstParam p : params) p.printMe();

		AstGraphviz.getInstance().logNode(serialNumber, "PARAM\nLIST");
		for (AstParam p : params) AstGraphviz.getInstance().logEdge(serialNumber, p.serialNumber);
	}
}
