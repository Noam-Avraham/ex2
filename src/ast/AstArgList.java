package ast;
import java.util.ArrayList;
import java.util.List;

public class AstArgList extends AstNode
{
	public List<AstExp> args = new ArrayList<AstExp>();

	public AstArgList(AstExp first)
	{
		serialNumber = AstNodeSerialNumber.getFresh();
		args.add(first);
		System.out.print("====================== argList -> exp\n");
	}

	public AstArgList addArg(AstExp e)
	{
		args.add(e);
		System.out.print("====================== argList -> argList COMMA exp\n");
		return this;
	}

	public void printMe()
	{
		System.out.print("AST NODE ARG LIST\n");
		for (AstExp e : args) e.printMe();

		AstGraphviz.getInstance().logNode(serialNumber, "ARG\nLIST");
		for (AstExp e : args) AstGraphviz.getInstance().logEdge(serialNumber, e.serialNumber);
	}
}
