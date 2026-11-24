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
		System.out.print("====================== program -> dec\n");
	}

	public AstProgram addPr(AstDec d)
	{
		decs.add(d);
		System.out.print("====================== program -> program dec\n");
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
