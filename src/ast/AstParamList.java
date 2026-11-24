package ast;
import java.util.ArrayList;
import java.util.List;

public class AstParamList extends AstNode
{
	public List<AstParam> params = new ArrayList<AstParam>();

	public AstParamList(AstParam first, int line)
	{
		serialNumber = AstNodeSerialNumber.getFresh();
		this.line = line;
		params.add(first);
		System.out.print("====================== paramList -> param\n");
	}

	public AstParamList addP(AstParam p)
	{
		params.add(p);
		System.out.print("====================== paramList -> paramList COMMA param\n");
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
