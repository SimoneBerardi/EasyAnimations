/* Generated by JTB 1.4.7 */
package parser.visitor;

import parser.syntaxtree.*;

public interface IVoidVisitor {

  public void visit(final NodeChoice n);

  public void visit(final NodeList n);

  public void visit(final NodeListOptional n);

  public void visit(final NodeOptional n);

  public void visit(final NodeSequence n);

  public void visit(final NodeTCF n);

  public void visit(final NodeToken n);

  public void visit(final Animation n);

  public void visit(final AnimationDef n);

  public void visit(final SubAnimation n);

  public void visit(final Pose n);

  public void visit(final PoseDef n);

  public void visit(final BoneName n);

  public void visit(final BoneDef n);

  public void visit(final Frame n);

  public void visit(final Position n);

  public void visit(final AnimationName n);

  public void visit(final PoseName n);

  public void visit(final Duration n);

}
