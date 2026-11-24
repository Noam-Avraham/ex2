package ast;
import java.util.ArrayList;
import java.util.List;

public class AstProgram extends AstNode
{
	public List<AstDec> decs = new ArrayList<AstDec>();

	public AstProgram(AstDec first, int line)
	{
		serialNumber = AstNodeSerialNumber.getFresh();
		this.line = line;
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
