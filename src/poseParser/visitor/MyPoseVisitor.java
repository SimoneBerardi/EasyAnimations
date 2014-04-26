package poseParser.visitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import exceptions.DuplicateBoneException;
import exceptions.SemanticException;

import poseParser.syntaxtree.BoneDef;
import poseParser.syntaxtree.BoneName;
import poseParser.syntaxtree.Pose;
import poseParser.syntaxtree.PoseDef;
import poseParser.syntaxtree.PoseName;
import poseParser.syntaxtree.Position;

public class MyPoseVisitor extends DepthFirstVoidVisitor
{
	private easyAnimations.Pose pose;
	private List<String> errors = new ArrayList<String>();
	private String poseName;
	private easyAnimations.Position startPosition;
	private easyAnimations.Position endPosition;
	private float x,y,z;
	private String boneName;
	private easyAnimations.Bone bone;
	
	public void visit(final Pose n) {
	    // f0 -> "Pose"
	    n.f0.accept(this);
	    // f1 -> PoseName()
	    n.f1.accept(this);
	    // f2 -> PoseDef()
	    n.f2.accept(this);
	  }

	 public void visit(final PoseDef n) {
		    // f0 -> <LPAR>
		    n.f0.accept(this);
		    pose = new easyAnimations.Pose(poseName);
		    // f1 -> ( #0 BoneName() #1 BoneDef() )+
		    n.f1.accept(this);
		    // f2 -> <RPAR>
		    n.f2.accept(this);
		  }

		  public void visit(final BoneName n) {
		    // f0 -> ( %00 "HEAD:"
		    // .. .. | %01 "CHEST:"
		    // .. .. | %02 "R SHOULDER:"
		    // .. .. | %03 "L SHOULDER:"
		    // .. .. | %04 "UPPER R ARM:"
		    // .. .. | %05 "LOWER R ARM:"
		    // .. .. | %06 "UPPER L ARM:"
		    // .. .. | %07 "LOWER L ARM:"
		    // .. .. | %08 "R HIP:"
		    // .. .. | %09 "L HIP:"
		    // .. .. | %10 "UPPER R LEG:"
		    // .. .. | %11 "LOWER R LEG:"
		    // .. .. | %12 "UPPER L LEG:"
		    // .. .. | %13 "LOWER L LEG:" )
		    n.f0.accept(this);
		    
		    boneName = ((poseParser.syntaxtree.NodeToken) n.f0.choice).tokenImage;
		  }

		  public void visit(final BoneDef n) {
		    // f0 -> Position()
		    n.f0.accept(this);
		    startPosition = new easyAnimations.Position(x,y,z);
		    // f1 -> ","
		    n.f1.accept(this);
		    // f2 -> Position()
		    n.f2.accept(this);
		    endPosition = new easyAnimations.Position(x,y,z);
		    bone = new easyAnimations.Bone(boneName, startPosition, endPosition);
		    try {
				pose.addBone(bone);
			} catch (DuplicateBoneException e) {
				errors.add(e.getMessage());
			}
		  }


		  public void visit(final Position n)
		  {
			    // f0 -> "("
			    n.f0.accept(this);
			    // f1 -> <FLOAT>
			    n.f1.accept(this);
			    x = new Float(n.f1.tokenImage);
			    // f2 -> ","
			    n.f2.accept(this);
			    // f3 -> <FLOAT>
			    n.f3.accept(this);
			    y = new Float(n.f3.tokenImage);
			    // f4 -> ","
			    n.f4.accept(this);
			    // f5 -> <FLOAT>
			    n.f5.accept(this);
			    z = new Float(n.f5.tokenImage);
			    // f6 -> ")"
			    n.f6.accept(this);
			  }

	  public void visit(final PoseName n) {
	    // f0 -> ( <STRING> )+
		  poseName = "";
		  n.f0.accept(this);
		  Iterator<poseParser.syntaxtree.INode> it = n.f0.nodes.iterator();
		  while (it.hasNext())
		  {
			  poseParser.syntaxtree.INode node = it.next();
			  poseName += node.toString() + " ";
		  }
	  }
	  
	  public easyAnimations.Pose getEvaluation(Pose pose) throws SemanticException
	  {
		  pose.accept(this);
		  if(!errors.isEmpty())
			  throw new SemanticException(errors);
		  return this.pose;
	  }
}
