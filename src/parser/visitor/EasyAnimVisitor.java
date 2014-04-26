package parser.visitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

import exceptions.*;

import parser.syntaxtree.Animation;
import parser.syntaxtree.AnimationName;
import parser.syntaxtree.Duration;

import parser.syntaxtree.AnimationDef;
import parser.syntaxtree.BoneDef;
import parser.syntaxtree.BoneName;
import parser.syntaxtree.Frame;
import parser.syntaxtree.INode;
import parser.syntaxtree.Pose;
import parser.syntaxtree.PoseDef;
import parser.syntaxtree.PoseName;
import parser.syntaxtree.Position;
import parser.syntaxtree.SubAnimation;

public class EasyAnimVisitor extends DepthFirstVoidVisitor
{
	private DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode();
	private List<String> errors = new ArrayList<String>();
	private easyAnimations.Animation rootAnimation;
	private easyAnimations.Animation parentAnimation;
	private easyAnimations.Animation currAnimation;
	private DefaultMutableTreeNode parentNode;
	private DefaultMutableTreeNode currentNode;
	private String animationName;
	private String poseName;
	private String boneName;
	private easyAnimations.Pose pose;
	private easyAnimations.Bone bone;
	private float x,y,z;
	private easyAnimations.Position startPosition;
	private easyAnimations.Position endPosition;
	private int duration;
	private int frame;
	private boolean root = true;
	
	public void visit(final Animation n) {
	    // f0 -> "Animation"
	    n.f0.accept(this);
	    // f1 -> AnimationName()
	    n.f1.accept(this);
	    // f2 -> AnimationDef()
	    n.f2.accept(this);
	  }

	  public void visit(final AnimationDef n) {
	    // f0 -> "Duration:"
	    n.f0.accept(this);
	    // f1 -> Duration()
	    n.f1.accept(this);
	    
	    if(root)
	    {
	    	//Animation creation
	    	rootAnimation = new easyAnimations.Animation(animationName, duration);
	    	currAnimation = rootAnimation;
	    	
	    	//Tree creation
	    	rootNode = new DefaultMutableTreeNode(rootAnimation);
	    	currentNode = rootNode;
	    	
	    	root = false;
	    }
	    else
	    {
	    	//Animation creation
	    	currAnimation = new easyAnimations.Animation(animationName, duration);
	    	currAnimation.setParent(parentAnimation);
	    	try {
				parentAnimation.addSubAnimation(currAnimation, frame);
			} catch (LowDurationException | DuplicateFrameElementException
					| FrameOutOfBoundsException | DuplicateNameException e) {
				errors.add(e.getMessage());
			}
	    	
	    	//Tree creation
	    	currentNode = new DefaultMutableTreeNode(currAnimation);
	    	parentNode.add(currentNode);
	    }
	    
	    // f2 -> ( #0 "SubAnimations" #1 <LPAR>
	    // .. .. . #2 ( SubAnimation() )+
	    // .. .. . #3 <RPAR> )?
	    if(n.f2.present())
	    {
	    	parentAnimation = currAnimation;
	    	parentNode = currentNode;
	    }
	    n.f2.accept(this);
	    // f3 -> "Poses"
	    n.f3.accept(this);
	    // f4 -> <LPAR>
	    n.f4.accept(this);
	    // f5 -> ( Pose() )+
	    n.f5.accept(this);
	    // f6 -> <RPAR>
	    n.f6.accept(this);
	    // f7 -> ( %0 ";"
	    // .. .. | %1 <EOF> )
	    if(n.f7.which == 0)
	    {
	    	currAnimation = parentAnimation;
	    	currentNode = parentNode;
	    	if(parentAnimation.hasParent())
	    	{
	    		parentAnimation = parentAnimation.getParent();
	    		parentNode = (DefaultMutableTreeNode) parentNode.getParent();
	    	}
	    }
	    n.f7.accept(this);
	  }

	  public void visit(final SubAnimation n) {
	    // f0 -> "Add"
	    n.f0.accept(this);
	    // f1 -> "Animation"
	    n.f1.accept(this);
	    // f2 -> AnimationName()
	    n.f2.accept(this);
	    // f3 -> "at"
	    n.f3.accept(this);
	    // f4 -> "frame"
	    n.f4.accept(this);
	    // f5 -> Frame()
	    n.f5.accept(this);
	    // f6 -> AnimationDef()
	    n.f6.accept(this);
	  }

	  public void visit(final Pose n) {
	    // f0 -> "Add"
	    n.f0.accept(this);
	    // f1 -> "Pose"
	    n.f1.accept(this);
	    // f2 -> PoseName()
	    n.f2.accept(this);
	    // f3 -> "at"
	    n.f3.accept(this);
	    // f4 -> "frame"
	    n.f4.accept(this);
	    // f5 -> Frame()
	    n.f5.accept(this);
	    // f6 -> PoseDef()
	    n.f6.accept(this);
	  }
	  
	  public void visit(final PoseDef n) {
		    // f0 -> <LPAR>
		    n.f0.accept(this);
		    
		    pose = new easyAnimations.Pose(poseName);
		    pose.setParentAnimation(currAnimation);
		   
		    // f1 -> ( #0 BoneName() #1 BoneDef() )+
		    n.f1.accept(this);
		    
		    try {
				currAnimation.addPose(pose, frame);
			} catch (LowDurationException | DuplicateFrameElementException
					| FrameOutOfBoundsException | DuplicateNameException | MissingBoneException e) {
				errors.add(e.getMessage());
			}
		    DefaultMutableTreeNode poseNode = new DefaultMutableTreeNode(pose);
		    currentNode.add(poseNode);
		    
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
		    boneName = ((parser.syntaxtree.NodeToken) n.f0.choice).tokenImage;
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

	  public void visit(final Frame n) {
	    // f0 -> <NUM>
	    n.f0.accept(this);
	    frame = new Integer(n.f0.tokenImage);
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

	  public void visit(final AnimationName n) {
		  // f0 -> ( <STRING> )+

		  animationName = "";
		  n.f0.accept(this);
		  Iterator<INode> it = n.f0.nodes.iterator();
		  while (it.hasNext())
		  {
			  INode node = it.next();
			  animationName += node.toString() + " ";
		  }
	  }

		  public void visit(final PoseName n) {
			  // f0 -> ( <STRING> )+

			  poseName = "";
			  n.f0.accept(this);
			  Iterator<INode> it = n.f0.nodes.iterator();
			  while (it.hasNext())
			  {
				  INode node = it.next();
				  poseName += node.toString() + " ";
			  }
		  }

		  public void visit(final Duration n) {
		    // f0 -> <NUM>
		    n.f0.accept(this);
		    
		    duration = new Integer(n.f0.tokenImage);
		    // f1 -> "frames"
		    n.f1.accept(this);
		  }
		  
		  public easyAnimations.Animation getEvaluation(Animation animation) throws SemanticException
		  {
			  animation.accept(this);
			 
			  try
			  {
				  rootAnimation.checkForDuplicates();
			  }
			  catch (DuplicateNameException e)
			  {
				  errors.add(e.getMessage());
			  }

			  if(!errors.isEmpty())
				  throw new SemanticException(errors);
			  return this.rootAnimation;
		  }
		  
		  public DefaultMutableTreeNode getTreeRoot()
		  {
			  return this.rootNode;
		  }
}
