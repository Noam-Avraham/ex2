package ast;
import java.util.ArrayList;
import java.util.List;

public class AstProgram extends AstNode
{
	public List<AstDec> decs = new ArrayList<AstDec>();

	public AstProgram(AstDec first)
	{
		serialNumber = AstNodeSerialNumber.getFresh();
		decs.add(first);
	}

	public AstProgram addPr(AstDec d)
	{
		decs.add(d);
		return this;
	}

	public void printMe()
	{
		System.out.print("AST NODE PROGRAM\n");
		for (AstDec d : decs) d.printMe();

		AstGraphviz.getInstance().logNode(serialNumber, "PROGRAM");
		for (AstDec d : decs) AstGraphviz.getInstance().logEdge(serialNumber, d.serialNumber);
	}
}
